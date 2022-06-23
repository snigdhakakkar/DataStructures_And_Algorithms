##Iterative DFS approach - time complexity: O(N + M), space complexity - O(N + M)
from typing import List


def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if not n: ##handling the edge case wehere there are no nodes in the tree
            return True ##a graph with no nodes is regarded as a tree
        
        adj_List = {i :[] for i in range(n)}  ##defining the adjacency list
        
        for n1, n2 in edges: ##adding neighbors to the adjancency list
            adj_List[n1].append(n2)
            adj_List[n2].append(n1)
             
        visit = set() ##taking a set to track visisted nodes
        def dfs(i, prev): ##dfs function
            if i in visit: ##checking for loops
                return False
            
            visit.add(i) ##adding the current node to visit set
            for j in adj_List[i]: ##checking for neighboring nodes of the current node in adjancency list
                if j == prev: ##ignoring the trivial loop in an undirected graph
                    continue
                if not dfs(j, i): ##returning False, if dfs is not true at any point
                    return False
            return True ##return true if dfs is true for the entire for loop
        
        return dfs(0, -1) and n == len(visit) ##checking if all the nodes are visited and the result of dfs is true i.e. there is no loop
            
        