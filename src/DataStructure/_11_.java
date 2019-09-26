package DataStructure;

/**
 * 数组中最长的递增子序列
 */
public class _11_ {
    private static int[] getDp(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            dp[i] = 1;
            for (int j = 0; j < i; j++)
            {
                if(arr[i] > arr[j]) dp[i] = Math.max(dp[i],dp[j]+1);
            }
        }

        return dp;
    }

    private static int[] generateLis(int[] arr, int[] dp){
        int len = 0;
        int index = 0;
        for (int i = 0; i < dp.length; i++)
        {
            if (dp[i] > len)
            {
                len = dp[i];
                index = i;
            }
        }

        // 存放最长子序列的数组
        int[] lis = new int[len];

        lis[--len] = arr[index];
        for (int i = index; i >= 0 ; i--)
        {
            if (arr[i] < arr[index] && dp[i] == dp[index] - 1)
            {
                lis[--len] = arr[i];
                index = i;
            }
        }

        return lis;
    }


    public static void main(String[] args){
        int[] arr = {2,1,5,3,6,4,8,9,7};
        int[] dp = getDp(arr);
        int[] arra = generateLis(arr,dp);
        for(Integer i:arra)
            System.out.print(i);
    }
}
