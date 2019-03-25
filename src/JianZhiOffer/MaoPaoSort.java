package JianZhiOffer;

/**
 * Created by liudong on 2019/3/25.
 *
 * 冒泡排序:
 *
 * 稳定排序
 * 最差时间复杂度 O(n^2)  最好的 O(n)
 * 空间复杂度O(1)
 */
public class MaoPaoSort {
    public int[] sort(int[] arr){
         int len = arr.length;
         for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
