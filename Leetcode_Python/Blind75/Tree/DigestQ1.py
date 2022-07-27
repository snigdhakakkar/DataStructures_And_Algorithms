from collections import namedtuple
from math import floor, pow, log, ceil
import random
 
### Two properties
### 1) node.count <= floor(n/k) where n = sum(f_i \all i), meaning the sum of all frequencies and k is a compression factor
### 2) node.count + node.parent.count + node.sibling.count > floor(n/k)
### root and leaf nodes are exceptions
### Property #1 means that no node should have a high count
### Property #2 means that two children (siblings) that have low count should be merged with their parent
 
class QDigest():
    """
    Implements a tree without wasting space by assuming that children can be found at index 2i, 2i+1 and parent
    is at floor(i / 2)
    """
 
    class Node():
        def __init__(self, id, is_leaf=False, initial_count=1):
            self.id = id
            self.count = initial_count
            self.is_leaf = is_leaf
 
        def inc(self, amount=1):
            self.count+=amount
 
        def __cmp__(self, other):
            return cmp(self.id, other.id)
 
        def __repr__(self):
            return "{id=%d, cnt=%d}" % (self.id, self.count)
 
        @property
        def is_root(self):
            return self.id is 1
 
        def parent_id(self):
            """ Returns the id of the parent or None if this is the root node
            """
            if self.is_root:
                return None
            return int(floor(self.id / 2.0))
 
        def children(self):
            """ Returns the ids of the left child and the right child respectively
            """
            return (2*self.id, 2*self.id + 1)
 
        def sibling_id(self):
            """ Returns the id of the sibling or None if this is the root node
            """
            if self.is_root:
                return None
 
            if self.id % 2 == 0:
                return self.id + 1
            else:
                return self.id - 1
 
    empty_node = Node(id=-1, initial_count=0)
 
    def __init__(self, universe_size, compression_factor):
        """ Defines a q-digest of specified size. Size here defines the universe, not the sum of frequencies.
         It is assumed that the first value is 1
        """
        self.size = universe_size
        self.digest = []
        self.id = 1
        self.k = compression_factor
 
    def __add__(self, other):
        """
        Operator overloading for merging two q-digests together. The two digests must have the same compression
        factor
        """
        if self.k is not other.k:
            raise ValueError("Compression factors of two digests not the same")
 
        digest = QDigest(max(self.size, other.size), self.k)
        digest.digest = self.digest[:]
        for node in other.digest:
            digest._insert_or_modify_node(node.id, node.count)
 
        digest.compress()
 
        return digest
 
    @property
    def n(self):
        """ Sum of all frequencies stored in this q-digest
        """
        return sum(x.count for x in self.digest)
 
    @property
    def height(self):
        """
        The height of the tree, used when assuming that all leaf nodes have a range [value, value]
        """
        return int(ceil(log(self.size, 2)))
 
    def _get_node(self, node_id):
        """
        Returns the node object having the specified id. If that id does not exist
        return a special node with id=-1 and count=0
        """
        try:
            node = (x for x in self.digest if x.id == node_id).next()
            return node
        except StopIteration:
            return QDigest.empty_node
 
    def _remove_node(self, node_id):
        """
        Removed the node with the specified id from the digest
        """
        node = self._get_node(node_id)
        if node is not QDigest.empty_node:
            self.digest.remove(node)
 
    def violates_prop_1(self, node):
        """
        Checks if a node violates property 1, namely node.count <= floor(n/k)
        This property is not used in the code, but it is used in the paper to prove error guarantees
        """
        if node.is_root or node.is_leaf:
            return False
        else:
            return node.count <= int(floor(self.n/self.k))
 
    def violates_prop_2(self, node):
        """ Checks if a node violates node.count + node.sibling.count + node.parent.count > floor(n/k)
        We assume that the node passed in is one of the two children nodes
        """
        sibling_count = self._get_node(node.sibling_id()).count
        parent_count = self._get_node(node.parent_id()).count
 
        return node.count + sibling_count + parent_count <= int(floor(self.n/self.k))
 
    def _insert_or_modify_node(self, node_id, inc_by=1):
        """
        Helper function to do the actual insertion
        """
        current = self._get_node(node_id)
        if current is not QDigest.empty_node:
            current.inc(inc_by)
        else:
            current = QDigest.Node(id=node_id, initial_count=inc_by)
            self.digest.append(current)
 
    def insert(self, value):
        """
        Insert a new element into the q-digest or increase the count if we have already seen that
        value before
        """
        if value > self.size:
            raise ValueError()
 
        id_for_leaf_node = int(pow(2, self.height) + value - 1)
        self._insert_or_modify_node(node_id=id_for_leaf_node, inc_by=1)
 
    def compress(self):
        """
        Starting from the bottom, go over each node and at each step check if prop2 is violated
        """
        for l in xrange(self.height, 0,-1): # start from bottom
            level_l_nodes = sorted((x for x in self.digest if x.id >= pow(2,l) and x.id < pow(2,l+1)), key=id)
            for node in level_l_nodes:
                if self.violates_prop_2(node) and self._get_node(node.id) is not QDigest.empty_node:
                    merged_count = node.count + self._get_node(node.sibling_id()).count
                    self._insert_or_modify_node(node_id=node.parent_id(), inc_by=merged_count)
                    self._remove_node(node.id)
                    self._remove_node(node.sibling_id())
 
    def quantile_query(self, fractions):
        """
        Given a list of fractions between (0, 1) find the value in the digest closer to that quantile. For example
        set fraction to 0.5 and 0.75 to get the median and 75th percentile. The algorithm as describes in the paper
        goes as follows: Traverse the tree in postorder fashion, adding the counts. Once the running sum exceeds
        q*n, where q our fraction, return the previous value.
        """
 
        # setup arrays for results
        running_sums = {}
        results = {}
        for fraction in fractions:
            if fraction <= 0.0 or fraction >= 1.0:
                raise ValueError("Fraction should be between 0 and 1 exclusive")
            else:
                running_sums[str(fraction)] = 0
                results[str(fraction)] = None
 
        def _get_node_for_traversal(node_id):
            """
            helper fcn that will create a pseudo-node if one does not exist, just so we can
            easily fake post-order traversal the traditional way
            """
            current = self._get_node(node_id)
            if current.id is -1:
                current = QDigest.Node(id=node_id, initial_count=0)
            return current
 
        def basic_dfs(node):
            """
            generator fcn that does a postorder traversal of the tree, summing up the counts for each
            node and stores the result when it exceeds q*n for each desired fraction passed in the outer fcn
            """
            if node and node.id < self.size * 2 :
                left_node, right_node = (_get_node_for_traversal(x) for x in node.children())
 
                for node in basic_dfs(left_node):
                    yield node
                for node in basic_dfs(right_node):
                    yield node
 
                for fraction in fractions:
                    if not results[str(fraction)] and node.count + running_sums[str(fraction)] < fraction*self.n:
                        running_sums[str(fraction)] = running_sums[str(fraction)] + node.count
                    else:
                        results[str(fraction)] = running_sums[str(fraction)]
 
        #TODO: stop programming with side-effects, shitty habit
        [x for x in basic_dfs(_get_node_for_traversal(1))]
        return results
if __name__ == '__main__':
    # the example from the paper
    digest = QDigest(8,5)
    digest.insert(1)
    digest.insert(3)
    digest.insert(3)
    digest.insert(3)
    digest.insert(3)
    digest.insert(4)
    digest.insert(4)
    digest.insert(4)
    digest.insert(4)
    digest.insert(4)
    digest.insert(4)
    digest.insert(5)
    digest.insert(6)
    digest.insert(7)
    digest.insert(8)
    digest.compress()
    print(digest.digest)
    print(digest.quantile_query((0.25, 0.5, 0.75)))