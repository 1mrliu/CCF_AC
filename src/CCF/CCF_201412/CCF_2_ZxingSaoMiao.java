package CCF_201412;

import java.util.Scanner;

/**
 * Created by liudong on 2018/11/11.
 * 在图像编码的算法中，需要将一个给定的方形矩阵进行Z字形扫描(Zigzag Scan)。给定一个n×n的矩阵，Z字形扫描的过程如下图所示：

 　　对于下面的4×4的矩阵，
 　　1 5 3 9
 　　3 7 5 6
 　　9 4 6 4
 　　7 3 1 3
 　　对其进行Z字形扫描后得到长度为16的序列：
 　　1 5 3 9 7 3 9 5 4 7 3 6 6 4 1 3
 　　请实现一个Z字形扫描的程序，给定一个n×n的矩阵，输出对这个矩阵进行Z字形扫描的结果。
 输入格式
 　　输入的第一行包含一个整数n，表示矩阵的大小。
 　　输入的第二行到第n+1行每行包含n个正整数，由空格分隔，表示给定的矩阵。
 输出格式
 　　输出一行，包含n×n个整数，由空格分隔，表示输入的矩阵经过Z字形扫描后的结果。
 样例输入
 4
 1 5 3 9
 3 7 5 6
 9 4 6 4
 7 3 1 3
 样例输出
 1 5 3 9 7 3 9 5 4 7 3 6 6 4 1 3
 评测用例规模与约定
 　　1≤n≤500，矩阵元素为不超过1000的正整数。
 */
public class CCF_2_ZxingSaoMiao {
    public static final int RIGHT = 1;
    public static final int DOWN = 2;
    public static final int RIGHTUP = 3;
    public static final int LEFTDOWN = 4;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int row = 0;
        int col = 0;
        int direction = RIGHT;
        while(row != n - 1 || col != n-1){
            System.out.print(arr[row][col]+" ");
            switch (direction){
                case RIGHT:
                    col++;
                    if (row == 0){
                        direction = LEFTDOWN;
                    }else{
                        direction = RIGHTUP;
                    }
                    break;

                case RIGHTUP:
                    row--;
                    col++;
                    if (row == 0 && col != n-1) {
                        direction = RIGHT;
                    }else if (col == n - 1) {
                        direction = DOWN;
                    }else{
                        direction = RIGHTUP;
                    }
                    break;
                case DOWN:
                    row++;
                    if (col == 0) {
                        direction = RIGHTUP;
                    }else {
                        direction = LEFTDOWN;
                    }
                    break;
                case LEFTDOWN:
                    row++;
                    col--;
                    if (col == 0 && row != n-1) {
                        direction = DOWN;
                    }else if (row == n-1) {
                        direction = RIGHT;
                    }else {
                        direction = LEFTDOWN;
                    }
                    break;
            }
        }
        System.out.print(arr[n-1][n-1]);
    }

}
