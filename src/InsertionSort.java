import java.util.Arrays;

/**
 * InsertionSort
 *
 * @author Sebrianne Ferguson
 * demonstrate how to implement the insertion sort algorithm
 * Algorithm adopted from: Introduction to Algorithms (3rd Ed) By Cormen et. al.
 */

public class InsertionSort {
    /**
     * sort()
     *
     * @param A the original array to sort
     * @return the original array with its elements sorted
     */
    public static int[] sort(int[] A) {
        for (int j = 1; j < A.length; j++) {
            int key = A[j];
            // insert A[j] into the sorted sequence A[1...j-1]
            int i = j - 1;
            while (i >= 0 && A[i] > key) {
                A[i + 1] = A[i];
                i--;
            }
            A[i + 1] = key;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] test = {47, 22, 5, 30, 14, 7, 100, 38};
        System.out.print("Original Array: ");
        System.out.println(Arrays.toString(test));
        System.out.print("After Insertion Sort: ");
        System.out.println(Arrays.toString(sort(test)));

        /*
        Output:
        Original Array: [47, 22, 5, 30, 14, 7, 100, 38]
        After Insertion Sort: [5, 7, 14, 22, 30, 38, 47, 100]
         */
    }
}
