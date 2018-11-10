public class RemoveFromList {

    /**
     * My attempt at making a method that removes a single element from a java new_array
     * @param array Array to remove element from
     * @param val_to_remove Value to remove from array
     */
    public static int[] remove_array_element (int[] array, int val_to_remove) {
        int length = array.length;
        int[] new_array = new int(length);
        int start = -1;
        for(int i = 0; i < length; i++) {
            if(array[i] == val_to_remove) {
                start = i;
                break;
            } else {
                new_array[i] = array[i];
            }
        }
        //We've exited the loop;
        for(int i = start+1; i < length; i++) {
            new_array[i-1] = array[i];
        }
    }

    public static void main(String args[]) {
        int[] a = {1, 2, 3, 4};
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        int[] b = remove_array_element(a, 3);
        for(int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
