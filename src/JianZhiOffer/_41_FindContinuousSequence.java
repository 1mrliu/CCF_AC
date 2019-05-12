package JianZhiOffer;
/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,
 * 他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,
 * 他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列
 *  和为S的连续正数序列
 *  输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */

import java.util.ArrayList;

public class _41_FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
        if (sum < 3) return listAll;
        int low = 1;
        int high = 2;
        while(low < high){
            // 梯形的面积
            int area = (high+low)*(high-low+1)/2;
            if (area == sum){
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i = low; i <= high; i++) {
                    list.add(i);
                }
                listAll.add(list);
                low++;
                //当前窗口的值小于sum，右边窗口右移
            }else if (area < sum){
                high++;
                //当前窗口大于sum，左边窗口右移
            }else {
                low++;
            }
        }
        return listAll;
    }
}
