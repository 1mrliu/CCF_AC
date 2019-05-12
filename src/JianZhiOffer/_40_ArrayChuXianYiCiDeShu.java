package JianZhiOffer;

/**
 * 数组中只出现一次的数
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */

public class _40_ArrayChuXianYiCiDeShu {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        // 使用异或操作
        // 数字和本身异或是0  0和任意的数字本身异或还是数字本身
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum ^= array[i];
        }
        //获得的sum是出现一次的两个数的异或值
        // 因为其它数字都出现了两次，在异或中全部抵消掉了。由于这两个数字肯定不一样，那么这个异或结果肯定不为0 ，
        // 也就是说在这个结果数字的二进制表示中至少就有一位为1 。
        // 我们在结果数字中找到第一个为1 的位的位置，记为第N 位。
        // 现在我们以第N 位是不是1 为标准把原数组中的数字分成两个子数组，第一个子数组中每个数字的第N 位都为1 ，而第二个子数组的每个数字的第N 位都为0 。
        // 现在我们已经把原数组分成了两个子数组，每个子数组都包含一个只出现一次的数字，而其它数字都出现了两次。
        // &   如果相对应位都是1，则结果为1，否则为0
        int index = 0;
        // int 类型是32位
        for ( index = 0; index < 32 ; index++) {
            // 获得第一次出现是1的index
            if ((sum & (1 << index)) != 0) break;
        }

        for (int i = 0; i < array.length; i++) {
            if ((array[i] &(1 << index))!= 0){
                num2[0] ^= array[i];
            }else {
                num1[0] ^= array[i];
            }
        }
    }

    /**
     * 数组a中只有一个数出现一次，其他数字都出现了3次，找出这个数字
     * @param a
     * @return
     */

    //
    // 第三个申请了32位数组,然后把原数组中的每一个数字,展开成二进制,哪一位为1,那么bits[]那一位就+1.
    // 最终,判断bit中每一位是否是3的倍数(或者是0),如果是,那么我们要找的数字在这一位肯定为0,反之为1
    public static int find1From3(int[] a){
        int[] bits = new int[32];
        int len = a.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < 32; j++){
                bits[j] = bits[j] + ( (a[i]>>>j) & 1);
            }
        }
        int res = 0;
        for(int i = 0; i < 32; i++){
            if(bits[i] % 3 !=0){
                res = res | (1 << i);
            }
        }
        return res;
    }

}
