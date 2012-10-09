/**
 *  Begin with unsorted list.  Then place a marker after first item.  
 *  This divides the list into a "sorted and unsorted list".
 *  Repeatedly compare first unsorted number with the numbers in sorted section.  
 *  If it finds a lower number, it swaps them.
 *  Then pointer is moved to the right.
 *  Best case - if array is in ascending order, insertion sort makes N-1 compares and 0 exchanges. 0(n)
 *  Average case/Worst case - array is in descending order, N2 compares and N2 and exchanges 0(n2)
 *  Stable sort
 */
public class Insertion {

    public static void sort(Comparable[] a) {
        for(int i = 0; i<a.length; i++){
            for(int j=i; j > 0; j--){
                if(less(a[j], a[j-1])){
                    exchange(a,j,j-1);
                }
                else{
                    break;
                }
            }
        }
        show(a);
    }

    //think about this such that b-a < 0
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static boolean more(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }

    private static boolean equal(Comparable a, Comparable b) {
        return a.compareTo(b) == 0;
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        String[] arr = {"amazamenet", "me", "2", "one", "blah", "jean"};
        Insertion.sort(arr);
    }
}
