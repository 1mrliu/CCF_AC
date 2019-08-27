package CCF_201512;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by liudong on 2018/12/16.
 * 问题描述
 　　用 ASCII 字符来画图是一件有趣的事情，并形成了一门被称为 ASCII Art 的艺术。例如，下图是用 ASCII 字符画出来的 CSPRO 字样。
 　　.._._.._.._…_..
 　　././.||...|..../._..
 　　|.|…___.|.|).|.|).|.|.|.|
 　　|.|.).|.._/|...<|.|_|.|
 　　.____|_/||…||._\/.
 　　本题要求编程实现一个用 ASCII 字符来画图的程序，支持以下两种操作：
 　　Ÿ 画线：给出两个端点的坐标，画一条连接这两个端点的线段。简便起见题目保证要画的每条线段都是水平或者竖直的。水平线段用字符 - 来画，
     竖直线段用字符 | 来画。如果一条水平线段和一条竖直线段在某个位置相交，则相交位置用字符 + 代替。
 　　Ÿ 填充：给出填充的起始位置坐标和需要填充的字符，从起始位置开始，用该字符填充相邻位置，直到遇到画布边缘或已经画好的线段。注意这里的
     相邻位置只需要考虑上下左右 4 个方向，如下图所示，字符 @ 只和 4 个字符 * 相邻。
 　　.*.
 　　@
 　　.*.
 输入格式
 　　第1行有三个整数m, n和q。m和n分别表示画布的宽度和高度，以字符为单位。q表示画图操作的个数。
 　　第2行至第q + 1行，每行是以下两种形式之一：
 　　Ÿ 0 x1 y1 x2 y2：表示画线段的操作，(x1, y1)和(x2, y2)分别是线段的两端，满足要么x1 = x2 且y1 ≠ y2，要么 y1 = y2 且 x1 ≠ x2。
 　　Ÿ 1 x y c：表示填充操作，(x, y)是起始位置，保证不会落在任何已有的线段上；c 为填充字符，是大小写字母。
 　　画布的左下角是坐标为 (0, 0) 的位置，向右为x坐标增大的方向，向上为y坐标增大的方向。这q个操作按照数据给出的顺序依次执行。画布最初时
     所有位置都是字符 .（小数点）。
 输出格式
 　　输出有n行，每行m个字符，表示依次执行这q个操作后得到的画图结果。
 样例输入
 4 2 3
 1 0 0 B
 0 1 0 2 0
 1 0 0 A
 样例输出
 AAAA
 A–A
 样例输入
 16 13 9
 0 3 1 12 1
 0 12 1 12 3
 0 12 3 6 3
 0 6 3 6 9
 0 6 9 12 9
 0 12 9 12 11
 0 12 11 3 11
 0 3 11 3 1
 1 4 2 C
 样例输出
 …………….
 …+——–+…
 …|CCCCCCCC|…
 …|CC+—–+…
 …|CC|………
 …|CC|………
 …|CC|………
 …|CC|………
 …|CC|………
 …|CC+—–+…
 …|CCCCCCCC|…
 …+——–+…
 …………….
 评测用例规模与约定
 　　所有的评测用例满足：2 ≤ m, n ≤ 100，0 ≤ q ≤ 100，0 ≤ x < m（x表示输入数据中所有位置的x坐标），0 ≤ y < n（y表示输入数据中所有位置的y坐标）。
 */
public class CCF_3_HuaTu {
    private static int[][] go = {{1,0},{-1,0},{0,1},{0,-1}};
    private static int[][] mark = new int[101][101];
    private static char[][] chars = new char[101][101];

    public static int m,n;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = '.';
            }
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int op = sc.nextInt();
            if (op == 1) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                char ch = sc.next().charAt(0);
                fill(x,y,ch);
            }else{
                int x1 = sc.nextInt();
                int y1 = sc.nextInt();
                int x2 = sc.nextInt();
                int y2 = sc.nextInt();
                draw(x1,y1,x2,y2);
            }
        }
        for (int j = n-1; j >= 0 ; j--) {
            for (int i = 0; i < m; i++) {
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }

    private static void draw(int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            if (y1 > y2) {
                int t = y1;
                y1 = y2;
                y2 = t;
            }
            for (int i = y1; i <= y2 ; i++) {
                if (mark[x1][i] == 0) {
                    chars[x1][i] = '|';
                    mark[x1][i] = 1;
                }else if (mark[x1][i] == 2) {
                        chars[x1][i] = '+';
                        mark[x1][i] = 3;
                }
            }
        }else{
            if (x1 > x2) {
                int t = x1;
                x1 = x2;
                x2 = t;
            }
            for (int i = x1; i <= x2; i++) {
                if (mark[i][y1] == 0) {
                    chars[i][y1] = '-';
                    mark[i][y1] = 2;
                }else if (mark[i][y1] == 1) {
                    chars[i][y1] = '+';
                    mark[i][y1] = 3;
                }
            }
        }
    }

    private static Queue<Integer[]> queue = new LinkedList<Integer[]>();

    private static void fill(int x, int y, char ch) {
          boolean markb[][] = new boolean[m][n];
          if (mark[x][y] == 0 && markb[x][y] == false) {
              chars[x][y] = ch;
              markb[x][y] = true;
              for (int i = 0; i < 4; i++) {
                  int nx = x + go[i][0];
                  int ny = y + go[i][1];
                  if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                      continue;
                  }
                  if (mark[nx][ny] != 0) {
                      continue;
                  }
                  queue.add(new Integer[]{nx,ny});
              }
        }
        while(!queue.isEmpty()){
            Integer[] node = queue.poll();
            int x1 = node[0];
            int y1 = node[1];
            if (mark[x1][y1] == 0 && markb[x1][y1] == false) {
                chars[x1][y1] = ch;
                markb[x1][y1] = true;
                for (int i = 0; i < 4; i++) {
                    int nx = x1 + go[i][0];
                    int ny = y1 + go[i][1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >=n) {
                        continue;
                    }
                    if (mark[nx][ny] != 0) {
                        continue;
                    }
                    queue.add(new Integer[]{nx,ny});
                }
            }
        }
    }

}
