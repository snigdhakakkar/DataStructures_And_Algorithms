package BasicCodingProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//time complexity: O(N) where N is the number of intervals; space complexity: O(N) as we are storing the intervals in an arraylist

public class InsertIntervalWithProperMergingWithOtherIntervals {
	                                
	public static void main(String[] args) {
		  
		List<Interval> a = new ArrayList<Interval>();
		a.add(new Interval(1, 3));
		a.add(new Interval(6, 8));    
		a.add(new Interval(9, 10));
		a.add(new Interval(10, 12));
		a.add(new Interval(14, 20));
		
		Interval newInterval = new Interval(11, 15);
		
		List<Interval> l = mergeIntervals(a, newInterval);
		for(Interval i : l) {
		System.out.println("(" + i.start + " , " + i.end + ")");
		}
	}
	
	public static List<Interval> mergeIntervals(List<Interval> list, Interval newInterval){
		if(list.size() == 0) {      
			List<Interval>  newList = new ArrayList<Interval>();
			newList.add(newInterval);
			return newList;
		}
		
		List<Interval> result = new ArrayList<Interval>();
		
		Collections.sort(list, (a, b) -> Integer.compare(a.start, b.start));
		
		int i = 0;
		
		while(i < list.size() && list.get(i).end < newInterval.start) {
			result.add(list.get(i));
			i++;
		}
		
		while(i < list.size() && list.get(i).start < newInterval.end) {
			newInterval.start = Math.min(list.get(i).start, newInterval.start);
			newInterval.end = Math.max(list.get(i).end, newInterval.end);
			i++;
		}
		
		result.add(newInterval);
		
		while(i < list.size()) {
			result.add(list.get(i));
			i++;
		}
		
		return result;
	}

}
