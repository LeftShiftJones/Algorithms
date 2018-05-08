/**********************************************
    Class that demonstrates the application of 
        array functions that add up values from
        i to j, such that j > i.
    Written for COS 320: Algorithm Analysis
    
    @author Ryan Jones
    @version 1.0
    Date: 02/25/2018
 **********************************************/
public class ArrayIndexing {

    /**********************************************
     * Main method of the program
     **********************************************/
    public static void main(String args[]) {
    
        int[] a = {1,2,3,4};
        inefficientAddIJ(a);
        efficientAddIJ(a);
    }

    /**********************************************
     * Improved version of algorithm for adding from
     * i to j. Runs in O(n^2) time.
    **********************************************/
    public static void efficientAddIJ(int[] a) {
        //initialize new 2D array
        int[][] b = new int[a.length][a.length];

        //create sum variable
        int sum = 0;
        for(int i = 0; i < a.length; i++) {
            //set sum to a[i]
            sum = a[i];
            for(int j = i+1; j < a.length; j++) {
                //add a[j] to sum and set b[i][j] to sum
                sum += a[j];
                b[i][j] = sum;
            }
        }

        print2DArray(b, a.length);
    }

    /**********************************************
     * Regular version of algorithm for adding from
     *  i to j. Runs in O(n^3)
     **********************************************/
    public static void inefficientAddIJ(int[] a) {
        //initialize new 2D array
        int[][] b = new int[a.length][a.length];

        //begin iteration
        for(int i = 0; i < a.length; i++) {
            for(int j = i+1; j < a.length; j++) {
                int sum = 0;
                for(int k = i; k <= j; k++) {
                    sum += a[k];
                }
                b[i][j] = sum;
            }
        }
        //print out array
        print2DArray(b, a.length);
    }

    /**********************************************
     *  Method prints out all the values 
     *   in a 2D Array
     **********************************************/
    public static void print2DArray(int a[][], int l) {
        for(int i = 0; i < l; i++) {
            for(int j = 0; j < l; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
