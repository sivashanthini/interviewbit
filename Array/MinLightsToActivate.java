/*
Problem Description
There is a corridor in a Jail which is N units long. Given an array A of size N.
The ith index of this array is 0 if the light at ith position is faulty otherwise it is 1.
All the lights are of specific power B which if is placed at position X,
it can light the corridor from [X-B+1, X+B-1].
Initially all lights are off.
Return the minimum number of lights to be turned ON to light the whole corridor or -1 if the whole corridor cannot be lighted.

Problem Constraints
1 <= N <= 100000
1 <= B <= 10000

Input Format
First argument is an integer array A where A[i] is either 0 or 1.
Second argument is an integer B.

Output Format
Return the minimum number of lights to be turned ON to light the whole corridor or -1
if the whole corridor cannot be lighted.

Examples

Input 1:
A = [ 0, 0, 1, 1, 1, 0, 0, 1].
B = 3

Output 1:
2

Explanation 1:
In the first configuration, Turn on the lights at 2nd and 7th index.
Light at 2nd index covers from [ 1, 5] and light at 7th index covers [6, 8].

Input 2:
A = [ 0, 0, 0, 1, 0].
B = 3

Output 2:
-1

Explanation 2:
In the second configuration, there is no light which can light the first corridor.
 */
package Array;

public class MinLightsToActivate {
    public int findMinLightsToActivate(int[] A, int B) {
        int count = 0;           // To count the number of lights activated
        int n = A.length;        // Total number of positions
        int i = 0;               // Current position being considered

        while (i < n) {
            // Determine the furthest possible light to the right within range
            int right = Math.min(i + B - 1, n - 1);

            // Determine the leftmost position that can still cover position i
            int left = Math.max(i - B + 1, 0);

            boolean flag = false; // To check if a valid light is found in range

            // Try to find a light (A[x] == 1) from right to left within [left, right]
            while (right >= left) {
                if (A[right] == 1) {
                    flag = true; // Found a light that can cover position i
                    break;
                }
                right--; // Move left to find a light
            }

            // If no light found that can cover the current position, return -1
            if (!flag) {
                return -1;
            }

            count++;           // Light is activated
            i = right + B;     // Move to the next position that is not covered yet
        }

        return count; // Return total lights activated
    }
}
