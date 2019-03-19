package LeetCode;

import java.util.HashMap;

/**
 * Created by liudong on 2019/3/19.
 * Given a string, find the first non-repeating character in it and return it's index.
 * If it doesn't exist, return -1.

 Examples:

 s = "leetcode"
 return 0.

 s = "loveleetcode",
 return 2.

 */
public class FirstUniqueCharacterinaString_387 {
    public int firstUniqChar(String s) {
        //hashmap 进行存储
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                Integer value  = map.get(s.charAt(i));
                map.put(s.charAt(i),  value+1);
            }else{
              map.put(s.charAt(i),1);
            }
        }
        // 遍历hashmap找出value为1的值  否则return -1
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        String s = "leetcode";
        FirstUniqueCharacterinaString_387 ss = new FirstUniqueCharacterinaString_387();
        System.out.println(ss.firstUniqChar(s));
    }
}
