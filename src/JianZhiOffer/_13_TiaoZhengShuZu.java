package JianZhiOffer;

import java.util.ArrayList;

/**
 *输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

public class _13_TiaoZhengShuZu {
    public void reOrderArray(int [] array) {
        ArrayList<Integer> ouShu =  new ArrayList<>();
        ArrayList<Integer> jiShu =  new ArrayList<>();
        for (int i=0;i< array.length;i++) {
            //
            if (array[i]%2 == 0 ){
              ouShu.add(array[i]);
            }else{
              jiShu.add(array[i]);
            }
        }

        int[] array_ = new int[ouShu.size()+jiShu.size()];
        int number = 0;
        for (int i :jiShu) {

            array_[number] = i;
            number++;
        }
        int m = jiShu.size();
        for (int i: ouShu){
            array_[m] = i;
            m++;
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = array_[i];
        }
    }

    public static void main(String[] args){
        int[] array ={1,2,3,4,5,6,7};
        _13_TiaoZhengShuZu ss = new _13_TiaoZhengShuZu();
        ss.reOrderArray(array);
        for (int i : array){
            System.out.print(i+" ");
        }
    }

}
