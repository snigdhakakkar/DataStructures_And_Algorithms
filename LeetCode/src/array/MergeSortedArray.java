package array;

public class MergeSortedArray {
	static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int s1 = m-1, s2 = n-1, s3 = m+n-1;
        
        //Part1: when both the arrays are unfinished
        while (s1 >=0 && s2 >=0) {
            if(nums1[s1] >= nums2[s2]) {
                nums1[s3--] = nums1[s1--];
            } else {
                nums1[s3--] = nums2[s2--];
            }
        }
        
        while (s1 >=0) {
            nums1[s3--] = nums1[s1--];
        }
        
        while (s2 >=0) {
            nums1[s3--] = nums2[s2--];
        } 
        return nums1;  
    }
	
public static void main(String[] args) {
	int nums1[] = {1,2,3,0,0,0};
	int m = 3, n = 3;
	int nums2[] = {2,5,6};
	int result[] = merge(nums1, m, nums2, n);
	for(int i : result) {
		System.out.println(i);
		}
	}

}
