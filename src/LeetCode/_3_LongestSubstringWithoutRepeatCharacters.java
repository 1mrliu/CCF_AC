package LeetCode;

import java.awt.*;
import java.util.HashSet;

/**
 * 给一个字符串 找出字符串中最长的不包含重复字符的子串
 */
public class _3_LongestSubstringWithoutRepeatCharacters {

    public static int lengthOfLongestSubstring(String s){
        int n = s.length();
        HashSet<Character> set = new HashSet<Character>();
        int ans = 0, i=0,j=0;
        while (i < n && j < n){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }



    public static void main(String[] args){
        String s = "pwwkew";
        int set = lengthOfLongestSubstring(s);
//        for (Character c: set){
//            System.out.print(c);
//        }
        System.out.print(set);
    }
}
