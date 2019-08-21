package JianZhiOffer;

/**
 * 机器人运动范围
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */
public class _66_RobotYunDongArea {
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        return countingSteps(threshold,rows,cols,0,0,visited);

    }

    private int countingSteps(int threshold, int rows, int cols, int r, int c, boolean[][] visited) {
        if (r < 0 || r>= rows || c<0 || c>=cols||visited[r][c] || bitSum(r)+bitSum(c) > threshold) return 0;

        visited[r][c] = true;

        return countingSteps(threshold,rows,cols,r - 1,c,visited)
                + countingSteps(threshold,rows,cols,r,c - 1,visited)
                + countingSteps(threshold,rows,cols,r + 1,c,visited)
                + countingSteps(threshold,rows,cols,r,c + 1,visited)
                + 1;
    }

    private int bitSum(int r) {
        int count = 0;
        while (r!=0){
            count += r%10;
            r/= 10;
        }
        return count;
    }
}
