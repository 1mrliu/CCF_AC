package JianZhiOffer;

import java.util.ArrayList;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 问题：
 * 1.为什么分三个队列？
 * 丑数数组里的数一定是有序的，因为我们是从丑数数组里的数乘以2,3,5选出的最小数，一定比以前未乘以2,3,5大，同时对于三个队列内部，按先后顺序乘以2,3,5分别放入，所以同一个队列内部也是有序的；
 * 2.为什么比较三个队列头部最小的数放入丑数数组？
 * 因为三个队列是有序的，所以取出三个头中最小的，等同于找到了三个队列所有数中最小的。
 *
 *
 * 一个丑数的因子只有2,3,5，那么丑数p = 2 ^ x * 3 ^ y * 5 ^ z，换句话说一个丑数一定由另一个丑数乘以2或者乘以3或者乘以5得到，
 * 那么我们从1开始乘以2,3,5，就得到2,3,5三个丑数，在从这三个丑数出发乘以2,3,5就得到4，6,10,6，9,15,10,15,25九个丑数，
 * 我们发现这种方法会得到重复的丑数，而且我们题目要求第N个丑数，这样的方法得到的丑数也是无序的。
 * 那么我们可以维护三个队列： u2 u3 u5
 *
 *
 */
public class _33_UglyNumber {
    public int GetUglyNumber_Solution(int index) {
        // 0-6的数字都是丑数
        if (index < 7) return index;
        // u2 u3 u5 是三个队列的指针   minNum是从队列头选出最小的数
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int u2 = 0, u3 = 0, u5 = 0;
        while (list.size()<index){
            int m2 = list.get(u2)*2;
            int m3 = list.get(u3)*3;
            int m5 = list.get(u5)*5;

            int min = Math.min(m2,Math.min(m3,m5));
            list.add(min);
            //每次只放最小的会保证是升序，三个指针，每次移动一个则是保证不重复
            if (min == m2) u2++;
            if (min == m3) u3++;
            if (min == m5) u5++;
        }
        return list.get(list.size()-1);
    }
}
