/**
 *   N^2 log N times
 * 
 */
import java.util.Arrays;
import java.io.File;
import java.util.Scanner;
import java.io.*;

public class ThreeSum {
    

    public static int count(int[] nums) {
        int len = nums.length;
        //First sort the array
        Arrays.sort(nums);
        int count = 0;
        /*Then, in a double for loop, sum up the two numbers, negate it and then try to find the 
        negated value.  If the found index is higher than j(cannot be lower because it could
        be the same number)*/
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int k = Arrays.binarySearch(nums, -(nums[i] + nums[j]));
                if (k > j) {
                    count++;
                    StdOut.println(nums[i] + " " + nums[j] + " " + nums[k]);
                }
            }
        }
        return count;
    }

  
    public static void main(String[] args) {
        try {
            Scanner f = new Scanner(new File("C:/Users/Dhana/Desktop/Learning/Java/Algorithms/src/algorithms/data/data2.txt"));
            if (f.hasNextLine()) {
                String[] fields = f.useDelimiter("\\A").next().trim().split("\\s+");
                int[] vals = new int[fields.length];
                for (int i = 0; i < fields.length; i++) {
                    vals[i] = Integer.parseInt(fields[i]);
                }
                System.out.println (count(vals));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
