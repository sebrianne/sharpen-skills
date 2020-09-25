import java.util.Arrays;

/**
 * QuickSort
 *
 * @author Sebrianne Ferguson
 * demonstrate how to implement the quick sort algorithm
 * Algorithm adopted from: Introduction to Algorithms (3rd Ed) By Cormen et. al.
 */

public class QuickSort {
    /**
     * sort()
     *
     * @param A
     * @param p
     * @param r
     */
    public static void sort(int[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            sort(A, p, q - 1);
            sort(A, q + 1, r);
        }
    }

    /**
     * partition()
     *
     * @param A
     * @param p
     * @param r
     * @return
     */
    public static int partition(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A[j] < x) {
                i++;
                // exchange A[i] and A[j]
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        // exchange A[i+1] with A[r]
        int temp = A[i + 1];
        A[i + 1] = A[r];
        A[r] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] test = {47, 22, 5, 30, 14, 7, 100, 38};
        System.out.print("Original Array: ");
        System.out.println(Arrays.toString(test));
        System.out.print("After Quick Sort: ");
        sort(test, 0, (test.length - 1));
        System.out.println(Arrays.toString(test));

        /*
        Output:
        Original Array: [47, 22, 5, 30, 14, 7, 100, 38]
        After Quick Sort: [5, 7, 14, 22, 30, 38, 47, 100]
         */
    }
}
