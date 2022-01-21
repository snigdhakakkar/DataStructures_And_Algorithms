package LinkedList;

public class PointRandomPointerToNextHigherValue {
	
	//driver method
		public static void main(String[] args) {
			LinkedNode a = new LinkedNode();
			LinkedNode head = null;
			
			head = LinkedNode.getNewNode(22);
			head.next = LinkedNode.getNewNode(5);
			head.next.next = LinkedNode.getNewNode(3);
			head.next.next.next = LinkedNode.getNewNode(15);
			head.next.next.next.next = LinkedNode.getNewNode(37);
	    
	    	a.printList(head);
			System.out.println();
	    	
	    	LinkedNode newList = RandomPointToNextHigherElement(head);
	    	
	    	a.printList(newList);
			System.out.println();
		}
		
		public static LinkedNode RandomPointToNextHigherElement(LinkedNode head) {
			if(head == null || head.next == null) {
				return head;
			}
			
			LinkedNode node = head;
			while (node != null) {
				node.random = node.next;
				node = node.next;
			}
			
			sortLinkedList(head);
			
			return head;
		}
		
		public static LinkedNode sortLinkedList(LinkedNode node) {
			if(node == null || node.random == null) {
				return node;
			}
			
			LinkedNode middle = LinkedNode.middleNode(node);
			LinkedNode second = middle.random;
			middle.random = null;
			
			return mergeTwoList(sortLinkedList(node), sortLinkedList(second));
		}
		
		public static LinkedNode mergeTwoList(LinkedNode first, LinkedNode second) {
			if(first == null && second == null) {
				return null;
			}
			
			LinkedNode tmp = new LinkedNode();
			LinkedNode finalList = tmp;
			
			while(first != null && second != null) {
				if(first.i < second.i) {
					tmp.random = first;
					first = first.random;
				} else {
					tmp.random = second;
					second = tmp.random;
				}
				
				tmp = tmp.random;
			}
			
			tmp.random = (first != null) ? first : second;
			
			return finalList.random;
			
		}

}
