import java.util.Arrays;

/**
 * MergeSort
 *
 * @author Sebrianne Ferguson
 * demonstrate how to implement the insertion sort algorithm
 * Algorithm adopted from:
 * Introduction to Algorithms (3rd Ed) By Cormen et. al.
 * GeeksforGeeks.com
 */

public class MergeSort {
    /**
     * sort()
     *
     * @param A
     * @param p
     * @param r
     */
    public static void sort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            sort(A, p, q);
            sort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    /**
     * merge()
     * p <= q < r
     *
     * @param A
     * @param p
     * @param q
     * @param r
     */
    public static void merge(int[] A, int p, int q, int r) {
        // determine size of subarrays to be merged
        int n1 = q - p + 1;
        int n2 = r - q;
        // let L[1..n1+1] and R[1..n2+1] be new arrays
        int L[] = new int[n1];
        int R[] = new int[n2];
        // split the list values into L and R
        for (int i = 0; i < n1; ++i) {
            L[i] = A[p + i];
        }
        for (int i = 0; i < n2; ++i) {
            R[i] = A[q + 1 + i];
        }
        int i = 0, j = 0;
        int k = p;
        // copy the min(n1, n2) number of elements
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
            k++;
        }
        // copy any remaining elements
        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {
        int[] test = {47, 22, 5, 30, 14, 7, 100, 38};
        System.out.print("Original Array: ");
        System.out.println(Arrays.toString(test));
        System.out.print("After Merge Sort: ");
        sort(test, 0, test.length - 1);
        System.out.println(Arrays.toString(test));

        /*
        Output:
        Original Array: [47, 22, 5, 30, 14, 7, 100, 38]
        After Insertion Sort: [5, 7, 14, 22, 30, 38, 47, 100]
         */
    }
}
