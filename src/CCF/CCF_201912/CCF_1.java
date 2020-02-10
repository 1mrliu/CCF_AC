package CCF.CCF_201912;

import java.util.Scanner;
// 报数

public class CCF_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] people = new int[4];
        for (int i = 1; i <= N; i++) {
            // i % 7 == 0  代表是7的倍数 7 14 21
            // i /100 ==7 是      700  百位
            // (i%100)/10 == 7    376  十位
            // (i%100)%10 == 7    327  个位
            if ((i % 7 ==0) || String.valueOf(i).contains("7")){ // 字符串的包含关系判断是否有7
                people[(i-1)%4]++;
                N++;
            }
        }
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }

    }


}
