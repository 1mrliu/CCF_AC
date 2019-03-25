package LeetCode;

/**
 * Created by liudong on 2019/3/21.
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.

 Example:

 Input:
 [
 [1,3,1],
 [1,5,1],
 [4,2,1]
 ]
 Output: 7
 Explanation: Because the path 1→3→1→1→1 minimizes the sum.

 */
public class DP_MinimumPathSum_64 {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 && j!= 0) {
                    grid[i][j] = grid[i][j] + grid[i][j-1];
                }else if(j == 0 && i!= 0){
                    grid[i][j] = grid[i][j] + grid[i-1][j];
                }else if (i == 0 && j == 0) {
                    grid[i][j] = grid[i][j];
                }else{
                    grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1]) + grid[i][j];
                }

            }
        }
        return grid[row-1][column-1];

    }

    public static void main(String[] args){
        DP_MinimumPathSum_64 ss =new DP_MinimumPathSum_64();
        int[][] matrix = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.print(ss.minPathSum(matrix));
    }
}
