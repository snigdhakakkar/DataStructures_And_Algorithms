package Trees_And_Graphs;

public class Q4_11_Random_Node {
	//Time complexity: O(D) where D is the maximum depth ~O(logN) for a balanced tree
	public static void main(String[] args) {
		int[] counts = new int[10];
		for (int i = 0; i < 1000000; i++) {
			Q4_11_Tree tree = new Q4_11_Tree();
			int[] array = {1, 0, 6, 2, 3, 9, 4, 5, 8, 7};
			for (int x : array) {
				tree.insertInOrder(x);
			}
			int d = tree.getRandomNode().data;
			counts[d]++;
		}
		for (int i = 0; i < counts.length; i++) {
			System.out.println(i + ": " + counts[i]);
		}
	}

}
