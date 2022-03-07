package BasicCodingProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//interval here means we have a start and we have an end
// 2............5
//          4.....................10
//                                    11............15
//                                        12......14

//if the intervals given are in random order, then we need to sort them first as per start value 
//--> collections.sort based on start value

public class MergeGivenIntervals {
	//time complexity: O(N) where N is the number of intervals; space complexity: O(N) as we are storing the intervals in an arraylist
	public static void main(String[] args) {
		
		List<Interval> a = new ArrayList<Interval>();
		a.add(new Interval(1,4));
		a.add(new Interval(2, 5));
		a.add(new Interval(7,9));
		
		List<Interval> l = mergeIntervals(a);
		for(Interval i : l) {
		System.out.println("(" + i.start + " , " + i.end + ")");
		}
		
		
	}
	
	public static List<Interval> mergeIntervals(List<Interval> list){
		if(list.size() == 0) {
			return new ArrayList<>();
		}
		
		List<Interval> result = new ArrayList<Interval>();
		
		Collections.sort(list, (a, b) -> Integer.compare(a.start, b.start));
		
		Iterator<Interval> iterator = list.iterator();
		
		Interval firstInterval = iterator.next();
		int start = firstInterval.start;
		int end = firstInterval.end;
		
		while(iterator.hasNext()) {
			Interval currentInterval = iterator.next();
			
			if(currentInterval.start < end) {
				end = Math.max(end, currentInterval.end);
			} else {
				
				result.add(new Interval(start, end));
				
				start = currentInterval.start;
				end = currentInterval.end;
			}
		}
		
		result.add(new Interval(start, end));
		
		return result;
	}
	
	

}
