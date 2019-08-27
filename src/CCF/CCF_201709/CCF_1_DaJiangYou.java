package CCF_201709;

import java.util.Scanner;

/**
 * Created by liudong on 2018/10/19.
 * CCF 201709-1 打酱油
 * 问题描述
 　　小明带着N元钱去买酱油。酱油10块钱一瓶，商家进行促销，每买3瓶送1瓶，或者每买5瓶送2瓶。请问小明最多可以得到多少瓶酱油。
 输入格式
 　　输入的第一行包含一个整数N，表示小明可用于买酱油的钱数。N是10的整数倍，N不超过300。
 输出格式
 　　输出一个整数，表示小明最多可以得到多少瓶酱油。
 样例输入
 40
 样例输出
 5
 样例说明
 　　把40元分成30元和10元，分别买3瓶和1瓶，其中3瓶送1瓶，共得到5瓶。
 样例输入
 80
 样例输出
 11
 样例说明
 　　把80元分成30元和50元，分别买3瓶和5瓶，其中3瓶送1瓶，5瓶送2瓶，共得到11瓶。
 */
public class CCF_1_DaJiangYou {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int number = 0;
        if (N / 50 != 0 ) {
            number = number + 7 * (N/50);
            N = N%50;
        }
        if(N/30 != 0){
            number = number + 4 * (N/30);
            N = N%30;
        }
        if(N/10 != 0){
            number = number + 1 * (N/10);
        }
        System.out.print(number);

    }
}
