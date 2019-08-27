package CCF_201509;


import java.util.Scanner;

/**
 * Created by liudong on 2018/11/8.
 * 问题描述
 　　给定一个年份y和一个整数d，问这一年的第d天是几月几日？
 　　注意闰年的2月有29天。满足下面条件之一的是闰年：
 　　1） 年份是4的整数倍，而且不是100的整数倍；
 　　2） 年份是400的整数倍。
 输入格式
 　　输入的第一行包含一个整数y，表示年份，年份在1900到2015之间（包含1900和2015）。
 　　输入的第二行包含一个整数d，d在1至365之间。
 输出格式
 　　输出两行，每行一个整数，分别表示答案的月份和日期。
 样例输入
 2015
 80
 样例输出
 3
 21
 样例输入
 2000
 40
 样例输出
 2
 9

 一年的天数  【1、3、5、7、8、10、12】  31天
            【4、6、9、11】    30天
             2   闰年 29天
                 平年 30天
 */
public class CCF_2_RiQiJiSuan {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int y = sc.nextInt();
        int d = sc.nextInt();

        //是闰年
        if ((((y%4 == 0 )&& (y%100 !=0)) || (y%400 == 0))) {
            if (d >= 1 && d <= 31) {
                System.out.println(1);
                System.out.print(d);
            }
            if (d > 31 && d <= (31+29)) {
                System.out.println(2);
                System.out.print(d-31);
            }
            if (d > (31+29) && d <= (31+29+31)) {
                System.out.println(3);
                System.out.print(d-31-29);
            }
            if (d > (31+29+31) && d <= (31+29+31+30)) {
                System.out.println(4);
                System.out.print(d-31-29-31);
            }
            if (d > (31+29+31+30) && d <= (31+29+31+30+31)) {
                System.out.println(5);
                System.out.print(d-31-29-31-30);
            }
            if (d > (31+29+31+30+31) && d <= (31+29+31+30+31+30)) {
                System.out.println(6);
                System.out.print(d-31-29-31-30-31);
            }
            if (d > (31+29+31+30+31+30) && d <= (31+29+31+30+31+30+31)) {
                System.out.println(7);
                System.out.print(d-31-29-31-30-31-30);
            }
            if (d > (31+29+31+30+31+30+31) && d <= (31+29+31+30+31+30+31+31)) {
                System.out.println(8);
                System.out.print(d-31-29-31-30-31-30-31);
            }
            if (d > (31+29+31+30+31+30+31+31) && d <= (31+29+31+30+31+30+31+31+30)) {
                System.out.println(9);
                System.out.print(d-31-29-31-30-31-30-31-31);
            }
            if (d > (31+29+31+30+31+30+31+31+30) && d <= (31+29+31+30+31+30+31+31+30+31)) {
                System.out.println(10);
                System.out.print(d-31-29-31-30-31-30-31-31-30);
            }
            if (d > (31+29+31+30+31+30+31+31+30+31) && d <= (31+29+31+30+31+30+31+31+30+31+30)) {
                System.out.println(11);
                System.out.print(d-31-29-31-30-31-30-31-31-30-31);
            }
            if (d > (31+29+31+30+31+30+31+31+30+31+30) && d <= (31+29+31+30+31+30+31+31+30+31+30+31)) {
                System.out.println(12);
                System.out.print(d-31-29-31-30-31-30-31-31-30-31-30);
            }
        }
        else{

        //  注意；平年28天！！！
        if (d >= 1 && d <= 31) {
            System.out.println(1);
            System.out.print(d);
        }
        if (d > 31 && d <= (31+28)) {
            System.out.println(2);
            System.out.print(d-31);
        }
        if (d > (31+28) && d <= (31+28+31)) {
            System.out.println(3);
            System.out.print(d-31-28);
        }
        if (d > (31+28+31) && d <= (31+28+31+30)) {
            System.out.println(4);
            System.out.print(d-31-28-31);
        }
        if (d > (31+28+31+30) && d <= (31+28+31+30+31)) {
            System.out.println(5);
            System.out.print(d-31-28-31-30);
        }
        if (d > (31+28+31+30+31) && d <= (31+28+31+30+31+30)) {
            System.out.println(6);
            System.out.print(d-31-28-31-30-31);
        }
        if (d > (31+28+31+30+31+30) && d <= (31+28+31+30+31+30+31)) {
            System.out.println(7);
            System.out.print(d-31-28-31-30-31-30);
        }
        if (d > (31+28+31+30+31+30+31) && d <= (31+28+31+30+31+30+31+31)) {
            System.out.println(8);
            System.out.print(d-31-28-31-30-31-30-31);
        }
        if (d > (31+28+31+30+31+30+31+31) && d <= (31+28+31+30+31+30+31+31+30)) {
            System.out.println(9);
            System.out.print(d-31-28-31-30-31-30-31-31);
        }
        if (d > (31+28+31+30+31+30+31+31+30) && d <= (31+28+31+30+31+30+31+31+30+31)) {
            System.out.println(10);
            System.out.print(d-31-28-31-30-31-30-31-31-30);
        }
        if (d > (31+28+31+30+31+30+31+31+30+31) && d <= (31+28+31+30+31+30+31+31+30+31+30)) {
            System.out.println(11);
            System.out.print(d-31-28-31-30-31-30-31-31-30-31);
        }
        if (d > (31+28+31+30+31+30+31+31+30+31+30) && d <= (31+28+31+30+31+30+31+31+30+31+30+31)) {
            System.out.println(12);
            System.out.print(d-31-28-31-30-31-30-31-31-30-31-30);
        }

     }
    }
}
