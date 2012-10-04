/**
 * quadratic running t ime(n2).  Doesn't matter the order of the input. It will still go through all inputs and exchange them.
 * Not a stable sort because of that.
 */
public class Selection {
    public static void sort(Comparable[] a){        
        for(int i=0; i < a.length; i++){
            int min = i;
            for(int j = i+1; j < a.length; j++){
                if(less(a[j], a[min])){
                    min = j;
                }
            }
            exchange(a, i, min);
        }
        show(a);
    }
    
    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }
    
    private static boolean more(Comparable a, Comparable b){
        return a.compareTo(b) > 0;
    }
    
    private static boolean equal(Comparable a, Comparable b){
        return a.compareTo(b) == 0;
    }
    
    private static void exchange(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    
    public static void main(String[] args){
        String[] arr = {"amazamenet", "me", "2","one","blah","jean"};
        Selection.sort(arr);
    }
}
