import java.util.NoSuchElementException;

/* store three stacks on a single array */

public class ThreeStackArray {
	private int currentTotalItem;
	private int[] buffer;
	private int[] stackPointer = {0,0,0};
	
	public ThreeStackArray(){
		currentTotalItem = 40;
		buffer = new int[stackPointer.length * currentTotalItem];
	}
	
	public void push(int stackIndex, int val){
		int end = (currentTotalItem * (stackIndex - 1)) + stackPointer[stackIndex - 1];
		
		stackPointer[stackIndex - 1]++;
		buffer[end] = val;
	}
	
	public int pop(int stackIndex){
		if(isEmpty(stackIndex)){
			throw new NoSuchElementException("Stack is empty");
		}
		
		int top = (currentTotalItem * (stackIndex - 1))
				+ stackPointer[stackIndex - 1];
		int toBePopped = buffer[top - 1];
		buffer[top - 1] = 0;
		stackPointer[stackIndex - 1]--;
		return toBePopped;
	}   
	
	public int peek(int stackIndex){
		int top = (currentTotalItem * (stackIndex - 1)) + stackPointer[stackIndex-1];
		return stackPointer[top - 1];
	}
	
	public boolean isEmpty(int stackIndex){
		return (currentTotalItem * (stackIndex - 1)) + stackPointer[stackIndex-1]  == stackPointer[stackIndex-1];
	}
	
	public void print(){
		for(int i = 0; i < buffer.length; i++){
			System.out.print(buffer[i] + " ");
		}
	}
	
	public static void main(String args[]){
		ThreeStackArray stack = new ThreeStackArray();
		stack.push(1, 1);
		stack.push(1, 4);
		stack.push(1, 6);
		stack.push(2, 2);
		stack.push(2, 5);
		stack.push(2, 7);
		stack.push(3, 3);
		stack.push(3, 8);
		stack.push(3, 9);
		stack.print();
		System.out.println("");
		stack.push(3, 10);
		stack.print();
		stack.pop(3);
		stack.pop(2);
		stack.pop(2);
		stack.pop(2);
		stack.pop(2);
		stack.pop(3);
		System.out.println("");
		stack.print();
	}
}
