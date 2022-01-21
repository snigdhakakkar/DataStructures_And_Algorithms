package LinkedList;

public class CompareTwoStringsInLinkedLists {
	
	public static void main(String[] args) {
		
		Node a = new Node();
		
		Node head1 = null;
		
		head1 = a.insert(head1, 'e');
		head1 = a.insert(head1, 'v');
		head1 = a.insert(head1, 'a');
		//head1 = a.insert(head1, 'v');
		head1 = a.insert(head1, 'e');
		
		Node head2 = null;
		
		head2 = a.insert(head2, 'e');
		head2 = a.insert(head2, 'v');
		head2 = a.insert(head2, 'a');
		head2 = a.insert(head2, 'v');
		head2 = a.insert(head2, 'e');
		
		System.out.println(compareTwoStrings(head1, head2));
	}
	
	public static int compareTwoStrings(Node head1, Node head2) {
		if(head1 == null && head2 == null) {
			return 0;
		}
		
		while(head1 != null && head2 != null) {
			if(head1.i < head2.i) {
				return -1;
			} else if (head1.i > head2.i){
				return 1;
			}
			head1 = head1.next;
			head2 = head2.next;
			
		}
		
		if(head1 == null && head2 == null) {
			return 0;
		}
		
		return (head1 != null) ? 1 : -1;
	}
	
	


}
