package LeetCode;

/**
 * Created by liudong on 2018/11/22.
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length
 * of s is 1000.

 Example 1:

 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.
 Example 2:

 Input: "cbbd"
 Output: "bb"

 */
public class DP_LongestPalindromicSubstring_5 {

    private  int lo, maxLen;
    private String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length()-1; i++) {
            extendPa(s, i, i);
            extendPa(s, i, i+1);
        }

        return s.substring(lo,lo+maxLen);
    }

    private void extendPa(String s, int j, int k){
        while(j >= 0 && k <s.length() && s.charAt(j) == s.charAt(k)){
                j--;
                k++;
        }
        if (maxLen <  k-j-1) {
            lo = j+1;
            maxLen = k-j-1;
        }
    }

    public static void main(String[] args){
        String s = "abcdmadamabcd";
        DP_LongestPalindromicSubstring_5 l = new DP_LongestPalindromicSubstring_5();
        String result = l.longestPalindrome(s);
        System.out.print(result);
    }



}
