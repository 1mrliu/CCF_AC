package LeetCode;

/**
 * Created by liudong on 2019/3/21.
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 The robot can only move either down or right at any point in time. The robot is trying to
 reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?
 Note: m and n will be at most 100.

 Example 1:

 Input: m = 3, n = 2
 Output: 3
 Explanation:
 From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 1. Right -> Right -> Down
 2. Right -> Down -> Right
 3. Down -> Right -> Right
 思路：
 left和down的位置进行处理，每个点的值是上一步的上边的值和左边的值的累积和
 dp[i][j] = dp[i-1][j] + dp[i][j-1]

 */
public class DP_UniquePaths_62 {
    public int uniquePaths(int m, int n) {
        Integer[][] map = new Integer[m][n];
        for (int i = 0; i < m; i++) {
            map[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            map[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[i][j] = map[i-1][j] + map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }
    public static void main(String[] args){
        DP_UniquePaths_62 ss = new DP_UniquePaths_62();
        int m  =3, n=2;
        System.out.print(ss.uniquePaths(m,n));
    }
}
