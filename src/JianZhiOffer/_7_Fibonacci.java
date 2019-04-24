package JianZhiOffer;

/**
 * 斐波那契数列
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class _7_Fibonacci {
    public int Fibonacci(int n) {
      if (n == 0 || n==1) return n;
      int[] array = new int[n];

      array[0]=1;
      array[1]=1;
        for (int i = 2; i < array.length; i++) {
            array[i] = array[i-1] + array[i-2];
        }

        // 省去数组的空间
//        for (int i = 2; i < n ; i++) {
//            fN = fOne + fTwo;
//             fOne = fTwo;
//             fTwo = fN;
//        }
//      return fN

        return array[n-1];
    }
}
