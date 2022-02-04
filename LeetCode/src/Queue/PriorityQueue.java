package Queue;

public class PriorityQueue {

	public int MAX;
	public int arr[];
	public int nItems;
	
	public PriorityQueue() {
		MAX = 10;
		arr = new int[MAX];
		nItems = 0;
	}
	
	//Complexity: O(N)
	public void enqueue(int val) {
		int i;
		if(nItems == 0) {
			arr[0] = val;
			nItems++;
			return;
		}
		for(i = nItems - 1; i >= 0; i--) {
			if(val > arr[i]) {
				arr[i+1] = arr[i];
			} else {
				break;
			}
		}
		arr[i+1] = val;
		nItems++;
	}
	
	public void printPriorityQueue() {
		for(int i = 0; i < nItems; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	//Complexity: O(1)
	public int remove() {
		return arr[--nItems];
	}
	
	public boolean isFull() {
		return nItems == MAX;
	}
	
	public boolean isEmpty() {
		return nItems == 0;
	}
	
	public int getPeek() {
		return arr[nItems - 1];
	}
	
	public static void main(String[] args) {
		PriorityQueue a = new PriorityQueue();
		
		a.enqueue(12);
		a.enqueue(7);
		a.enqueue(10);
		a.enqueue(1);
		a.enqueue(8);
		
		a.printPriorityQueue();
		
		System.out.println();
		System.out.println(a.remove());
		a.printPriorityQueue();
		
		System.out.println();
		System.out.println(a.remove());
		a.printPriorityQueue();
	}
	
	
	
	
	
	
	
	
	
}
