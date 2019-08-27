package CCF_201512;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by liudong on 2018/11/8.
 *问题描述
 　　给定一个十进制整数n，输出n的各位数字之和。
 输入格式
 　　输入一个整数n。
 输出格式
 　　输出一个整数，表示答案。
 样例输入
 20151220
 样例输出
 13
 样例说明
 　　20151220的各位数字之和为2+0+1+5+1+2+2+0=13。
 评测用例规模与约定
 　　所有评测用例满足：0 ≤ n ≤ 1000000000。
 *
 */
public class CCF_1_ShuWeiZhiHe {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String s = Integer.toString(n);
        char[] nums = s.toCharArray();
        List<Integer> list = new ArrayList<Integer>();

        int result = 0;
        for (char chars:nums) {
            list.add(Character.getNumericValue(chars));
        }
        for (int i = 0; i < list.size() ; i++) {
            result += list.get(i);

        }
        System.out.print(result);
    }
}
