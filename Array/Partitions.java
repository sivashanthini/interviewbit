/*
Problem Description
You are given a 1D integer array B containing A integers.
Count the number of ways to split all the elements of the array into 3 contiguous parts so that the sum of elements in each part is the same.
Such that : sum(B[1],..B[i]) = sum(B[i+1],...B[j]) = sum(B[j+1],...B[n])

Problem Constraints
1 <= A <= 105
-109 <= B[i] <= 109

Input Format
First argument is an integer A.
Second argument is an 1D integer array B of size A.

Output Format
Return a single integer denoting the number of ways to split the array B into three parts with the same sum.


Examples

Input 1:
 A = 5
 B = [1, 2, 3, 0, 3]


Output 1:
 2

Explanation 1:
 There are no 2 ways to make partitions -
 1. (1,2)+(3)+(0,3).
 2. (1,2)+(3,0)+(3).

Input 2:
 A = 4
 B = [0, 1, -1, 0]

Output 2:
 1

Explanation 2:
 There is only 1 way to make partition -
 1. (0)+(-1,1)+(0).

We have to form three partitions in an array: (partition one)(partition two)(partition three)
We know that sum of each partition will be totalSum/3. If totalSum is not divisible by 3, simply return 0.
We can find ALL END INDICES of the FIRST PARTITION by using totalSum/3 value, by iterating from left to right.
We can find ALL START INDICES of the THIRD PARTITION by using totalSum/3 value, by iterating from right to left.
Now, the only thing left is to check if the PARTITION TWO which can be formed using any of the combination from PARTITION ONE end index and PARTITION THREE start index is valid (its sum should also be totalSum/3).
For every possible end index of partition one, say i, we will initialize the start of second partition which will be i+1.
For every possible start index of partition three, say j, we will initialize the end of second partition which will be j-1.
(partition one)(partition two)(partition three) ->(0, i)(i+1, j-1)(j,n-1)
Now the only part left is to verify if the PARTITION TWO from i+1 to j-1 has the sum as totalSum/3
While calculating the end index of first partition and start index of the third partition, we have already made sure that their sum should be totalSum/3 each.
We have also verified at the start that the total sum is a multiple of 3. So, the left partition, which is the second partition has to be of sum totalSum/3.
We can just check if there is at least 1 element which can be used to form the second partition. In that case, we can increase the count by 1.
 */
package Array;

import java.util.ArrayList;
import java.util.List;

public class Partitions {
    public int solve(int A, int[] B) {
        int totalSum = 0, count = 0;

        // Step 1: Compute the total sum of the array
        for (int num : B) {
            totalSum += num;
        }

        // Step 2: If the total sum is not divisible by 3, it's impossible to split into 3 parts with equal sum
        if (totalSum % 3 != 0) return count;

        int avgSum = totalSum / 3; // Each part must sum to avgSum
        int temp = 0;

        // List to store indices where the sum of elements from the start equals avgSum
        List<Integer> endIndexFirstPartition = new ArrayList<>();
        for (int i = 0; i <= A - 3; i++) {
            temp += B[i];
            if (temp == avgSum) {
                endIndexFirstPartition.add(i); // end index of first partition
            }
        }

        // Reset temp for scanning from the end
        temp = 0;

        // List to store indices where the sum of elements from the end equals avgSum
        List<Integer> startIndexThirdPartition = new ArrayList<>();
        for (int i = A - 1; i >= 2; i--) {
            temp += B[i];
            if (temp == avgSum) {
                startIndexThirdPartition.add(i); // start index of third partition
            }
        }

        // Step 3: Count valid (i, j) pairs where:
        // i is end index of the first partition
        // j is start index of the third partition
        // and the middle partition (between i and j) has at least one element
        for (int i = 0; i < endIndexFirstPartition.size(); i++) {
            for (int j = 0; j < startIndexThirdPartition.size(); j++) {
                if (startIndexThirdPartition.get(j) - endIndexFirstPartition.get(i) >= 2) {
                    count++;
                }
            }
        }

        return count;
    }
}

