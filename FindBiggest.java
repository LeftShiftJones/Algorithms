/**********************************************
    Program that finds the Greatest Relative Maximum (GRM)
    GRM = Value that is strictly greater than its neighbors
    Written for COS 320: Algorithm Analysis

    @author Ryan Jones
    @version 1.0
    Date: 02/24/2017
 **********************************************/

public class FindBiggest {
    /** Global boolean to track if array values are unique or all the same */
    private static boolean distinct = false;

    /**********************************************
        Main method of the program
    **********************************************/
    public static void main(String args[]) {
        //array to test
        int[] a = {/**INSERT ARRAY VALUES HERE*/};
        findBiggest(0, a.length-1, a);
        if(!distinct) System.out.println(a[0]);
    }

    /**********************************************
        Function that recursively searches 
        array for a relative maximum
        @param lo Low int value to search in array
        @param hi High int value to search in array
        @param a Array to check
     **********************************************/
    public static void findBiggest(int lo, int hi, int[] a) {

        //empty array
        if(a.length < 1) return;
        //Cases for small arrays
        if(a.length == 1) {
            System.out.println(a[0]);
            return;
        }
        if(a.length == 2) {
            if(a[0] > a[1] || a[0] == a[1]){
                distinct = true;
                System.out.println(a[0]);
            } else if(a[1] > a[0]) {
                distinct = true;
                System.out.println(a[1]);
            }
            return;
        }

        //recursion would hit value before this point,
        //reduces chance of out-of-bounds errors
        if(hi-lo < 2) return;
        //set mid value
        int mid = lo + (hi - lo) / 2;

        //check values
        if(lo == 0) {
            if(a[lo] > a[lo+1]) {
                distinct = true;
                System.out.println(a[lo]);
                System.exit(1);
            }
        } else {
            if(a[lo] > a[lo-1] && a[lo] > a[lo+1]) {
                distinct = true;
                System.out.println(a[lo]);
                System.exit(1);
            }
        }
        if(hi == a.length-1) {
            if(a[hi] > a[hi-1]) {
                distinct = true;
                System.out.println(a[hi]);
                System.exit(1);
            }
        } else {
            if(a[hi] > a[hi-1] && a[hi] > a[hi+1]) {
                distinct = true;
                System.out.println(a[hi]);
                System.exit(1);
            }
        }
        if(mid > 0 && mid < a.length-1 && a[mid] > a[mid-1] && a[mid] > a[mid+1]) {
            distinct = true;
            System.out.println(a[mid]);
            System.exit(1);
        }

        //recurse if no maximum has been found
        findBiggest(lo, mid, a);
        findBiggest(mid, hi, a);

        //removed printing of value if all values are the same;
        // Instead I tracked whether or not values were distinct with
        // a global boolean value;
    }
}
