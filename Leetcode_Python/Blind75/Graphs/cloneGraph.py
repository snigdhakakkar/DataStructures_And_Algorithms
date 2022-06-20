##Given a reference of a node in a connected undirected graph.
# Return a deep copy (clone) of the graph.
# Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
# class Node {
#   public int val;
#   public List<Node> neighbors;
# 
# Test case format:
# For simplicity, each node's value is the same as the node's index (1-indexed). 
# For example, the first node with val == 1, the second node with val == 2, and so on. 
# The graph is represented in the test case using an adjacency list.
# An adjacency list is a collection of unordered lists used to represent a finite graph. 
# Each list describes the set of neighbors of a node in the graph.
# The given node will always be the first node with val = 1. 
# You must return the copy of the given node as a reference to the cloned graph.}

#Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

# Approach 1 : Depth-first search:
## Time Complexity: O(N + M), where N is a number of nodes (vertices) and M is a number of edges.
## Space Complexity: O(N). This space is occupied by the visited hash map and in addition to that, 
# space would also be occupied by the recursion stack since we are adopting a recursive approach here. 
# The space occupied by the recursion stack would be equal to O(H) where H is the height of the graph. 
# Overall, the space complexity would be O(N).

class Solution:
    def __init__(self):
        # Dictionary to save the visited node and it's respective clone
        # as key and value respectively. This helps to avoid cycles.
        self.visited = {}
        
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return node
        
        # If the node was already visited before.
        # Return the clone from the visited dictionary.
        if node in self.visited:
            return self.visited[node]
        
        # Create a clone for the given node.
        # Note that we don't have cloned neighbors as of now, hence [].
        clone_node = Node(node.val, [])
        
        # The key is original node and value being the clone node.
        self.visited[node] = clone_node
        
        # Iterate through the neighbors to generate their clones
        # and prepare a list of cloned neighbors to be added to the cloned node.
        
        if node.neighbors:
            clone_node.neighbors = [self.cloneGraph(n) for n in node.neighbors]
            
        return clone_node

##Apprach 2: breadth-first search

# Definition for a Node.
class Node(object):
    def __init__(self, val, neighbors):
        self.val = val
        self.neighbors = neighbors

from collections import deque

class Solution(object):

    def cloneGraph(self, node):
        """
        :type node: Node
        :rtype: Node
        """

        if not node:
            return node

        # Dictionary to save the visited node and it's respective clone
        # as key and value respectively. This helps to avoid cycles.
        visited = {}

        # Put the first node in the queue
        queue = deque([node])
        # Clone the node and put it in the visited dictionary.
        visited[node] = Node(node.val, [])

        # Start BFS traversal
        while queue:
            # Pop a node say "n" from the from the front of the queue.
            n = queue.popleft()
            # Iterate through all the neighbors of the node
            for neighbor in n.neighbors:
                if neighbor not in visited:
                    # Clone the neighbor and put in the visited, if not present already
                    visited[neighbor] = Node(neighbor.val, [])
                    # Add the newly encountered node to the queue.
                    queue.append(neighbor)
                # Add the clone of the neighbor to the neighbors of the clone node "n".
                visited[n].neighbors.append(visited[neighbor])

        # Return the clone of the node from visited.
        return visited[node]

## Time Complexity : O(N + M), where N is a number of nodes (vertices) and M is a number of edges.

## Space Complexity : O(N). This space is occupied by the visited dictionary and in addition to that, 
# space would also be occupied by the queue since we are adopting the BFS approach here. 
# The space occupied by the queue would be equal to O(W) where WW is the width of the graph. 
# Overall, the space complexity would be O(N).