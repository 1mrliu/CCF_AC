package CCF.CCF_201903;

import java.util.ArrayList;
import java.util.Scanner;

public class CCF_2 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        String[] res = new String[n];

        for (int m = 0; m < n; m++) {
            String s = sc.next();
            ArrayList<String> list = new ArrayList <>();
            // 入list
            for (int i = 0; i < s.length(); i++) {
                list.add(s.substring(i,i+1));
            }
            for (int i=0;i<list.size()-1;i++){
                if (list.get(i).equals("/")){
                    int x = Integer.parseInt(list.get(i-1));
                    int y = Integer.parseInt(list.get(i+1));
                    String sum = (x / y)+"";
                    list.remove(i+1);
                    list.remove(i);
                    list.set(i-1,sum);
                    i=0;
                } else if (list.get(i).equals("x")){
                    int x = Integer.parseInt(list.get(i-1));
                    int y = Integer.parseInt(list.get(i+1));
                    String sum = (x * y)+"";
                    list.remove(i+1);
                    list.remove(i);
                    list.set(i-1,sum);
                    i=0;
                }

            }

            for (int i=0; i<list.size()-1;i++){
                if (list.get(i).equals("-")){
                    int x = Integer.parseInt(list.get(i-1));
                    int y = Integer.parseInt(list.get(i+1));
                    String sum = (x-y)+"";
                    list.remove(i+1);
                    list.remove(i);
                    list.set(i-1,sum);
                    i=0;
                }else if (list.get(i).equals("+")){
                    int x = Integer.parseInt(list.get(i-1));
                    int y = Integer.parseInt(list.get(i+1));
                    String sum = (x + y)+"";
                    list.remove(i+1);
                    list.remove(i);
                    list.set(i-1,sum);
                    i=0;
                }
            }

            if (Integer.parseInt(list.get(0)) == 24){
                res[m] = "Yes";
            }else {
                res[m] =  "No";
            }
        }
        for (String s:res) System.out.println(s);
    }

}
