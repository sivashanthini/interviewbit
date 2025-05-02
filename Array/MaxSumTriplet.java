/*
Problem Description

Given an array A containing N integers.
You need to find the maximum sum of triplet ( Ai + Aj + Ak ) such that 0 <= i < j < k < N and Ai < Aj < Ak.
If no such triplet exist return 0.

Problem Constraints

3 <= N <= 105.
1 <= A[i] <= 108.

Input Format

First argument is an integer array A.

Output Format

Return a single integer denoting the maximum sum of triplet as described in the question.

Examples

Input 1:
A = [2, 5, 3, 1, 4, 9]

Output 1: 16

Explanation 1:
 All possible triplets are:-
    2 3 4 => sum = 9
    2 5 9 => sum = 16
    2 3 9 => sum = 14
    3 4 9 => sum = 16
    1 4 9 => sum = 14
  Maximum sum = 16

Input 2:
A = [1, 2, 3]

Output 2: 6

Explanation 2:
 All possible triplets are:-
    1 2 3 => sum = 6
 Maximum sum = 6

For any position, we need a number before it which is closest to it AND the largest number after it with the largest value.
Finding the maximum number after a given position can be done simply by using a suffix array based on the maximum value.

Finding the largest value before the current position which is still less than the current value needs a bit more thought.
If we had a sorted list, and wanted to find such a number then we could have used binary search. Let’s say, the mid is m.
If A[m] < A[secondNumberIndex], which means we got some number which is less than the second number,
we have found a potential first number.
Potential because there can be another number which is higher than A[m] but still less than
A[secondNumberIndex]. We should easily say that we should look for that number after the current m index.
If that is not the case, look before m index.

To make the above simpler, we can use TreeSet in Java that will help us in maintaining
the sorted list of numbers before the current position.
Then, to find the first number which is closest to second number but strictly less than that,
we can use the lower() method.
 */
package Array;

import java.util.TreeSet;

public class MaxSumTriplet {

    public int solve(int[] A) {
        int maxSum = 0, n = A.length;
        int[] maxSuffixArray = new int[n];
        maxSuffixArray[n-1] = A[n-1];

        for (int i = n-2; i >= 0; i--) {
            maxSuffixArray[i] = Math.max(maxSuffixArray[i+1], A[i]);
        }

        //TreeSet lower() -> Returns the greatest element in this set strictly less than the given element, or null if there is no such element.
        TreeSet<Integer> set = new TreeSet<>();
        set.add(Integer.MIN_VALUE); //to avoid null value if there is no number which is smaller than it

        for (int i = 0; i < n-1; i++) {
            int first = set.lower(A[i]);
            int second = A[i];
            int third = maxSuffixArray[i+1];
            if (first < second && second < third) {
                maxSum = Math.max(maxSum, first + second + third);
            }
            set.add(A[i]);
        }
        return maxSum;
    }

}
