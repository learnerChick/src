/*
 * This is based on a resizable array
 * In an unordered array like this,
 * Insertion run time : 1
 * Delete Max : N
 * Max: N
 * 
 */

public class UnorderedMaxPQ<Key extends Comparable<Key>> {
	
	private Key[] pq;	//holds item in queue
	private int N;	//number of items in queue
	
	public UnorderedMaxPQ(int capacity){
		pq = (Key[]) new Comparable[capacity];
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	public void insert(Key x){
		if(pq.length == size()){
			resize(size() * 2);
		}
		pq[N++] = x;
	}
	
	public void resize(int newSize){
		Key[] resized = (Key[]) new Comparable[newSize];
		for(int i = 0; i < pq.length; i++){
			resized[i] = pq[i];
		}
		pq = resized;
	}
	
	public Key delMax(){
		int max = 0;
		for(int i = 0; i < N; i++){
			if(less(max, i)){
				max = i;
			}
		}
		//when it finds the max, it will move it to the end of the array, then we
		//remove the last item --N
		exchange(max, N - 1);
		
		//remember the N is always incremented, so do --N to get the last item
		Key toBeDeleted = pq[--N];
		pq[N] = null;
		
		//we do --N to prevent loitering
		if(N > 0 && pq.length == N/4){
			resize(N/4);
		}
		return toBeDeleted;
	}
	
	private boolean less(int i, int j){
		return (pq[i].compareTo(pq[j]) < 0);
    }
	
	private void exchange(int i, int j){
		Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
	
	public static void main(String args[]){
		UnorderedMaxPQ<String> queue = new UnorderedMaxPQ<String>(2);
		queue.insert("i");
		queue.insert("am");
		queue.insert("liking");
		queue.insert("peasants");
		queue.insert("algorithms");
		
		System.out.println(queue.delMax());
	}
}
