package LeetCode;

/**
 * Created by liudong on 2019/2/23.
 *
 * Given a string s consists of upper/lower-case alphabets
 * and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * Example:
 * Input: "Hello World"
 * Output: 5
 */
public class _58_LengthofLastWord {
    public int lengthOfLastWord(String s) {
        int sum = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i)!=' '){
                sum++;
            } else if (sum == 0 ) {
                continue;
            } else
                break;
        }
    return sum;

    }
    public static void main(String[] args){
         String s = "Hello World";
         _58_LengthofLastWord ss = new _58_LengthofLastWord();
         int result = ss.lengthOfLastWord(s);
         System.out.print(result);
    }
}
