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
 * 先不断通过移位操作找到divisor最接近dividend的倍数，如被除数是100，除数是3的话，这个倍数就是32。
 *
 * 然后用100减去3的32倍，这里的32倍是通过左移产生，并没有用到乘法。
 *
 * 这时，再用一个循环找到3的多少倍最接近于100和它32倍的差，即找到最接近于4的倍数，通过不断试探16倍，8倍，4倍。。。（通过右移），结果是1倍，为3。
 *
 * 再重复做差的动作，去找最接近1的3的倍数，当然是0倍。最后当做差的值小于3的一倍时，循环退出。
 * 为了解决溢出的问题，参考了http://www.cnblogs.com/ganganloveu/p/4174062.html的方法，用long来进行运算，
 * 最后判定不溢出时再转换为int
 */
public class _29_Divide_Two_Integers {
    public int divide(int dividend, int divisor) {
        long m = dividend;
        long n = divisor;
        long absn = Math.abs(n);
        if (divisor == 0){
            return Integer.MAX_VALUE;
        }
        if (dividend == 0)return 0;
        boolean flag1 = dividend < 0 ? true:false;
        boolean flag2 = divisor < 0 ? true:false;
        m = Math.abs(m);
        n = Math.abs(n);
        if (m<n)
            return 0;

        long ct = 1;
        long tempresult = 0;
        while ((n<<1)<= m){
            n = n<<1;
            ct = ct<<1;
        }
        while (true){
            tempresult = tempresult + ct;

            m = m - n;
            n = n >> 1;
            ct = ct >> 1;

            while(m<n){
                n = n>> 1;
                ct =ct >>1;
            }
            if (n < absn)break;

        }
        if((flag1==true&&flag2==false) || (flag1==false&&flag2==true))
            return -(int)tempresult;
        if(tempresult>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int)tempresult;
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
