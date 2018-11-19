/**********************************************
    Program that finds the Greatest Relative Maximum (GRM)
    GRM = Value that is strictly greater than its neighbors
    Written for COS 320: Algorithm Analysis

    NOTE: Program was originally supposed to work
    for strictly distinct values, however this version
    works with arrays that contain all one value

    @author Ryan Jones
    @version 1.0
    Date: 02/24/2017
 **********************************************/

public class FindBiggest {
    /** Global boolean to track if array values are unique or all the same */
    private static boolean  distinct = false,
                            solution = false;

    /**********************************************
        Main method of the program
    **********************************************/
    public static void main(String args[]) {
        //array to test
        int[] a = {0 /**INSERT ARRAY VALUES HERE*/};
        findBiggest(0, a.length-1, a);
        if(!solution) System.out.println("No solution exists");
        else if(!distinct) System.out.println("Array was made of all the same value: " + a[0]);
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
            solution=true;
            System.out.println(a[0]);
            return;
        }
        if(a.length == 2) {
            if(a[0] > a[1]){ //handles same and different case
                distinct = true;
                solution = true;
                System.out.println(a[0]);
            } else if(a[1] > a[0]) {
                distinct = true;
                solution = true;
                System.out.println(a[1]);
            } else {
                solution = true;
                System.out.println(a[0]);
            }
            return;
        }

        //recursion would hit value before this point,
        //reduces chance of out-of-bounds errors
        if(hi-lo < 2) return;
        //set mid value
        int mid = lo + (hi - lo) / 2;
        if(a[lo] != a[mid] || a[mid] != a[hi] || a[lo] != a[hi]) {
            distinct = true;
        }
        //check values
        if(lo == 0) {
            if(a[lo] > a[lo+1]) {
                solution = true;
                System.out.println(a[lo]);
                System.exit(1);
            }
        } else {
            if(a[lo] > a[lo-1] && a[lo] > a[lo+1]) {
                solution = true;
                System.out.println(a[lo]);
                System.exit(1);
            }
        }
        if(hi == a.length-1) {
            if(a[hi] > a[hi-1]) {
                solution = true;
                System.out.println(a[hi]);
                System.exit(1);
            }
        } else {
            if(a[hi] > a[hi-1] && a[hi] > a[hi+1]) {
                solution = true;
                System.out.println(a[hi]);
                System.exit(1);
            }
        }
        if(mid > 0 && mid < a.length-1 && a[mid] > a[mid-1] && a[mid] > a[mid+1]) {
            solution = true;
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
