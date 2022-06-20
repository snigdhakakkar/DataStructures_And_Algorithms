##There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
# You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must 
# take course bi first if you want to take course ai.
# For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
# Return true if you can finish all courses. Otherwise, return false.

##Strategy:
#The problem could be modeled as yet another graph traversal problem, where each course 
# can be represented as a vertex in a graph and the dependency between the courses can be modeled 
# as a directed edge between two vertex.
# And the problem to determine if one could build a valid schedule of courses 
# that satisfies all the dependencies (i.e. constraints) would be equivalent to determine 
# if the corresponding graph is a DAG (Directed Acyclic Graph), i.e. there is no cycle existed in the graph.

## Approach 1: Backtracking: time complexity - O(|E| + |V|^2) where |E| is the number of dependencies,
## |V| is the number of courses and d is the maximum length of acyclic path
## space complexity = O(|E| + |V|)
from typing import List


def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        from collections import defaultdict
        courseDict = defaultdict(list)
        
        for relation in prerequisites:
            nextCourse, prevCourse = relation[0], relation[1]  
            courseDict[prevCourse].append(nextCourse)
            
        path = [False]* numCourses
        for currCourse in range(numCourses):
            if self.isCyclic(currCourse, courseDict, path):
                return False
        return True
    
def isCyclic(self, currCourse, courseDict, path):
        if path[currCourse]:
            # come across a previously visited node, i.e. detect the cycle
            return True
        
        #before backtracking, mark the node in the path
        path[currCourse] = True
        
        #backTracking
        ret = False
        for child in courseDict[currCourse]:
            ret = self.isCyclic(child, courseDict, path)
            if ret:
                break
                
        #after backtracking, remove the node from the path
        path[currCourse] = False
        return ret

## Approach 2: Postorder DFS : time complexity - O(|E| + |V|) , space complexity: O(|E| + |V|)
def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        from collections import defaultdict
        courseDict = defaultdict(list)
        
        for relation in prerequisites:
            nextCourse, prevCourse = relation[0], relation[1]  
            courseDict[prevCourse].append(nextCourse)
        
        checked = [False]*numCourses
        path = [False]* numCourses
        
        for currCourse in range(numCourses):
            if self.isCyclic(currCourse, courseDict, checked, path):
                return False
        return True
    
def isCyclic(self, currCourse, courseDict, checked, path):
        ## bottom cases
        if checked[currCourse]:
            # this node has been checked, no cycle would be formed with this node.
            return False
        if path[currCourse]:
            # come across a previously visited node, i.e. detect the cycle
            return True
        
        #implement post order DFS on the children nodes
        #mark the node in the path
        path[currCourse] = True
        
        ret = False
        ## postorder DFS to visit all the node's children first
        for child in courseDict[currCourse]:
            ret = self.isCyclic(child, courseDict, checked, path)
            if ret:
                break
                
        #after the visits of children, we come back to process the node itself
        # remove the node from the path
        path[currCourse] = False
        
        # Now that we've visited the nodes in the downstream,
        #   we complete the check of this node.
        checked[currCourse] = True
        return ret

##Approach 3: Topological sort: time complexity - O(|E| + |V|) , space complexity: O(|E| + |V|)
class GNode(object):
    """  data structure represent a vertex in the graph."""
    def __init__(self):
        self.inDegrees = 0
        self.outNodes = []

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        from collections import defaultdict, deque
        #key: index of the node; value: GNode
        graph = defaultdict(GNode)
        
        totalDeps = 0 ##dependencies
        for relation in prerequisites:
            nextCourse, prevCourse = relation[0], relation[1]
            graph[prevCourse].outNodes.append(nextCourse)
            graph[nextCourse].inDegrees += 1
            totalDeps += 1
            
        # we start from courses that have no prerequisites.
        # we could use either set, stack or queue to keep track of courses with no dependencies.
        nodepCourses = deque()
        for index, node in graph.items():
            if node.inDegrees == 0:
                nodepCourses.append(index)
                
        removeEdges = 0
        while nodepCourses:
            ##pop out courses without dependency
            course = nodepCourses.pop()
            
            #remove its outgoing edges one by one
            for nextCourse in graph[course].outNodes:
                graph[nextCourse].inDegrees -= 1
                removeEdges += 1
                # while removing edges, we might discover new courses with prerequisites removed, i.e. new courses without prerequisites.
                if graph[nextCourse].inDegrees == 0:
                    nodepCourses.append(nextCourse)
                    
        if removeEdges == totalDeps:
            return True
        else:
            # if there are still some edges left, then there exist some cycles
            # Due to the dead-lock (dependencies), we cannot remove the cyclic edges
            return False