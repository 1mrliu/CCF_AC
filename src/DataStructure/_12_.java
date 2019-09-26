package DataStructure;

/**
 * 矩阵的最小路径和
 * 给定一个矩阵，从左上角开始，每次只能向右或者向下走最终到达右下角的位置，
 * 路径上所有数字的累加和就是路径，返回所有路径中最小的路径和
 */
public class _12_ {
    private static int minPathSum(int[][] m){
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) return 0;
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for (int i = 1; i < row ; i++)
        {
           dp[i][0] = dp[i-1][0] + m[i][0];
        }
        for (int i = 1; i < col; i++)
        {
           dp[0][i] = dp[0][i-1] + m[0][i];
        }
        for (int i = 1; i < row; i++)
        {
            for (int j = 1; j < col; j++)
            {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + m[i][j];

            }

        }

        return dp[row-1][col-1];
    }
}
