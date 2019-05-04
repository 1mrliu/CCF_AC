package JianZhiOffer;

import java.util.ArrayList;

/**
 *输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 *  1  2  3  4
 *  5  6  7  8
 *  9  10 11 12
 *  13 14 15 16
 *  则依次打印出数字
 *  1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class _19_ShunShiZhenMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;// 行的长度 列的长度
        if (n == 0) return result;
        if (m == 0) return result;
        int cnt = n * m;
        int rEdge = m - 1, dEdge = n - 1, lEdge = 0, uEdge = 0;
        for (int x = 0, y = 0; cnt > 0; cnt--) {
            result.add(matrix[x][y]);
            // right
            if (x == uEdge) {
                if (y<rEdge){
                   y++;
                } else if (y == rEdge) {
                x++;
            }
            continue;
            }
            //down
            if (y == rEdge){
                if (x < dEdge){
                    x++;
                }else if(x == dEdge){
                  y--;
                }
                continue;
            }
            // left
            if (x == dEdge){
                if (y > lEdge){
                    y--;
                }else if (y == lEdge){
                    x--;
                }
                continue;
            }
            // up
            if (y == lEdge){
                if (x > uEdge+1){
                   x--;
                }else if(x==uEdge+1){
                    y++;
                    lEdge++;
                    uEdge++;
                    rEdge--;
                    dEdge--;
                }
                continue;

            }
        }
        return result;

    }
}
