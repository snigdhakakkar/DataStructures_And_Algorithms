package LinkedLists;

public class IntersectionNode {
	
	//driver method
	public static void main(String[] args) {
		/* Create linked list */
		int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
		LinkedListNode list1 = LinkedListNode.createLinkedListFromArray(vals);
		
		int[] vals2 = {12, 14, 15};
		LinkedListNode list2 = LinkedListNode.createLinkedListFromArray(vals2);
		
		list2.next.next = list1.next.next.next.next;
		
		System.out.println(list1.printForward());
		System.out.println(list2.printForward());
		
		
		LinkedListNode intersection = findIntersection(list1, list2);
		
		System.out.println(intersection.printForward());
	}
	
	public static LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
		if(list1 == null || list2 == null) {
			return null;
		}
		
		//get tail and sizes
		IntersectionNodeResult result1 = getTailAndSize(list1);
		IntersectionNodeResult result2 = getTailAndSize(list2);
		
		//compare the tails and if different tails , then return null as there is no intersection
		if(result1.tail != result2.tail) {
			return null;
		}
		
		//set pointers to the start of each list
		LinkedListNode shorter = result1.size < result2.size ? list1 : list2;
		LinkedListNode longer = result1.size < result2.size ? list2 : list1;
		
		//Advance the pointer for the longer list by difference in lengths
		longer = getKthNode(longer, Math.abs(result1.size - result2.size));
		
		//traverse both the lists by moving the pointers until there is a collision
		while(shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}
		
		/* Return either one. */
		return longer;
		
	}
	
	public static IntersectionNodeResult getTailAndSize(LinkedListNode list) {
		if(list == null) {
			return null;
		}
		
		int size = 1;
		LinkedListNode current = list;
		while(current.next != null) {
			size++;
			current = current.next;
			
		}
		return new IntersectionNodeResult(current, size);
	}
	
	public static LinkedListNode getKthNode(LinkedListNode head, int k) {
		LinkedListNode current = head;
		while (k > 0 && current != null) {
			current = current.next;
			k--;
		}
		return current;
	}

}
