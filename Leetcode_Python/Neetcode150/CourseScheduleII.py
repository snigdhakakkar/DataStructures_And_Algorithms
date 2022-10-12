from pip import List


class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        preMap = {c : [] for c in range(numCourses)}
        for crs, pre in prerequisites:
            preMap[crs].append(pre)
            
        #a course might have threee states:
        
        #it has been visited -> has been added to the output
        #it is being visited -> crs not added to the output but to the cycle
        #it has not been visited -> not added to the cycle or the output
        output = []
        visit, cycle = set(), set()
        
        def dfs(crs):
            if crs in cycle:
                return False
            if crs in visit:
                return True
            cycle.add(crs)
            for pre in preMap[crs]:
                if not dfs(pre):
                    return False
            cycle.remove(crs)
            visit.add(crs)
            output.append(crs)
            return True
        
        for crs in range(numCourses):
            if dfs(crs) == False:
                return []
            
        return output