package LeetCode;

import java.util.Arrays;

/**
 * Created by liudong on 2018/10/22.
 *Given two strings s and t , write a function to determine if t is an anagram of s.

 Example 1:

 Input: s = "anagram", t = "nagaram"
 Output: true
 Example 2:

 Input: s = "rat", t = "car"
 Output: false
 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class _242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1,str2);
    }
    public static void main(String[] args){
            String s = "rat";
            String t = "car";
            _242_ValidAnagram v = new _242_ValidAnagram();
            boolean result = v.isAnagram(s,t);
            System.out.print(result);
    }
}
