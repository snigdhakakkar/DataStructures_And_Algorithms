package LinkedList;

import java.util.HashSet;

public class CountPairsFromTwoListsHavingAGivenSum {
	
		public static void main(String[] args) {
			Node head  = null;
			Node a = new Node();
			
			head = Node.insert(head, 22);
			head = Node.insert(head, 3);
	    	head = Node.insert(head, 10);
	    	head = Node.insert(head, 3);
	    	head = Node.insert(head, 13);
	    	
	    	Node head1 = null;
	    	
	    	head1 = Node.insert(head1, 2);
			head1 = Node.insert(head1, 14);
	    	head1 = Node.insert(head1, 10);
	    	head1 = Node.insert(head1, 27);
	    	head1 = Node.insert(head1, 21);
	    	
	    	int pairs = getSumOfPairs(head, head1, 24); 
	    	
	    	System.out.println(pairs);
		}
		
		public static int getSumOfPairs(Node node1, Node node2, int sum) {
			if(node1 == null && node2 == null) {
	            return 0;
	        }
			
			HashSet<Integer> s = new HashSet<>();
			int countPairs = 0;
			
			while(node1 != null) {
				s.add(node1.i);
				node1 = node1.next;
			}
			
			while(node2 != null) {
				if(s.contains(sum - node2.i)) {
					countPairs++;
				}
				
				node2 = node2.next;
			}
			
			return countPairs;
		}

}
