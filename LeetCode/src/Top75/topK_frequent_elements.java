package Top75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Problem statement - Given an integer array nums and an integer k, 
 * return the k most frequent elements. You may return the answer in any order.
 */

//Properties of min Heap used: it's a complete binary tree; 
//value of each node is less than or equal to the value of its children

public class topK_frequent_elements {
	//Approach 1: Using HashMap to populate frequencies for each num; heap to pull top k elements
	public int[] topKFrequent(int[] nums, int k) {
        
        // O(1) time
       if (k == nums.length) {
           return nums;
       }
       
       // 1. build hash map : character and how often it appears
       // O(N) time
       HashMap<Integer, Integer> count = new HashMap<>();
       for (int n : nums){
           count.put(n, count.getOrDefault(n,0) + 1);
       }
       
       // init heap 'the less frequent element first'
       Queue<Integer> heap = new PriorityQueue<>(
           (n1, n2) -> count.get(n1) - count.get(n2));
       
       // 2. keep k top frequent elements in the heap
       // O(N log k) < O(N log N) time
       for(int num : count.keySet()){
           heap.add(num);
           if(heap.size() > k){
               heap.poll();
           }
       }
       
       // 3. build an output array
       // O(k log k) time
        int[] top = new int[k];
       for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
       }
       return top;  
   }
   
   /* Time complexity: O(N) for hashMap; O(NlogK) for heap populating; O(klogK)for array populating --> overall time complexity: O(NlogK);
   Space complexity: O(N) for hashMap and O(k) for heap --> overall it is O(N)
   */ 
	
	public int[] topKFrequentI(int[] nums, int k) {
        //Approach 2: using buckets to sort linearly
        
        if(k == nums.length){
            return nums;
        }
        
        //build hash map : character and how often it appears
       // O(N) time
       HashMap<Integer, Integer> count = new HashMap<>();
       for (int n : nums){
           count.put(n, count.getOrDefault(n,0) + 1);
       }
        
        //build buckets
        List<Integer>[] buckets = new List[nums.length + 1] ;
        for(int i = 0; i < buckets.length; i++){
            buckets[i] = new ArrayList<>();
        }
        //populate buckets
        for(int n : count.keySet()){
            buckets[count.get(n)].add(n);
        }
        
        //create a sorted flattened list
        List<Integer> flattened = new ArrayList<>();
        for(int i = buckets.length - 1; i >= 0; i--){
            for(int num : buckets[i]){
                flattened.add(num);
            }
        }
        
        //filter top k elements in an array
        int[] topK = new int[k];
        for(int i = 0; i < k; i++){
            topK[i] = flattened.get(i);
        }
        
        return topK;
        
    }
    
    /* For time complexity --> hashMap: O(N), buckets: O(N), flattened: O(N), topK[]: O(k) --> overall: O(N)
    For space complexity --> hashMap: O(N), buckets: O(N), flattened: O(N),
    topK[]: O(1) --> overall: O(N)
    */

}
