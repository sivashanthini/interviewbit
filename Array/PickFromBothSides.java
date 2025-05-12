/*Problem Description

Given an integer array A of size N.
You can pick B elements from either left or right end of array A to get the maximum sum.
Find and return this maximum possible sum.

NOTE: Suppose B = 4 and array A contains 10 elements then
    You can pick the first four elements or can pick the last four elements or can pick 1 from the front and 3 from the back etc. you need to return the maximum possible sum of elements you can pick.

Problem Constraints

1 <= N <= 105
1 <= B <= N
-103 <= A[i] <= 103

Input Format

First argument is an integer array A.
Second argument is an integer B.

Output Format

Return an integer denoting the maximum possible sum of elements you picked.

Examples

Input 1:
A = [5, -2, 3 , 1, 2]
B = 3

Output 1:
8

Explanation 1:
Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8

Input 2:
A = [1, 2]
B = 1

Output 2:
2

Explanation 2:
Pick element 2 from end as this is the maximum we can get

The question is asking us to find the maximum sum of values at the left and right edges of the array.
More specifically, it's asking us to find the max sum of k values at the edges.
If we were to reword the question, we're essentially asked to find the minimum subarray sum of length n - k.
Once we find this, we simply subtract this from the total sum and this would be our answer.
 *
 */

package Array;

public class PickFromBothSides {
    public int findMaxSumFromBothSides(int[] A, int k) {
        int total = 0;        // Total sum of the array
        int current = 0;      // Running sum of the sliding window
        int maxSum = 0;       // Maximum sum of the subarray of length n - k (elements *not* picked)
        int n = A.length;

        // Step 1: Calculate the total sum and simultaneously find the max sum of a window of size (n - k)
        for (int i = 0; i < n; i++) {
            total += A[i];     // Update total sum
            current += A[i];   // Add current element to the window sum

            if (i < (n - k)) {
                // For the first (n - k) elements, keep adding to maxSum
                maxSum += A[i];
            } else {
                // Slide the window forward
                current -= A[i - (n - k)];          // Remove the element leaving the window
                maxSum = Math.max(maxSum, current); // Update maxSum if current is greater
            }
        }

        // Step 2: Subtract the largest unpicked subarray sum from the total
        // This gives the maximum sum by picking k elements from either end
        return total - maxSum;
    }
}
