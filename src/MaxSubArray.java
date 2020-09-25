/**
 * @author Sebrianne Ferguson
 * Problem: find the series of contiguous elements with
 * the maximum sum in any given array and return
 * the sum.
 */

public class MaxSubArray {
    /**
     * bruteForce()
     * Idea: calculate the sum of every possible subarray and return
     * the one with the maximum sum.
     * O(n^2) time complexity
     *
     * @param A the list to iterate through
     * @return the sum of the max subarray
     */
    public static int bruteForce(int A[]) {
        int maxSum = Integer.MIN_VALUE;
        int start = 0, end = 0; // start/end points of subarray
        for (int left = 0; left < A.length; left++) {
            int currentSubSum = 0;
            for (int right = left; right < A.length; right++) {
                currentSubSum += A[right];
                // check if you've found a higher sum
                if (currentSubSum > maxSum) {
                    maxSum = currentSubSum;
                    start = left;
                    end = right;
                }
            }
        }
        System.out.printf("Found maximum subarray between %d and %d \n", start, end);
        return maxSum;
    }

    /**
     * dynamicSolution()
     * uses Kadane's algorithm to dynamically find the solution
     * we find the "optimal subproblems"
     * approach:
     * - find the max sum, and see if any element of the subarray is
     * greater than the max sum
     * - you can do this by iterating the array only one time!
     *
     * @param A the list
     * @return the sum
     */
    public static int dynamicSolution(int[] A) {
        int start = 0, end = 0; // start and end of subarray
        int maxSoFar = 0, maxEndingHere = 0;

        for (int i = 0; i < A.length; i++) {
            // if the element is greater than adding it to the subarray sum
            if (A[i] > (maxEndingHere + A[i])) {
                // forget the other elements and start your subarray here
                start = i;
                maxEndingHere = A[i];
            } else {
                // update the subarray sum
                maxEndingHere += A[i];
            }
            // if the subarray sum is greater than what you have so far
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                // change the end to update length of subarray
                end = i;
            }
        }
        System.out.printf("Found maximum subarray between %d and %d \n", start, end);
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] test = {-2, -3, 4, -1, -2, 1, 5, 3};
        System.out.print("Brute force: ");
        System.out.println(bruteForce(test));
        System.out.print("Dynamic solution: ");
        System.out.println(dynamicSolution(test));

    }
}
