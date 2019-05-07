package JianZhiOffer;

import java.util.HashMap;

/**
 * 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class _28_ArrayChuXIanYiBanDeNumber {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 0) return 0;

        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0){
                result = array[i];
                times = 1;
            }else if (array[i] == result){
                times++;
            }else{
                times--;
            }
        }
        //要找的数字是最后一次把次数设置为1时对应的数字 result

        int count =0;
        for (int i = 0; i < array.length; i++) {
            if (result == array[i]) count++;
        }

        if (count * 2 <= array.length){
            return 0;
        }else{
            return result;
        }

    }
}
