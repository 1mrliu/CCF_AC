package CCF_201503;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;

import java.util.*;

/**
 * Created by liudong on 2018/11/10.
 * 问题描述
 　　给定n个整数，请统计出每个整数出现的次数，按出现次数从多到少的顺序输出。
 输入格式
 　　输入的第一行包含一个整数n，表示给定数字的个数。
 　　第二行包含n个整数，相邻的整数之间用一个空格分隔，表示所给定的整数。
 输出格式
 　　输出多行，每行包含两个整数，分别表示一个给定的整数和它出现的次数。按出现次数递减的顺序输出。如果两个整数出现的次数一样多，
    则先输出值较小的，然后输出值较大的。
 样例输入
 12
 5 2 3 3 1 3 4 2 5 2 3 5
 样例输出
 3 4
 2 3
 5 3
 1 1
 4 1
 评测用例规模与约定
 　　1 ≤ n ≤ 1000，给出的数都是不超过1000的非负整数。
 */
public class CCF_2_ShuZiPaiXu {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i],map.get(arr[i])+1);
            }else {
                map.put(arr[i],1);
            }
        }
        //hashmap 按照value值进行遍历
        List<Map.Entry<Integer,Integer>> list_Data = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(list_Data, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                //按value递减排序
                if (o2.getValue().compareTo(o1.getValue()) > 0) {
                    return 1;
                }else if (o2.getValue().compareTo(o1.getValue()) == 0) {
                    if (o2.getKey().compareTo(o1.getKey()) < 0 ) {
                        return 1;
                    }else {
                        return -1;
                    }

                }else {
                    return -1;
                }



            }
        });
        for (Map.Entry<Integer,Integer>  v:list_Data) {
            System.out.println(v.getKey()+" "+v.getValue());
        }

    }
}
