/**
* Implementation of Timsort, Mergesort algorithm
* that uses natural runs to increase the speed of
* sorting.
* @author Ryan Jones
* @version 1.0 - 2017/11/16
*/
public class Timsort {

    private int[] array;

    /**
    Default constructor
    */
    public Timsort() {
        this.array = new int[0];
    }

    /**
    * Constructor that intitializes array to someting other than zero
    *
    * @param arraySize Size of new array
    */
    public Timsort(int arraySize) {
        this.array = new int[arraySize];
    }

    /**
    * Method finds runs in the list and runs the merge() method to get them sorted
    */
    public void sort() {
        int f1 = 0,
            f2 = 0,
            s1 = 0,
            s2 = 0,
            n = 0;

        while(true) {
            f2 = findRun(f1);
            if(f2 == this.array.length-1 && f1 == 0) {
                break; //Array is sorted, since there was only one run
            }

            if(f2 == this.array.length - 1) { //First run reached the end;
                f1  = 0;
                f2 = 0;
                continue; //Return to the beginning, since we can't fit in another run
            }

            s1 = f2 + 1;
            s2 = findRun(s1);

            merge(f1, f2, s1, s2);

            if(s2 == this.array.length - 1) f1 = 0;
            else f1 = s2 + 1;
        }
    }

    /**
    * Private merge method merges runs. Probably buggy right now
    */
    private void merge(int f1, int f2, int s1, int s2) {
        if(this.array[s1] < this.array[f1]) swap(this.array, f1, s1); // do a check for single-value runs;

        while(f1 < f2 + 1 && s1 < s2 + 1) {
            if(this.array[s1]) < this.array[f1]) swap(this.array, s1++, f1);
            else f1++;
        }
    }

    private int findRun(int start) {
        int current = start;
        while(current + 1 < array.length && this.array[current + 1] > this.array[current]) {
            current++;
        }
        return current;
    }

    private void swap(int[] a, int b, int c) {
        int temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }
}
