package CCF.CCF_201903;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

import java.util.Scanner;

public class CCF_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<String> list=new ArrayList<String>();
        for(int i=0;i<arr.length;i++)
            list.add(String.valueOf(arr[i]));
        Collections.sort(list);
        int mid = 0 ;
        if (list.size() %2 != 0){
            mid = list.size()/2;
            System.out.print(Integer.valueOf(list.get(0))+' '+Integer.valueOf(list.get(mid))+' '+Integer.valueOf(list.get(list.size()-1)));
        }else {
            int mid_re = Integer.valueOf(list.get(list.size()/2))  + Integer.valueOf(list.get((list.size()/2)-1));
            System.out.print(Integer.valueOf(list.get(0))+' '+mid_re/2+' '+Integer.valueOf(list.get(list.size()-1)));
        }

    }
}
