package DataStructure;

/**
 * 换钱最少的货币数
 * 给定一个数组，数组中所有的值都为正值且不重复。每个值代表一种面值的货币，
 * 每种面值的货币可以使用任意值，再给定一个整数aim，，代表要找的钱数，求组成aim最少的货币数
 */
public class _13_ {

    // 暴力递归解法
    private int minCoins1(int[] arr,int aim){

        if (arr == null || arr.length == 0 || aim < 0) return -1;

        return process(arr, 0, aim);
    }

    private int process(int[] arr, int i, int rest) {
        // 如果没有面值能考虑了
        // 如果剩余的钱是0，则返回0张
        // 如果此时剩余的钱不是0，返回-1
        if (i == arr.length) return rest == 0 ? 0 : -1;

        // 最小张数，初始值为-1，因为还没找到有效解
        int res = -1;
        // 依次尝试使用当前的货币 0 1 2 。。。 k张，但是不超过rest
        for (int k = 0; k * arr[i] <= rest ; k++)
        {
            // 使用k张arr[i] 剩下的钱为rest-k*arr[i]
            int next = process(arr, i+1,rest-k*arr[i]);
            // 说明这个后续过程有效
            if (next != -1)
                res = res == -1 ? next + k:Math.min(res, next+k);
        }

        return res;
    }
}
