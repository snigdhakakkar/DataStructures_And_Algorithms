package LinkedList;

public class FlattenAMultiLevelListLevelwise {
	
	//driver method
		public static void main(String[] args) {
			Linked a = new Linked();
			ListNode root1, root2, root3, root4, root5;
			
			int arr1[] = new int[] {1 ,2 ,3 ,4 ,5 };
			int arr2[] = new int[] {6 ,7 ,8 };
			int arr3[] = new int[] {9 ,10 };
			int arr4[] = new int[] {11 };
			int arr5[] = new int[] {12 };
			
			root1 = a.createList(arr1);
			root2 = a.createList(arr2);
			root3 = a.createList(arr3);
			root4 = a.createList(arr4);
			root5 = a.createList(arr5);
			
			root1.child = root2;
			root1.next.next.next.child = root3;
			root2.next.child = root4;
			root3.child = root5;
			
			root1 = flatten(root1);
			a.printLinkedList(root1);	
		}
		
		public static ListNode flatten(ListNode node) {
			if(node == null) {
				return node;
			}
			
			ListNode start, tail;
			start = tail = node;
			
			while(tail.next != null) {
				tail = tail.next;
			}
			
			while(start != null) {
				if(start.child != null) {
					tail.next = start.child;
					tail = tail.next;
					
					while(tail.next != null) {
						tail = tail.next;
					}
				}
				start = start.next;
			}
			
			return node;
		}

}
