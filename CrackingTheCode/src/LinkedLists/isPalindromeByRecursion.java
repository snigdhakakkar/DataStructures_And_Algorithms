package LinkedLists;

public class isPalindromeByRecursion {
	
	//driver method
		public static void main(String[] args) {
			int length = 9;
			LinkedListNode[] nodes = new LinkedListNode[length];
			for (int i = 0; i < length; i++) {
				nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
			}
			
			for (int i = 0; i < length; i++) {
				if (i < length - 1) {
					nodes[i].setNext(nodes[i + 1]);
				}
				if (i > 0) {
					nodes[i].setPrevious(nodes[i - 1]);
				}
			}
			
			LinkedListNode head = nodes[0];
			System.out.println(head.printForward());
			System.out.println(isPalindromeByRecursion(head));
		}
		
		public static boolean isPalindromeByRecursion(LinkedListNode head) {
			int length = lengthOfList(head);
			PalindromeResult sol = isPalindromeRecurse(head, length);
			return sol.result;
			
		}
		
		public static PalindromeResult isPalindromeRecurse(LinkedListNode head, int length) {
		//Base case
			if (head == null || length <= 0) {//even number of nodes
				return new PalindromeResult(head, true);
			} else if (length == 1) {//odd number of nodes
				return new PalindromeResult(head.next, true);
			}
			
			//recursion on sublist
			PalindromeResult sol = isPalindromeRecurse(head.next, length - 2);
			
			//if child calls are not a palindrome, pass back up a failure
			if(!sol.result || sol.node == null) {
				return sol;
			}
			
			//check whether it matches the corresponding node on the other side
			sol.result = (head.data == sol.node.data);
			
			//return subsequent node
			sol.node = sol.node.next;
			
			return sol;
		}
		
		public static int lengthOfList(LinkedListNode n) {
			int size = 0;
			while(n != null) {
				size++;
				n = n.next;
			}
			return size;
		}

}
