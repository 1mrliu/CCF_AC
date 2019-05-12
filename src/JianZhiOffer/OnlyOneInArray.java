package JianZhiOffer;

/**
 * 数组中出现一次的数
 * 使用异或操作 0和任意的数异或都是数值本身，相同的数异或为0
 */

public class OnlyOneInArray {
    public static void main(String[] args) {
        //int[] arr = {1, 2, 2, 5, 4, 4, 4, 4};
        int[] arr={3,3,7,2,4,2,5,5,4,5,5};
        int res = 0;//初始值
        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];
        }
        System.out.print(res);
    }
}
