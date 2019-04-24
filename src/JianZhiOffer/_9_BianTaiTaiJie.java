package JianZhiOffer;

/**
 *变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * Fib(n) =  Fib(0)+Fib(1)+Fib(2)+.......+ Fib(n-2) + Fib(n-1)
 * 因此，有 Fib(n-1)=Fib(0)+Fib(1)+Fib(2)+.......+Fib(n-2)
 * 两式相减得：Fib(n)-Fib(n-1) = Fib(n-1)         =====》  Fib(n) = 2*Fib(n-1)     n >= 3
 * 这就是我们需要的递推公式：Fib(n) = 2*Fib(n-1)     n >= 3
 */
public class _9_BianTaiTaiJie {
    public int JumpFloorII(int target) {
        if (target == 1 || target ==2) return target;
        int[] array = new int[target];
        array[0] = 1;
        array[1] = 2;
        for (int i = 2; i < array.length; i++) {
            array[i] = 2 * array[i-1];
        }
        return array[target-1];

    }
}
