import java.util.Arrays;
/**
 * Divide into 2 halves, recursively sort each half and then merge both halves.
 * Fast in reverse order as in arbitrary order.
 * 
 */
public class Mergesort {
    
    
    private static int[] mergesort(int[] a){
        int[] output = new int[a.length];
        
        if(a.length <= 1){
            return a;
        }
        int mid = a.length/2;
        
        int[] left = Arrays.copyOfRange(a, 0, mid);
        int[] right = Arrays.copyOfRange(a, mid, a.length);
        
        // Recursively merge sort the left and right side of the array.
        left = mergesort(left);
        right = mergesort(right);
        
        output = merge(left, right);
        
        return output;
    }
    
    private static int[] merge(int[] left, int[] right){
        int[] result = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i < left.length  && j < right.length){
            if(left[i] > right[j]){
                result[k] = right[j];
                j++;
            }
            else{
                result[k] = left[i];
                i++;
            }
            k++;            
        }
        
        //append whatever is left from left array into result array
        while(i < left.length){
            result[k] = left[i];
            i++;
            k++;
        }
        
        //Append whatever is left from the right array into the result array.
        while(j < right.length){
            result[k] = right[j];
            j++;
            k++;
        }
        return result;
    }
    
    public static void main(String[] args) {
        //int[] a = {6,5,19,12,3,1,8,7,2,4};
        int[] a = {4,3,1,5};
        int b[] = Mergesort.mergesort(a);
        print(b);
    }
    
    private static void print(int[] a){
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }
}
