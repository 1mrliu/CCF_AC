package CCF_201609;

import java.util.Scanner;

/**
 * Created by liudong on 2018/11/6.
 * 问题描述
 　　请实现一个铁路购票系统的简单座位分配算法，来处理一节车厢的座位分配。
 　　假设一节车厢有20排、每一排5个座位。为方便起见，我们用1到100来给所有的座位编号，第一排是1到5号，第二排是6到10号，依次类推，
     第20排是96到100号。
 　　购票时，一个人可能购一张或多张票，最多不超过5张。如果这几张票可以安排在同一排编号相邻的座位，则应该安排在编号最小的相邻座位。
     否则应该安排在编号最小的几个空座位中（不考虑是否相邻）。
 　　假设初始时车票全部未被购买，现在给了一些购票指令，请你处理这些指令。
 输入格式
 　　输入的第一行包含一个整数n，表示购票指令的数量。
 　　第二行包含n个整数，每个整数p在1到5之间，表示要购入的票数，相邻的两个数之间使用一个空格分隔。
 输出格式
 　　输出n行，每行对应一条指令的处理结果。
 　　对于购票指令p，输出p张车票的编号，按从小到大排序。
 样例输入
 4
 2 5 4 2
 样例输出
 1 2
 6 7 8 9 10
 11 12 13 14
 3 4
 样例说明
 　　1) 购2张票，得到座位1、2。
 　　2) 购5张票，得到座位6至10。
 　　3) 购4张票，得到座位11至14。
 　　4) 购2张票，得到座位3、4。
 */
public class CCF_2_HuoCheGouPiao {
    static  int[] record = new int[100];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];//买票数
            boolean flag = false;//是否连座的判断
            for (int j = 0; j < 20; j++) {
                for (int k = 0; k < 5 ; k++) {
                    //可以订票 开头是0就可以订票
                    if (record[j*5+k] == 0 && k+num <= 5) {
                        for (int t = j*5+k; t < j*5+k+num ; t++) {
                            record[t] = i+1;
                        }
                        flag = true;
                        break;
                    }
                }
                if (flag)
                    break;
            }
            //没有连续的座位 （!(没座位)）= 有座位
            //否则应该安排在编号最小的几个空座位中（不考虑是否相邻）
            if(!flag) {
                while (num-- > 0) {
                    for (int j = 0; j < record.length ; j++) {
                        if (record[j] == 0) {
                            record[j] = i+1;
                            break;
                        }
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0,j = 1; i < record.length; i++) {
            if (record[i] == j) {
                System.out.print(i+1+" ");
                count++;
                if (count == arr[j-1]) {
                    System.out.println();
                    i = 0;
                    j++;
                    count=0;
                }
            }
        }

    }
}
