/**
* How do you improve arguably the worst algorithm in existence?
* Well, you don't. This still runs in quadratic time, compounded
* by the fact that this also sorts the arrays, so the run-time
* sticks around ~N^2 + N time. The only improvement made by This
* code is the short-circuit I could build in with the sorted array.
*
* This means that any time I get to a value greater than the one
* I am looking for, I can quit the loop (and return false) because
* I know that I won't find it any later in the array.
*/

public class ImprovedBruteForce {

    /**
    * Search function short-circuits when it gets to a value
    * larger than what it is searhing for, since the array it
    * is searching is sorted already.
    *
    * @param a Array to check
    * @param b Int to look for
    */
    public boolean search(int a[], int b) {
        for(int i=0; i<a.length; i++) {
            if(a[i] > b)  return false;
            if(a[i] == b) return true;
        }
        // default case, should only return this if the entry
        //we are looking for is greater than the last entry in the list
        return false;
    }

    /**
    * Main method of the program
    */
    public static void main(String args[]) {

        //Arrays to search
        int[] x = {4, 1, 7, 5, 23, 65, 212, 2, 9, 87, 54};
        int[] y = {4, 1, 5, 23, 65, 212, 87, 54};

        //sorting of arrays
        Arrays.sort(x);
        Arrays.sort(y);

        //searching of array values
        //prints out values in x that are not in y
        for(int i=0; i<x.length; i++) {
            if(!search(y, x[i])) System.out.println(x[i]);
        }
    }
}
