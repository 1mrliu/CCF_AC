import java.util.*;

public class test11 {
    static String f(int a, int b){
        List t1 = new ArrayList();  //商
        List t2 = new ArrayList();  //余数
        String re = "";
        double result = (double)a/b;
        if(result % 1.0 == 0){
            return String.valueOf((long)result);
        }

        int p = - 1;//循环节的起始位置
        while(true){

            t1.add(a/b);
            int x = a % b;
            if(x == 0) break;

            p = t2.indexOf(x);

            if(p >= 0) break;
            else
                t2.add(x);

            a = x*10;
        }
        re = re + t1.get(0);
        re = re + ".";

        for(int i = 1; i < t1.size();i++){
            if(i == p + 1)
                re += "(";
            re += t1.get(i);
        }
        if(p >= 0)
            re += ")";
        return re;
    }

    public static List<String> costsOfNodes(List<String> lines) {
        // Write your code here
        Map<Character,Integer> map = new HashMap <>();
        for (int i = 0; i < lines.size(); i++) {
            String s = "A,3,4";
            String[] rr = s.split(",");
            String[] chars = lines.get(i).split(",");
            for (int j = 0; j < chars[i].length(); j++) {
                if (map.containsKey(chars[i].charAt(j))){
                    int key = map.get(chars[i].charAt(j));
                    map.put(chars[i].charAt(j),++key);
                }else {
                    map.put(chars[i].charAt(j),1);
                }

            }

        }

        List<Map.Entry<Character,Integer>> list = new ArrayList<Map.Entry<Character,Integer>>(map.entrySet());

        Collections.sort(list,new Comparator<Map.Entry<Character,Integer>>() {
         //升序排序
        public int compare(Map.Entry<Character,Integer> o1, Map.Entry<Character,Integer> o2) {
          return o1.getKey().compareTo(o2.getKey());
        }
      });
        ArrayList<String> listall = new ArrayList <>();
        for (Map.Entry<Character,Integer> ee:map.entrySet()){
         String ss = "";
         ss += ee.getKey();
         ss += ",";
         ss += ee.getValue();
         listall.add(ss);
         }

        return listall;

    }




    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "A,3,4";
        String[] rr = s.split(",");
        for (int i = 0; i < rr.length ; i++) {
            System.out.print(rr[i]);
        }

//        System.out.print(f(229, 990));
    }

}