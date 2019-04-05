package LeetCode;

/**
 * Created by liudong on 2019/4/3.
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2,
 * also represented as a string.
 Example 1:
 Input: num1 = "2", num2 = "3"
 Output: "6"

 Example 2:
 Input: num1 = "123", num2 = "456"
 Output: "56088"

 Note:
 The length of both num1 and num2 is < 110.
 Both num1 and num2 contain only digits 0-9.
 Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.

 包含数字的字符串  使用字符串的方法进行乘积运算
 */
public class _43_MultiplyStrings {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m+n];

        for (int i = m-1; i >= 0 ; i--) {
            for (int j = n-1; j >= 0 ; j--) {
                 int d1 = num1.charAt(i) - '0';
                 int d2 = num2.charAt(j) - '0';
                 pos[i+j+1] += d1 * d2;
            }
        }

        int carry = 0;
        for (int i = pos.length-1; i >= 0 ; i--) {
            int tmp = (pos[i] + carry) % 10;
            carry = (pos[i] + carry) / 10;
            pos[i] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for (int p: pos)
                sb.append(p);

        while(sb.length() != 0 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);

        return sb.length() == 0 ? "0": sb.toString();
    }

    public static void main(String[] args){
        String m = "123";
        String n = "456";
        _43_MultiplyStrings ss = new _43_MultiplyStrings();
        System.out.print(ss.multiply(m,n));
    }

}
