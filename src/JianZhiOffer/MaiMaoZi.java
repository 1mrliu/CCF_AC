package JianZhiOffer;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Created by liudong on 2019/4/1.
 * 百度 2017年笔试题 买帽子
 * 度度熊想去商场买一顶帽子，商场里有N顶帽子，有些帽子的价格可能相同。度度熊想买一顶价格第三便宜的帽子，
 * 问第三便宜的帽子价格是多少？

 输入描述:
 首先输入一个正整数N（N <= 50），接下来输入N个数表示每顶帽子的价格（价格均是正整数，且小于等于1000）

 输出描述:
 如果存在第三便宜的帽子，请输出这个价格是多少，否则输出-1

 输入例子1:
 10
 10 10 10 10 20 20 30 30 40 40

 输出例子1:
 30
 */
public class MaiMaoZi {
    public static void main(String[] args){
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i],map.get(arr[i])+1);
            }else {
                map.put(arr[i],1);
            }
        }
        if (map.size() < 3) {
            System.out.print(-1);
        }else{
            int j = 0;
            for (Integer key: map.keySet()){
               j++;
                if (j == 3) {
                    System.out.print(key);
                }

            }
        }
    }
}
