import java.util.Arrays;

/**
 * HeapSort
 *
 * @author Sebrianne Ferguson
 * demonstrate how to implement the heap sort algorithm
 * Algorithm adopted from:
 * Introduction to Algorithms (3rd Ed) By Cormen et. al.
 * GeeksforGeeks
 */

public class HeapSort {
    /**
     * sort()
     *
     * @param A the original array to sort
     * @return the original array with its elements sorted
     */
    public static void sort(int[] A) {
        buildMaxHeap(A);
        for (int i = A.length - 1; i >= 0; i--) {
            // exchange A[0] with A[i]
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            maxHeapify(A, i, 0);
        }
    }

    public static void buildMaxHeap(int[] A) {
        int heapsize = A.length;
        for (int i = (heapsize / 2) - 1; i >= 0; i--) {
            maxHeapify(A, heapsize, i);
        }
    }

    /**
     * maxHeapify
     * takes an array A and starting from index and performs a heap
     * operation recursively.
     *
     * @param A
     * @param heapsize
     * @param index
     */
    public static void maxHeapify(int[] A, int heapsize, int index) {
        int l = left(index);
        int r = right(index);
        int largest = index;
        // find out of the left, right, and root which value is largest
        if (l < heapsize && A[l] > A[largest]) {
            largest = l;
        }
        if (r < heapsize && A[r] > A[largest]) {
            largest = r;
        }
        // if the root is not the largest value, exchange A[i] with A[largest]
        if (largest != index) {
            int temp = A[index];
            A[index] = A[largest];
            A[largest] = temp;
            // since the subtree has changed, heapify the subtree
            maxHeapify(A, heapsize, largest);
        }

    }

    public static int parent(int i) {
        int p = i / 2;
        return p;
    }

    public static int left(int i) {
        return 2 * i;
    }

    public static int right(int i) {
        return 2 * i + 1;
    }

    public static void main(String[] args) {
        int[] test = {47, 22, 5, 30, 14, 7, 100, 38};
        System.out.print("Original Array: ");
        System.out.println(Arrays.toString(test));
        System.out.print("After Heap Sort: ");
        sort(test);
        System.out.println(Arrays.toString(test));

        /*
        Output:
        Original Array: [47, 22, 5, 30, 14, 7, 100, 38]
        After Insertion Sort: [5, 7, 14, 22, 30, 38, 47, 100]
         */
    }
}
