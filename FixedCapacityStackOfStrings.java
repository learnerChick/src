/**
 * The drawback of arrays is the size is fixed. But each operation takes a constant amortized time.(bases on resize pop/push).
 * Less wasted space.
 */

public class FixedCapacityStackOfStrings {
    private String[] s;
    private int N = 0;
    
    public FixedCapacityStackOfStrings(int capacity){
        s = new String[capacity];
    }
    
    public boolean isEmpty(){
        return N == 0;
    }
    
    public void push(String item){
        s[N++] = item;
    }
    
    /*A better idea is to 
      resize the array when the array is full by doubling its size and copying the items.
      * As the number of items gets larger, the times to resize reduces.
    */
    public void pushResize(String item){
        if(N == s.length){
            resize(2 * s.length);
        }
        s[N++] = item;
    }
    
    //--N is prefix.  It reduces the value of N by 1 and returns the new value
    //N++ is postfix.  It adds 1 to N and returns the old value.
    public String pop(){
        String item = s[--N];
        s[N] = null;
        return item;
    }
    
    /* only half the size of the array when it's 1/4 full. */
    public String resizePop(){
        String item = s[--N];
        s[N] = null;
        if(N > 0 && N == s.length/4){
            resize(s.length/2);
        }
        return item;
    }
    
    public void resize(int capacity){
        String[] copy = new String[capacity];
        for(int i = 0; i < s.length; i++){
            copy[i] = s[i];
        }
        s = copy;
    }
    
    public static void main(String[] args){
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(10);
        stack.push("to");
        stack.push("be");
        stack.push("or");
        stack.push("not");
        stack.push("to");
        stack.push("be");
        
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        
        
        FixedCapacityStackOfStrings stack2 = new FixedCapacityStackOfStrings(3);
        stack2.pushResize("to");
        stack2.pushResize("be");
        stack2.pushResize("or");
        stack2.pushResize("not");
        stack2.pushResize("to");
        stack2.pushResize("be");
        
        System.out.println(stack2.resizePop());
        System.out.println(stack2.resizePop());
        System.out.println(stack2.isEmpty());
    }
}
