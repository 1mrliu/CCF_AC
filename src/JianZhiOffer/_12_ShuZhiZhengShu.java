package JianZhiOffer;

/**
 * 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */

public class _12_ShuZhiZhengShu {
    public double Power(double base, int exponent) {
        // exponent 小于0的情况
        boolean flag = true;
        if (exponent < 0){
            flag = false;
            exponent = Math.abs(exponent);
        }
        double result = 1.0;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        if (flag == true){
            return result;
        }else{
            return 1/result;
        }
    }
}
