package Trees_And_Graphs;

import java.util.Random;

public class Q4_11_Tree {
	
	Q4_11_TreeNode root = null;
	
	public void insertInOrder(int value) {
		if (root == null) {
			root = new Q4_11_TreeNode(value);
		} else {
			root.insertInOrder(value);
		}
	}
	
	public int size() {
		return root == null ? 0 : root.size();
	}
	
	public Q4_11_TreeNode getRandomNode() {
		if (root == null) {
			return null;
		}
		
		Random random = new Random();
		int i = random.nextInt(size());
		return root.getIthNode(i);
	}
	
	

}
