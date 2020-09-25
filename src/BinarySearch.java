import java.util.Arrays;

/**
 * BinarySearch
 *
 * @author Sebrianne Ferguson
 * demonstrate how to implement the binary search algorithm
 */

public class BinarySearch {
    public static int search(int[] A, int key, int low, int high) {
        // only compare x with the middle element if the high > low
        if (high >= low) {
            int middle = (high + low) / 2;
            if (A[middle] == key) { // found it!
                return middle;
            } else if (A[middle] > key) { // look at the left subarray
                return search(A, key, low, middle - 1);
            } else if (A[middle] < key) { // look at the right subarray
                return search(A, key, middle + 1, high);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test = {47, 22, 5, 30, 14, 7, 100, 38};
        System.out.print("Original Array: ");
        System.out.println(Arrays.toString(test));
        System.out.print("After Quick Sort and Binary Search: ");
        QuickSort.sort(test, 0, (test.length - 1));
        System.out.println(search(test, 30, 0, test.length - 1));
        /* Output:
            Original Array: [47, 22, 5, 30, 14, 7, 100, 38]
            After Quick Sort and Binary Search: 4
         */
    }
}
