/*
Problem Description
You are given an array of N integers, A1, A2 ,..., AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.

Problem Constraints
1 <= |A| <= 105
-109 <= Ai <= 109

Input Format
The first argument is an integer array A.

Output Format
Return an integer equal to the maximum value of f(i, j)


Examples

Input
A = [1, 3, -1]

Output
5

Explanation
Given A = [1, 3, -1],
f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5
The maximum value is 5, which is of f(2, 3)

abs(A) + abs(B) = max(A+B, A-B, -A+B, -A-B)
-A+B = -(A-B)
-A-B = -(A+B)
 */
package Array;

public class MaxAbsoluteDifference {
    public int maxArr(int[] A) {
        // We track the maximum and minimum values of two expressions:
        // Expression 1: A[i] + i
        // Expression 2: A[i] - i
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        // Iterate over the array to compute the max and min for both expressions
        for (int i = 0; i < A.length; i++) {
            // max and min for A[i] + i
            max1 = Integer.max(max1, A[i] + i);
            min1 = Integer.min(min1, A[i] + i);

            // max and min for A[i] - i
            max2 = Integer.max(max2, A[i] - i);
            min2 = Integer.min(min2, A[i] - i);
        }

        // The result is the maximum of the differences of the two expressions:
        // This effectively computes the maximum of:
        // |A[i] - A[j]| + |i - j| over all i, j
        return Math.max(max1 - min1, max2 - min2);
    }
}
