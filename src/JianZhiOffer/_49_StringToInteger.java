package JianZhiOffer;

/**
 * 把字符串转换成整数
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 示例1
 * 输入:
 * +2147483647
 *     1a33
 * 输出:
 * 2147483647
 *     0
 */
public class _49_StringToInteger {
    public int StrToInt(String str) {
        str = str.trim();
        if (str == null || str.isEmpty()) return 0;
        char[] chars = str.toCharArray();
        // 对于异常的情况 '-' 或者 '+'
        if(chars.length == 1 &&(chars[0] == '-' || chars[0] == '+')) return 0;
        int signum = 1, head = 0;

        // 对str的符号进行判定
        if (Character.isDigit(chars[head]) || chars[head] == '-' || chars[head] == '+') {
            if (chars[head] == '-') {
                signum = -1;
                head++;
            }
            if (chars[head] == '+') {
                head++;
            }
        }

        long result = 0;
        long max = (long) Integer.MAX_VALUE;
        long min = (long) Integer.MIN_VALUE;
        for (int i = head; i < chars.length; i++) {
            if (chars[head] >= '0' && chars[head] <= '9') {
                result = (result * 10) + ((Character.getNumericValue(chars[head++])*signum));
                if (result > 0 && result >= max) {
                    result = max;
                    break;
                }
                if (result < 0 && result <= min) {
                    result = min;
                    break;
                }
            } else {
                result = 0;
                break;
            }
        }
        return (int) result;

    }

    public static void main(String[] args) {
        String s = "-2147483648";
        _49_StringToInteger ss = new _49_StringToInteger();
        int result = ss.StrToInt(s);
        System.out.println(result);
    }
}
