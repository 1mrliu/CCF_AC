package LeetCode;

/**
 * Created by liudong on 2019/3/21.
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 The robot can only move either down or right at any point in time. The robot is trying to reach the
 bottom-right corner of the grid (marked 'Finish' in the diagram below).
 Now consider if some obstacles are added to the grids. How many unique paths would there be?
 An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 Note: m and n will be at most 100.
 Example 1:
 Input:
 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 Output: 2
 Explanation:
 There is one obstacle in the middle of the 3x3 grid above.
 There are two ways to reach the bottom-right corner:
 1. Right -> Right -> Down -> Down
 2. Down -> Down -> Right -> Right

 time o(M*N)
 space o(1)
 */
public class DP_UniquePathsII_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // row
        int R = obstacleGrid.length;
        //column
        int C = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1){
            return 0;
        }

        // else
        obstacleGrid[0][0] = 1;
        // filling the value of the first column
        for (int i = 1; i < R; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0]==1) ? 1:0;
        }
        // filling the value of the row
        for (int i = 1; i < C; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i-1] == 1) ? 1:0;
        }
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }else{
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[R-1][C-1];
    }
    public static void main(String[] args){
        DP_UniquePathsII_63 ss = new DP_UniquePathsII_63();
        int[][] matrix = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.print(ss.uniquePathsWithObstacles(matrix));
    }
}
