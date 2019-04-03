package LeetCode;

/**
 * Created by liudong on 2019/1/13.
 * Implement pow(x, n), which calculates x raised to the power n (xn).

 Example 1:

 Input: 2.00000, 10
 Output: 1024.00000
 Example 2:

 Input: 2.10000, 3
 Output: 9.26100
 Example 3:

 Input: 2.00000, -2
 Output: 0.25000
 Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */
public class _50_Pow_x_y {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
            if (-n == Integer.MIN_VALUE) {
                return x * myPow(x, (n - 1));
            }
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    public static void main(String[] args){
        _50_Pow_x_y p = new _50_Pow_x_y();
        double sum = p.myPow(2.00000, 10);
        System.out.print(sum);

    }
}

