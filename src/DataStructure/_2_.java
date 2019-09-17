package DataStructure;
// 子数组的最大累加和
public class _2_ {
    public int maxSum(int[] arr){
        if (arr == null || arr.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            max = Math.max(cur, max);
            cur = cur < 0 ? 0:cur;
        }
        return max;
    }

}
