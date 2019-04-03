package LeetCode;

/**
 * Created by liudong on 2019/3/14.
 */
public class _852_PeakIndexinaMountainArray {
    public int peakIndexInMountainArray(int[] A) {
      int i=0;
      while(A[i] < A[i+1])
          i++;
      return i;

    }
}
