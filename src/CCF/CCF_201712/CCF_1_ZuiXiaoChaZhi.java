package CCF_201712;

import java.util.Scanner;

/**
 * Created by liudong on 2018/10/19.
 * CCF  201712-1
 * 最小差值
 *
 */
public class CCF_1_ZuiXiaoChaZhi {
    public static void main(String[] args){
        Scanner  sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] m = new int[n];
        for(int i =0; i< n;i++){
            m[i] = sc.nextInt();
        }
        int min = 1000;
        for(int i = 0; i<m.length;i++){
            for (int j = i+1; j < m.length; j++) {
                if (Math.abs(m[i] - m[j]) < min) {
                    min = Math.abs(m[i] - m[j]);
                }
            }
        }
        System.out.print(min);

    }
}
