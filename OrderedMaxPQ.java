/*
 * Binary heap representation based on ordered array
 * Insertion run time : log N
 * Delete Max : log N
 * Max: 1
 */
import java.util.NoSuchElementException;

public class OrderedMaxPQ <Key extends Comparable<Key>> {
	private Key[] pq;
	private int N;
	
	public OrderedMaxPQ(int capacity){
		pq = (Key[])new Comparable[capacity + 1];
		//start N at 1 instead of 0 for easier calculation
		N = 0;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	//insertion is always done at the root, then after inserting, the heap is reordered to 
	//make sure it's not violating the heap order.
	public void insert(Key item){
		if(pq.length - 1 == N){
			resize(N * 2);
		}
		
		pq[++N] = item;
		//need to do this to make sure addition does not violate heap order
		swim(N);
	}
	
	//in a binary heap, the max node is always the root, the root is always deleted
	public Key delMax(){
		if(isEmpty()){
			throw new NoSuchElementException("Priority Queue Underflow");
		}
		
		//remember that no element is placed at 0, so max is started at 1
		Key toBeDeleted = pq[1];
		//move root to the last node
		swap(1, N--);
		sink(1);
		pq[N + 1] = null;
		
		if (N > 0 && pq.length == N / 4) {
			resize(N/4);
		}
		
		return toBeDeleted;
	}
	
	//go up and replace parents until biggest on top
	//parents always have a lower index, that is k/2 since they're ahead in the array
	//parent node of k is at k/2
	public void swim(int k){
		while(k > 1 && less(k/2, k)){
			swap(k, k/2);
			k = k/2;
		}
	}
	
	
	//children nodes are always 2k and 2k + 1
	//go down until it's near the limit of the array
	public void sink(int k){
		while(2 * k <= N){
			int j = 2 * k;
			//less(j,j-1) finds out which node is bigger, left or right
			if(j < N && less(j, j + 1)){
				j++;
			}
			
			//the actual comparison for the k and j value is done here
			//if k is not less than either one of those, then we're done and 
			//we get out and swap and move down the heap
			if(!less(k, j)){
				break;
			}
			
			swap(k, j);
			k = j;
		}
	}
	
	public void resize(int size){
		Key[] resized = (Key[]) new Comparable[size];
		for(int i = 0; i < pq.length; i++){
			resized[i] = pq[i];
		}
		
		pq = resized;
	}
	
	public boolean less(int i, int j){
		return pq[i].compareTo(pq[j]) < 0;
	}
	
	public void swap(int i, int j){
		Key swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
	}
	
	public void printQueue(){
		for(int i = 1; i < pq.length; i++){
			System.out.print(" " + pq[i]);
		}
	}
	
	
	public static void main(String args[]) {
		OrderedMaxPQ<String> queue = new OrderedMaxPQ<String>(2);
		queue.insert("i");
		queue.insert("am");
		queue.insert("zippity-zap");
		queue.insert("liking");
		queue.insert("peasants");
		System.out.println(queue.delMax());
		System.out.println(queue.delMax());
		System.out.println(queue.delMax());
		System.out.println(queue.delMax());
		queue.printQueue();
	}
	
	
}
