package JianZhiOffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class _42_FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        //数组为递增排序的 可以设置两个指针

        ArrayList<Integer> list = new ArrayList<Integer>();
        if (array == null || array.length < 2) {
            return list;
        }
        int low = 0;
        int high = array.length-1;
        while (low < high){
            if (array[low] + array[high] == sum){
                list.add(array[low]);
                list.add(array[high]);
                break;
            }else if (array[low] + array[high] > sum){
                high--;
            }else {
                low++;
            }
        }

       return list;

    }
}
