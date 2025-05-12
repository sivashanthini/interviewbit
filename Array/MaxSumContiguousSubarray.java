/*
Problem Description
Find the contiguous subarray within an array, A of length N which has the largest sum.

Problem Constraints
1 <= N <= 106
-1000 <= A[i] <= 1000

Input Format
The first and the only argument contains an integer array, A.

Output Format
Return an integer representing the maximum possible sum of the contiguous subarray.

Examples

Input 1:
A = [1, 2, 3, 4, -10]

Output 1:
10

Explanation 1:
The subarray [1, 2, 3, 4] has the maximum possible sum of 10.

Input 2:
A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

Output 2:
6

Explanation 2:
The subarray [4,-1,2,1] has the maximum possible sum of 6.

Kadane's Algorithm
The Intuition behind the code is to find the maximum sum of a contiguous subarray within the given array nums.
It does this by scanning through the array and keeping track of the current sum of the subarray.
Whenever the current sum becomes greater than the maximum sum encountered so far, it updates the maximum sum.
If the current sum becomes negative, it resets the sum to 0 and starts a new subarray.
By the end of the loop, the code returns the maximum sum found.
 */
package Array;

public class MaxSumContiguousSubarray {
    public int findMaxSumContiguousSubarray(int[] nums) {
        long maxSum = Integer.MIN_VALUE; // Initialize maxSum to the smallest possible integer value
        long sum = 0;                    // Current running sum of subarray

        // Loop through each element in the array
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];                          // Add current element to running sum
            maxSum = Math.max(maxSum, sum);          // Update maxSum if current sum is greater

            if (sum < 0) {
                sum = 0; // If running sum becomes negative, reset it to 0 (start new subarray)
            }
        }

        // Return the maximum subarray sum, cast back to int
        return (int) maxSum;
    }
}
