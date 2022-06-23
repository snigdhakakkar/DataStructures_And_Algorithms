## ou have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] 
# indicates that there is an edge between ai and bi in the graph.
# Return the number of connected components in the graph.

from typing import List


def countComponents(self, n: int, edges: List[List[int]]) -> int:
        parent = [i for i in range(n)] ##parent array initalized with index values
        rank = [1] * n ##rank array taken as 1 for each element
        
        def find(n1): ##finding the root of the node
            result = n1 ##initializing the result / root with node n1
            
            while result != parent[result]: ##if result is equal to the parent node, then there is no scope to go up
                parent[result] = parent[parent[result]] ##taking parent equal to the grandparent node to optimize the linkedlist
                result = parent[result] 
            return result ##returning the root node
        
        def union(n1,n2): ##defining the union function
            ##number of unions would lead to the derease in the number of connected components by 1 each per union
            p1, p2 = find(n1), find(n2)
            
            if p1==p2:
                return 0 ##no union was made
            
            if rank[p2] > rank[p1]:
                parent[p1] = p2
                rank[p2] += rank[p1]
                
            else:
                parent[p2] = p1
                rank[p1] += rank[p2]
                
            return 1
        
        result = n
        for n1, n2 in edges:
            result -= union(n1,n2)
            
        return result
            
            
            
            
            
        
        
        