package Algorithms;

public class MinStack extends Stack{
	private Stack s1;
	private Stack min;
	
	public MinStack(){
		s1 = new Stack();
		min = new Stack();
	}
	
	public void push(int val){
		
		if(!min.isEmpty()){
			if(min.peek() > val){
				min.push(val);
			}
		}
		else{
			min.push(val);
		}
		
		s1.push(val);
	}
	
	public int pop(){
		int toBePopped = s1.pop();
		
		if(min.peek() == toBePopped){
			min.pop();
		}
		
		return toBePopped;
	}
	
	public int min(){
		return min.peek();
	}
	
	public static void main(String args[]){
		MinStack min = new MinStack();
		min.push(10);
		min.push(20);
		min.push(4);
		min.push(19);
		min.push(2);
		
		System.out.println(min.min());
		min.pop();
		System.out.println(min.min());
		min.pop();
		System.out.println(min.min());
		min.pop();
		System.out.println(min.min());
		
	}
	
	
}
