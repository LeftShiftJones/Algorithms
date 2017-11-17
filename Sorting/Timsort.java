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
    * Constructor that takes an integer array as an argument, copies it over
    *
    * @param newArray Array to copy over
    */
    public Timsort(int[] newArray) {
        this.array = newArray;
    }

    /**
    * Method finds runs in the list and sorts them with merge()
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
                continue; //Return to the beginning, since we ran out of runs
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
    *
    * @param f1 First run, first pointer
    * @param f2 First run, second pointer
    * @param s1 Second run, first pointer
    * @param s2 Second run, second pointer
    */
    private void merge(int f1, int f2, int s1, int s2) {
        if(this.array[s1] < this.array[f1]) swap(this.array, f1, s1); // do a check for single-value runs;

        while(f1 < f2 + 1 && s1 < s2 + 1) {
            if(this.array[s1]) < this.array[f1]) swap(this.array, s1++, f1);
            else f1++;
        }
    }

    /**
    * This simple method finds a run using a pointer by advancing until the next
    * array value is smaller than the current;
    *
    * @param start Index to start run from
    * @return Last index of run
    */
    private int findRun(int start) {
        int current = start;
        while(current + 1 < array.length && this.array[current + 1] > this.array[current]) {
            current++;
        }
        return current;
    }

    /**
    * Swap method -- does exactly what it says
    *
    * @param a Array to
    */
    private void swap(int[] a, int b, int c) {
        int temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }
}
