/*
Problem Description
You are in an infinite 2D grid where you can move in any of the 8 directions :
 (x,y) to
    (x+1, y),
    (x - 1, y),
    (x, y+1),
    (x, y-1),
    (x-1, y-1),
    (x+1,y+1),
    (x-1,y+1),
    (x+1,y-1)
You are given a sequence of points and the order in which you need to cover the points.
Give the minimum number of steps in which you can achieve it. You start from the first point.

Problem Constraints
1 <= |A| <= 106
- 2 * 103 <= Ai, Bi <= 2 * 103
|A| == |B|

Input Format
Given two integer arrays A and B, where A[i] is x coordinate and B[i] is y coordinate of ith point respectively.

Output Format
Return an Integer, i.e minimum number of steps.


Examples

Input 1:
 A = [0, 1, 1]
 B = [0, 1, 2]

Output 1:
2

Explanation 1:
Given three points are: (0, 0), (1, 1) and (1, 2).
It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).

The shortest distance you need to travel from one point to another by taking any of the 8 neighboring points
of each point is called chessboard distance.
ChessBoardDistance( p1, p2 ) = max( |p1.x-p2.x|, |p1.y-p2.y| ) where p1, p2 are 2d points.
 */
package Array;

public class MinStepsInInfiniteGrid {
    public int coverPoints(int[] A, int[] B) {
        int steps = 0;

        // Loop through all pairs of consecutive points
        for (int i = 1; i < A.length; i++) {
            // Calculate the difference in x and y coordinates between two points
            int dx = Math.abs(A[i] - A[i - 1]);
            int dy = Math.abs(B[i] - B[i - 1]);

            // The minimum number of steps to go from one point to the next
            // is the maximum of dx and dy (diagonal movement allowed)
            // This is known as "Chessboard distance" or King's move distance
            steps += Math.max(dx, dy);
        }

        return steps; // Total steps needed to cover all points in order
    }

}
