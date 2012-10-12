package Algorithms;
import java.util.NoSuchElementException;

public class Stack {
	private int N;
	private Node top;
	
	private class Node{
		Node next;
		int val;
	}
	
	public Stack(){
		N = 0;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public void push(int val){
		Node oldTop = null;
		if(top != null){
			oldTop = top;
		}
		
		Node newTop = new Node();
		newTop.val = val;
		top = newTop;
		top.next = oldTop;
		N++;
	}
	
	public int pop(){
		if(isEmpty()){
			 throw new NoSuchElementException("Stack underflow");
		}
		
		int toBePopped = top.val;
		top = top.next;
		N--;
		return toBePopped;
	}
	
	public int peek(){
		return top.val;
	}
	
	public static void main(String args[]){
		Stack s1 = new Stack();
		s1.push(1);
		s1.push(2);
		System.out.println(s1.pop());
	}
	
	
}
