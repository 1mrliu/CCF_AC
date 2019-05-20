package JianZhiOffer;

/**
 * 判断字符串是否表示数值
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是
 */
public class _53_StringIsNumeric {
    private int index = 0;
    public boolean isNumeric(char[] str) {
        if (str.length < 1) return false;

        // 扫描以表示正负的'+'或'-'为起始的0~9的数位
        boolean flag = scanInteger(str);

        /**
         * 例子   123.45e+6   A.B E C
         * A B C 都是整数部分
         */
        // 判断  123.45
        if (index < str.length && str[index] == '.'){
            index++;
            flag = scanUnsignedInteger(str) || flag;
        }

        // 判断  e+6
        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            flag = flag && scanInteger(str);
        }

        return flag && index == str.length;

    }

     //判断A C    C为E(e)之后的数字
    private boolean scanInteger(char[] str) {
        if (index < str.length &&(str[index] == '-' || str[index] == '+')){
            index++;
        }
        return scanUnsignedInteger(str);
    }

    //判断B的数字，小数点后的数字
    private boolean scanUnsignedInteger(char[] str) {
        int start  = index;
        while (index < str.length && str[index] >= '0' && str[index] <='9'){
            index++;
        }
        // 是否存在整数
        return start < index;
    }
}
