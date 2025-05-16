/*
Problem Description
Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).
The digits are stored such that the most significant digit is at the head of the list.
NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example:
for this problem, following are some good questions to ask :
    Q : Can the input have 0's before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
    A : For the purpose of this question, YES
    Q : Can the output have 0's before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
    A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.

Problem Constraints
1 <= |A| <= 106
0 <= Ai <= 9


Input Format
First argument is an array of digits.

Output Format
Return the array of digits after adding one.

Examples

Input 1:
[1, 2, 3]

Output 1:
[1, 2, 4]

Explanation 1:
Given vector is [1, 2, 3].
The returned vector should be [1, 2, 4] as 123 + 1 = 124.
 */
package Array;

public class AddOneToNumber {
    public int[] plusOne(int[] A) {
        // n is the length of the input array, rem is the carry (starting with 1 for +1), count for leading zeros
        int n = A.length, rem = 1, count = 0;

        // Create a result array with an extra space in case there's an overflow (e.g., 999 + 1 = 1000)
        int[] result = new int[n+1];

        // Traverse the input array from the end (least significant digit)
        for (int i = n-1; i >= 0; i--) {
            int sum = A[i] + rem; // Add the current digit and the carry
            if (sum > 9) {
                result[n--] = 0;  // Set current digit to 0 if sum is 10, and keep carry as 1
                rem = 1;
            } else {
                result[n--] = sum; // No carry over needed, set digit and reset carry
                rem = 0;
            }
        }

        // If there's still a carry after processing all digits, add it to the front
        if (rem == 1) result[n] = 1;

        // If the first element in the result is 0, it means there was no carry into the new digit
        if (result[0] == 0) {
            // Count leading zeros
            for (int i = 0; i < result.length; i++) {
                if (result[i] == 0) count++;
                else break;
            }
            // Create a new array excluding the leading zeros
            int len = result.length - count;
            int[] finResult = new int[len];
            for (int i = 0; i < len; i++) {
                finResult[i] = result[count++];
            }
            return finResult;
        }

        // If the first digit is not 0, return the full result
        return result;
    }

}
