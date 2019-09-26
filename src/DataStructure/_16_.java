package DataStructure;

/**
 * 岛的问题
 * 矩阵中1连接在一块称为一个岛
 * 返回岛的数量
 */
public class _16_ {
    // 进行感染周围的数据
    private void infect(int[][] m,int i, int j,int N,int M){
        if (i < 0 || i>=N || j <0 || j>=M||m[i][j] !=1) return;
        m[i][j] = 2;
        infect(m,i+1,j,N,M);//下
        infect(m,i-1,j,N,M);//上
        infect(m,i,j+1,N,M);//右
        infect(m,i,j-1,N,M);//左
    }

    // 找出岛屿数目
    private int countIsland(int[][] m){
        if (m == null || m[0] == null) return 0;

        int N = m.length;
        int M = m[0].length;
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (m[i][j] == 1){
                    res++;
                    infect(m,i,j,N,M);
                }
            }
        }
        return res;
    }
}
