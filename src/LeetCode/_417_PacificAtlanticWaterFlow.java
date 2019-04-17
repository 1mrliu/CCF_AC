package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 *
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 *
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 *
 * Note:
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 * Example:
 *
 * Given the following 5x5 matrix:
 *
 *   Pacific ~   ~   ~   ~   ~
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * Atlantic
 *
 * Return:
 *
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */

public class _417_PacificAtlanticWaterFlow {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0)return null;
        //行 列
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        //  | =	 按位或赋值操作符	C | = 2等价于C = C | 2
        for (int x = 0; x < m; x++) {
            dp[0][x] |= 1;
            dp[n-1][x] |= 2;
        }

        for (int y = 0; y < n; y++) {
            dp[y][0] |= 1;
            dp[y][m-1] |= 2;
        }

        int[] dirs = {0,-1,0,1,0};

        while (true){
            boolean changed = false;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    for (int d = 0; d < 4; d++) {
                        int tx = x + dirs[d];
                        int ty = y + dirs[d+1];
                        if (tx < 0 || ty < 0 || tx == m|| ty == n ||matrix[y][x] < matrix[ty][tx] || (dp[y][x] | dp[ty][tx]) == dp[y][x])
                            continue;
                        dp[y][x] |= dp[ty][tx];
                        changed = true;
                    }
                    if (!changed) break;
                }
                List<int[]> ans = new ArrayList<>();
                for (int i = 0; i <n ; i++)
                    for (int j = 0; j <m ; j++) {
                        if (dp[i][j] == 3)
                            ans.add(new int[]{i,j});
                    }
            return ans;
            }
        }
    }
}
