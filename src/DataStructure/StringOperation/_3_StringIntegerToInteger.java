package DataStructure.StringOperation;

import java.awt.*;

/**
 * 将整数字符串转化为整数值
 *
 * 整数字符串： "123" "023" "A13" "0" "21447878797"（溢出）  "-123"
 */
public class _3_StringIntegerToInteger {

    // 先判断整数字符串是否是有效的
    public  boolean isValid(char[] chas){
        if (chas[0] !='-' && (chas[0] < '0' && chas[0]>'9')) return false;
        if (chas[0] == '-' && (chas.length == 1 || chas[1] == '0')) return false;
        if (chas[0] == '0' && chas.length > 1) return false;
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] < '0' || chas[i] > '9'){
                return false;
            }
        }
        return true;
    }

    public int convert(String str){
        if (str == null || str.equals("")){
            return 0;
        }
        char[] chas = str.toCharArray();
        // 不能转
        if (!isValid(chas)) return 0;
        boolean posi = chas[0] != '-' ? true:false;
        int minq = Integer.MIN_VALUE / 10;
        int minr = Integer.MAX_VALUE % 10;
        int res = 0;
        int cur = 0;
        for (int i = posi ? 0:1; i < chas.length; i++) {
            cur = '0' - chas[i];// 判断是否溢出
            if ((res < minq) || (res == minq && cur < minr) ){
                return 0; // 不能转
            }
            res = res * 10 + cur;
        }

        if (posi && res == Integer.MIN_VALUE){
            return 0;
        }
        return posi?-res:res;
    }


    // test
    public static void main(String[] args){
        _3_StringIntegerToInteger res = new _3_StringIntegerToInteger();
        int result = res.convert("0123");
        System.out.print(result);
    }
}
