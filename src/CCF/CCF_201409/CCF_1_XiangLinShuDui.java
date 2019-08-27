package CCF_201409;

import java.util.Scanner;

/**
 * Created by liudong on 2018/11/14.
 * 问题描述
 　　给定n个不同的整数，问这些数中有多少对整数，它们的值正好相差1。
 输入格式
 　　输入的第一行包含一个整数n，表示给定整数的个数。
 　　第二行包含所给定的n个整数。
 输出格式
 　　输出一个整数，表示值正好相差1的数对的个数。
 样例输入
 6
 10 2 6 3 7 8
 样例输出
 3
 样例说明
 　　值正好相差1的数对包括(2, 3), (6, 7), (7, 8)。
 评测用例规模与约定
 　　1<=n<=1000，给定的整数为不超过10000的非负整数。
 */
public class CCF_1_XiangLinShuDui {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int result = 0;
        for (int i = 0; i < n-1 ; i++) {
            for (int j = i+1; j < n; j++) {
                if (Math.abs(arr[i]-arr[j])==1) {
                    result++;
                }
            }
        }
        System.out.print(result);
    }

}
