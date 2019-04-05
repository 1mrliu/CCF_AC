package JianZhiOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liudong on 2019/4/3.
 * 微软实习生笔试题
 *
 * 给出一个数XX，−105≤X≤105−105≤X≤105，可以随意改变XX中数字的顺序，问可以得到的最小数是多少。要求得到的数不允许有前导0。

 样例
 输入：301，输出：103
 输入：-8139，输出：-9831
 算法
 (排序) O(nlogn)O(nlogn)
 一个很直观的想法：要想得到最小数，我们只要把所有数字从小到大排序即可。
 有两个要注意的地方：

 处理前导0：把最小的非零数字换到首位即可。
 处理负数：这里利用C++的特性，对正数取模会得到正余数，对负数取模会得到负余数。例如 −8139%10=−9−8139%10=−9，
 所以我们对所有数字从小到大排序时，−9−9会排在最前面， 而这正是我们想要的。因此处理负数时，代码不需要做任何修改！

 作者：yxc
 链接：https://www.acwing.com/blog/content/13/
 来源：AcWing
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class min_number {
    private static int transfer(int[] arr){
        String str = "";
        for(int i=0; i<arr.length; i++){
            String s = new String();
            int z = arr[i];
            s = Integer.toString(z);
            str = str.concat(s);
        }
        int num = Integer.parseInt(str);
        return num;
    }
    private static int getMinnumber(int number){
        // number > 0
        boolean flag = false;
        if (number < 0){
            number = Math.abs(number);
            flag = true;
        }
        String s = ((Integer)number).toString();
        int[] array = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            array[i] = Integer.parseInt(ch.toString());
        }
        if (flag == false){
            Arrays.sort(array);
            if (array[0] == 0){
                for (int i = 1; i < array.length ; i++) {
                    if(array[i] != 0){
                        int temp = array[0];
                        array[0] = array[i];
                        array[i] = temp;
                        break;
                    }
                }
            }
            return transfer(array);
        }else {
            for (int i = 0; i < array.length; i++) {
                array[i] = number % 10;
                number /= 10;
            }
            return  -transfer(array);
        }
    }
}
