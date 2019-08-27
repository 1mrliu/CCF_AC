package CCF_201612;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 问题描述
 　　在一个整数序列a1, a2, …, an中，如果存在某个数，大于它的整数数量等于小于它的整数数量，则称其为中间数。
 在一个序列中，可能存在多个下标不相同的中间数，这些中间数的值是相同的。
 　　给定一个整数序列，请找出这个整数序列的中间数的值。
 输入格式
 　　输入的第一行包含了一个整数n，表示整数序列中数的个数。
 　　第二行包含n个正整数，依次表示a1, a2, …, an。
 输出格式
 　　如果约定序列的中间数存在，则输出中间数的值，否则输出-1表示不存在中间数。
 样例输入
 6
 2 6 5 6 3 5
 样例输出
 5
 样例说明
 　　比5小的数有2个，比5大的数也有2个。
 样例输入
 4
 3 4 6 7
 样例输出
 -1
 样例说明
 　　在序列中的4个数都不满足中间数的定义。
 样例输入
 5
 3 4 6 6 7
 样例输出
 -1
 样例说明
 　　在序列中的5个数都不满足中间数的定义。
 评测用例规模与约定
 　　对于所有评测用例，1 ≤ n ≤ 1000，1 ≤ ai ≤ 1000。
 */

public class CCF_1_ZhongWeiShu {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n ; i++) {
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);
        int mid = n/2;
        int left = mid;
        int right = n - mid -1;
            for (int i = mid-1; i >= 0 ; i--) {
                if (num[i]  == num[mid]) {
                    left--;
                }else {
                    break;
                }
            }
            for (int i = mid+1; i< n ; i++) {
                if (num[i] == num[mid]) {
                    right--;
                }else{
                    break;
                }
            }
            if (right == left) {
                System.out.print(num[mid]);
            }else{
                System.out.print(-1);
            }
        }

    }




