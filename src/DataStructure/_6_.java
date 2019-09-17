package DataStructure;

/**
 * 判断某个数是不是2的整数次幂
 */
public class _6_ {
    public static boolean isPowerOf2(int num){
        return (num&num-1) == 0;
    }
}
