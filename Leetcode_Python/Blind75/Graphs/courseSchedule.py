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