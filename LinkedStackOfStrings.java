package algorithms;

/**
 *
 * @author Dhana
 * Every operation takes a constant time in the worst case.
 * Uses extra time and space to deal with links.
 * Better option if you want every operation to be fast.  
 * If you care about total time, then use the resizing array stack because individual operations will be faster.
 */
public class LinkedStackOfStrings {
    //first item is set to null
    private Node first = null;
    
    //inner class to hold a the node reference
    private class Node{
        String item;
        Node next;
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    
    public void push(String item){
        //save the current first node in a temp variable.  Then first is 
        //set to the new item and the next item of first is set to the temp
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }
    
    public String pop(){
        //save the item first to return it from first node, then set the first to point to the next node
        String item = null;
        if(!isEmpty()){
            item = first.item;
            first = first.next;
            return item;
        }
        return item;
    }
    
    public static void main(String[] args){
        LinkedStackOfStrings stack = new LinkedStackOfStrings();
        stack.push("to");
        stack.push("be");
        stack.push("or");
        stack.push("not");
        stack.push("to");
        stack.push("be");
        
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}
