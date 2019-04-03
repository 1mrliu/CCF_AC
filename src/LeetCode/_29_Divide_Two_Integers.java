package LeetCode;

import java.util.Scanner;

/**
 * Created by liudong on 2018/12/5.
 * Given two integers dividend and divisor, divide two integers without using multiplication,
 * division and mod operator.
 * Return the quotient after dividing dividend by divisor.
 * The integer division should truncate toward zero.
 * Example 1:
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Example 2:
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Note:
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer
 * range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division
 * result overflows.
 */
public class _29_Divide_Two_Integers {
    public int divide(int dividend, int divisor) {
        int result = 0;


        return result;
    }

    public static void main(String[] args){
        _29_Divide_Two_Integers d = new _29_Divide_Two_Integers();
        Scanner sc =new Scanner(System.in);
        int dividend = sc.nextInt();
        int divisor = sc.nextInt();
        int result = d.divide(dividend,divisor);
        System.out.print(result);
    }

}
