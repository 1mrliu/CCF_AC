package JianZhiOffer;

/**
 * 二进制数中1的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class _11_ErJinZhi {
    public int NumberOf1(int n) {
        // 转化为二进制的函数
        if(n==1) return 1;
        String s = Integer.toBinaryString(n);
        char[] array = s.toCharArray();
        int count = 0;
        for (char x:array) {
            if (Character.getNumericValue(x)  == 1){
                count++;
            }
        }
        return count;
    }
    // new method
    public int numberOf1_1(int n){
        int count = 0;
        while (n!=0){
            count++;
            //每进行一次 n&(n-1)计算，结果中都会少一位，而且是最后一位
            n = n&(n-1);
        }

        return count;
    }


    public static void main(String[] args){
        _11_ErJinZhi ss = new _11_ErJinZhi();
        int n = 10;
        //System.out.print(ss.numberOf1_1(n));
        System.out.print(ss.NumberOf1(n));

    }
}
