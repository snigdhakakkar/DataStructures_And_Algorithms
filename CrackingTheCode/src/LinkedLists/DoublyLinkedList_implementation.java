package LinkedLists;

public class DoublyLinkedList_implementation {
	
	// Class for Doubly Linked List
	static Node head; // head of this list
	
	/*Doubly LinkedList node*/
	public static class Node {
		int data;
		Node prev;
		Node next;
		
		//Constructor to create a new node
		//here, next and previous are default initialized to null
		Node(int d) {
			data = d;
		}
	}
	
	//Adding a node at the front of the list
	public static void push(int new_data) {
		/* 1. allocate node 
	        * 2. put in the data */
		Node new_Node = new Node(new_data);
		
		/* 3. Make next of new node as head and previous as NULL */
		new_Node.next = head;
		new_Node.prev = null;
		
		/* 4. change previous of head node to new node */
		if (head != null) {
			head.prev = new_Node;
		}
		
		/* 5. move the head to point to the new node */
		head = new_Node;	
	}
	
	// Add a node before the given node
	public static void InsertBefore(Node next_node, int new_data) {
		/*Check if the given next_node is NULL*/
		if (next_node == null) {
			System.out.println("The given next node can not be NULL");
            return;
		}
		
		//Allocate node, put in the data
        Node new_node = new Node(new_data);
        
        //Making previous of new node as previous of next node
        new_node.prev = next_node.prev;
        
        //Making previous of next node as new node
        next_node.prev = new_node;
        
        //Making next of new node as next node
        new_node.next = next_node;
        
        //Check if new node is added as head
        if (new_node.prev != null) {
        	new_node.prev.next = new_node;
        } else {
        	head = new_node;
        }   
	}
	
	/* Given a node as prev_node, insert a new node after the given node */
	public static void InsertAfter(Node prev_Node, int new_data) {
		/*1. check if the given prev_node is NULL */
		
		if (prev_Node == null) {
			System.out.println("The given previous node cannot be NULL ");
            return;
		}
		
		/* 2. allocate node 
	     * 3. put in the data */
		Node new_node = new Node(new_data);
		
		/* 4. Make next of new node as next of prev_node */
		new_node.next = prev_Node.next;
		
		/* 5. Make the next of prev_node as new_node */
		prev_Node.next = new_node;
		
		/* 6. Make prev_node as previous of new_node */
		new_node.prev = prev_Node;
		
		/* 7. Change previous of new_node's next node */
		if (new_node.next != null) {
			new_node.next.prev = new_node;
		} 	
	}
	
	// Add a node at the end of the list
	public static void append(int new_data) {
		/* 1. allocate node 
	     * 2. put in the data */
		
		Node new_node = new Node(new_data);
		
		Node last = head; /* used in step 5*/
		
		/* 3. This new node is going to be the last node, so
	        * make next of it as NULL*/
		new_node.next = null;
		
		/* 4. If the Linked List is empty, then make the new
	        * node as head */
		if (head == null) {
			new_node.prev = null;
            head = new_node;
            return;
		} else {
			/* 5. Else traverse till the last node */
	        while (last.next != null) {
	            last = last.next;
	            }
		} last.next = new_node;
		new_node.prev = last;	
		
	}
	
	// This function prints contents of linked list starting from the given node
	public static void printlist(Node node) {
		Node last = null;
		System.out.println("Traversal in forward Direction");
		while (node != null) {
			System.out.print(node.data + " ");
			last = node;
			node = node.next;
		}
		System.out.println();
		
		System.out.println("Traversal in reverse direction");
		while (last != null) {
			System.out.print(last.data + " ");
			last = last.prev;
		}
	}
	
	/* Driver program to test above functions*/
	public static void main(String[] args) {
		/* Start with the empty list */
		DoublyLinkedList_implementation DLL = new DoublyLinkedList_implementation();
		
		// Insert 6. So linked list becomes 6->NULL
		DLL.append(6);
		
		// Insert 7 at the beginning. So 
        // linked list becomes 7->6->NULL
		DLL.push(7);
		
		// Insert 4 at the end. So linked 
        // list becomes 7->6->4->NULL
		DLL.append(4);
		
		// Insert 8, after 7. So linked 
        // list becomes 1->7->8->6->4->NULL
		DLL.InsertAfter(DLL.head.next, 8);
		
		// Insert 5, before 8.So linked
        // list becomes 1->7->5->8->6->4
		DLL.InsertBefore(DLL.head.next.next, 5);
		
		System.out.println("Created DLL is: ");
		DLL.printlist(DLL.head);
		
	}

}
