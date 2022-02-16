package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeserializeABinaryTree {
	
	public static void main(String[] args) {
		BinaryTree a = new BinaryTree();
		Node root = a.createNewNode(2);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(9);
		root.right.right = a.createNewNode(3);
		root.left.left = a.createNewNode(10);
		root.left.right = a.createNewNode(6);
		root.left.right.left = a.createNewNode(5);
		root.left.right.right = a.createNewNode(11);
		
		List<Integer> list  = new ArrayList<>();
		serialize(root, list);
		root = deserialize(list);

	}
	
	//time complexity: O(N), space complexity: O(N)
	public static void serialize(Node node, List<Integer> list) {
		
		if(node == null) {
			list.add(-1);
			return;
		}
		
		list.add(node.data);
		serialize(node.left, list);
		serialize(node.right, list);
	}
	
	public static int deserialization_index = 0;
	
	public static Node deserialize(List<Integer> list) {
		
		if(list.get(deserialization_index) == -1) {
			deserialization_index++;
			return null;
		}
		
		Node newNode = createNewNode(list.get(deserialization_index++));
		
		newNode.left = deserialize(list);
		newNode.right = deserialize(list);
		
		return newNode;
	}
	
	public static Node createNewNode(int val) {
		Node a = new Node();
		
		a.data = val;
		a.left = null;
		a.right = null;
		return a;
	}

}
