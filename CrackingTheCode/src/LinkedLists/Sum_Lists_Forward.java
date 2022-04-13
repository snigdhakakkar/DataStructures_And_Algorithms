package LinkedLists;
import LinkedLists.LinkedListNode;

public class Sum_Lists_Forward {
	
	private static PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2) {
		if(l1 == null && l2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}
		
		/*Add smaller digits recursively*/
		PartialSum sum = addListsHelper(l1.next, l2.next);
		
		/*Add carry to the current data*/
		int val = sum.carry + l1.data + l2.data;
		
		//insert sum of current digits
		LinkedListNode full_result = insertBefore(sum.sum, val%10);
		
		//return sum so far, and the carry value
		sum.sum = full_result;
		sum.carry = val/10;
		return sum;
	}
	
	//Pad the list with zeros
	private static LinkedListNode padList(LinkedListNode l, int padding) {
		LinkedListNode head = l;
		for (int i = 0; i < padding; i++) {
			head = insertBefore(head, 0);
		}
		return head;
	}
	
	//helper function to insert node in the front of a LinkedList
	public static LinkedListNode insertBefore(LinkedListNode list, int data) {
		LinkedListNode node = new LinkedListNode(data);
			if (list != null) {
				node.next = list;
			}
				
		return node;
	}
	
	public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
		
		int len1 = LinkedListNode.length(l1);
		int len2 = LinkedListNode.length(l2);
		
		//pad the shorter list with zeros
		if (len1 < len2) {
			l1 = padList(l1, len2 - len1);
		} else {
			l2 = padList(l2, len1 - len2);
		}
		
		
		//Add lists//
		PartialSum sum = addListsHelper(l1, l2);
		
		/* if there was a carry value leftover, insert this at the front of the list, otherwise just return the linkedlist*/
		
		if(sum.carry == 0) {
			return sum.sum;
		} else {
			LinkedListNode result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}
	
	
	
	public static int linkedListToInt(LinkedListNode node) {
		int value = 0;
		while (node != null) {
			value = value * 10 + node.data;
			node = node.next;
		}
		return value;
	}
	
	public static void main(String[] args) {
		LinkedListNode lA1 = new LinkedListNode(3, null, null);
		LinkedListNode lA2 = new LinkedListNode(1, null, lA1);
		
		LinkedListNode lB1 = new LinkedListNode(5, null, null);
		LinkedListNode lB2 = new LinkedListNode(9, null, lB1);
		LinkedListNode lB3 = new LinkedListNode(1, null, lB2);	
		
		LinkedListNode list3 = addLists(lA1, lB1);
		
		System.out.println("  " + lA1.printForward());		
		System.out.println("+ " + lB1.printForward());			
		System.out.println("= " + list3.printForward());	
		
		int l1 = linkedListToInt(lA1);
		int l2 = linkedListToInt(lB1);
		int l3 = linkedListToInt(list3);
		
		System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
		System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));		
	}

}
