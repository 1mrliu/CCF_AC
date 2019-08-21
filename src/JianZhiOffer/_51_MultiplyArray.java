package JianZhiOffer;

/**
 * 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 *
 *
 * 使用除法的话，直接把数组的乘积除于对应的数值就可以获得
 */
public class _51_MultiplyArray {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int ret = 1;
        for (int i = 0; i < B.length; i++) {
            ret = ret*A[i];
            B[i] *= ret;
        }
        ret = 1;
        for (int i = B.length-1; i >=0;i-- ) {
             ret = ret *A[i];
             B[i] *= ret;
        }
        return B;
    }
}
