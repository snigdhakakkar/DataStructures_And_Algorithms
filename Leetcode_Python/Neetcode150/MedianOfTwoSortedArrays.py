class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        ashort, along = nums1, nums2
        if len(ashort) > len(along):
            ashort, along = along, ashort

        length = len(ashort) + len(along)
        mindex = (length)//2

        left = 0
        right = len(ashort)
        
        while left <= right:
            midshort = (right + left) // 2
            midlong = mindex - midshort
            
            lshort = ashort[midshort -1] if midshort>0 else float('-inf')
            llong = along[midlong - 1] if midlong> 0 else float('-inf')
            rshort = ashort[midshort] if midshort<len(ashort) else float('inf')
            rlong = along[midlong] if midlong<len(along) else float('inf')
            
            if lshort <= rlong and rshort >= llong:
                if length % 2 != 0:
                    return min(rshort, rlong)
                return (max(lshort, llong) + min(rshort, rlong)) /2.0
            elif lshort > rlong:
                right = midshort - 1
            else:
                left = midshort + 1