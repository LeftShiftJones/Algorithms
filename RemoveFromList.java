public class RemoveFromList {

    /**
     * My attempt at making a method that removes a single element from a java new_array
     * @param array Array to remove element from
     * @param val_to_remove Value to remove from array
     */
    public static int[] remove_array_element (int[] array, int val_to_remove) {
        int length = array.length;
        int[] new_array = new int[length-1];
        int start = -1;
        for(int i = 0; i < length-1; i++) {
            if(array[i] == val_to_remove) {
                start = i;
                break;
            } else { //should run for every iteration that is not the number
                new_array[i] = array[i];
            }
        }
        if(start == -1) { //got to end, either did not find or value was at the end
            if(array[length-1] == val_to_remove) { //return new array if it was the last item
                return new_array;
            }
            System.out.println("Element not observed in list... returning original array.");
            return array;
        }
        //We've exited the loop;
        for(int i = start+1; i < length; i++) {
            new_array[i-1] = array[i];
        }
        return new_array;
    }

    public static void main(String args[]) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        int num = 1;
        num = (int) (num * 0.1);
        System.out.println("Num: " + num);

        System.out.println();
        int[] b = remove_array_element(a, 16);

        for(int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
