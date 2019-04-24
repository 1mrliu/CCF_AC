package JianZhiOffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */

public class _8_TiaoTaiJie {
    public int JumpFloor(int target) {
        if (target == 1 || target ==2) return target;
       int[] dp = new int[target];
       dp[0] = 1;
       dp[1] = 2;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[target-1];
    }
}
