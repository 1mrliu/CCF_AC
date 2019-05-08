package JianZhiOffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 滑动窗口的最大值
 *
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class _64_SlideWindowMax {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {

        if (num == null || size <0) return null;
        ArrayList<Integer> list = new ArrayList<Integer>();

        if (size == 0) return list;

        ArrayList<Integer> temp = null;
        if (num.length < size){
            return list;
        }else {
            for (int i = 0; i < num.length - size + 1; i++) {
                temp = new ArrayList<Integer>();
                for (int j = i; j < i + size; j++) {
                    temp.add(num[j]);
                }
                Collections.sort(temp);
                list.add(temp.get(temp.size() - 1));
            }
        }
        return list;
    }

}
