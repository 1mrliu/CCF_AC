package LeetCode;

/**
 * Created by liudong on 2019/4/15.
 *Example 1:

 Input: stones = [3,2,4,1], K = 2
 Output: 20
 Explanation:
 We start with [3, 2, 4, 1].
 We merge [3, 2] for a cost of 5, and we are left with [5, 4, 1].
 We merge [4, 1] for a cost of 5, and we are left with [5, 5].
 We merge [5, 5] for a cost of 10, and we are left with [10].
 The total cost was 20, and this is the minimum possible.
 */
public class _1000_MinimumCostToMergeStones {
    public int mergeStones(int[] stones, int K) {

        int n = stones.length;

        if ((n-1)%(K-1) > 0) return -1;

        int[] sums = new int[n+1];

        for (int i = 0; i < stones.length; i++) {
            sums[i+1] = sums[i] + stones[i];
        }


        // dp[i][j] := min cost to merge subarray A[i] ~ A[j] into (j-i)%(K-1) + 1 piles
        int[][] dp = new int[n][n];

        // subproblem of length
        for (int l = K; l <= n; l++)
            // start
            for (int i = 0; i+l <= n ; i++) {
               int j = i + l - 1;
               dp[i][j] = Integer.MAX_VALUE;
               // split point
                for (int m = i; m < j; m += K-1) {
                    dp[i][j] = Math.min(dp[i][j],dp[i][m] + dp[m+1][j]);
                }
                //  If the current length can be merged into 1 pile
                //  The cost is independent of the merge orders.
                if ((j-i)%(K-1) == 0) {
                    dp[i][j] += sums[j+1] - sums[i] ;
                }

            }
            return dp[0][n-1];
    }

    public static void main(String[] args){
        _1000_MinimumCostToMergeStones ss = new _1000_MinimumCostToMergeStones();
        int[] stones = {3, 2, 4, 1};
        int k = 2;
        int n = ss.mergeStones(stones,k);
        System.out.print(n);
    }

}
