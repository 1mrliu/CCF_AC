package LeetCode;

/**
 * Created by liudong on 2019/1/27.
 * Implement atoi which converts a string to an integer.
 * Note:
 * Only the space character ' ' is considered as whitespace character.
 Assume we are dealing with an environment which could only store integers
 within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical
 value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.

 example1:
 Input: "   -42"
 Output: -42
 Explanation: The first non-whitespace character is '-', which is the minus sign.
 Then take as many numerical digits as possible, which gets 42.

 example2 :
 Input: "words and 987"
 Output: 0
 Explanation: The first non-whitespace character is 'w', which is not a numerical
 digit or a +/- sign. Therefore no valid conversion could be performed.
 */
public class _8_StringtoInteger {
    public int myAtoi(String str) {
        str = str.trim();//delete the whitespace
        if (str == null || str.isEmpty()) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int signum = 1, head = 0;
        //treat sign
        if (Character.isDigit(chars[head])|| chars[head] == '-') {
            if (chars[head] == '-') {
                signum = -1;
            }
            head++;
        }
        long result = 0;
        long max = (long)Integer.MAX_VALUE;
        long min = (long) Integer.MIN_VALUE;
        while(head < chars.length && Character.isDigit(chars[head])){
            result = (result * 10) + ((Character.getNumericValue(chars[head++]))*signum);
            if (result > 0 && result > max) {
                result = max;
                break;
            }
            if (result < 0 && result < min) {
                result = min;
                break;
            }
        }

       return (int)result;
    }
    public static void main(String[] args){
        String a = "";
        _8_StringtoInteger ss = new _8_StringtoInteger();
        System.out.print(ss.myAtoi(a));

    }
}
