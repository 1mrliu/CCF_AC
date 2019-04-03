package LeetCode;

import java.util.*;

/**
 * Created by liudong on 2018/10/22.
 * Given two arrays, write a function to compute their intersection.

 Example 1:

 Input: nums1 = [1,2,2,1], nums2 = [2,2]
 Output: [2,2]
 Example 2:

 Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 Output: [4,9]
 Note:

 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.

 Example
 Set<Integer> s1 = new HashSet<Integer>(Arrays.asList(array1));
 Set<Integer> s2 = new HashSet<Integer>(Arrays.asList(array2));
 s1.retainAll(s2);

 Integer[] result = s1.toArray(new Integer[s1.size()]);
 */
public class _350_IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
      int len = (nums1.length > nums2.length) ? (nums2.length):(nums1.length);
      Arrays.sort(nums1);
      Arrays.sort(nums2);
      int[] res = new int[len];

      int cur = 0;
        for (int i = 0, j=0; i <nums1.length && j <nums2.length ;) {
            if (nums1[i] == nums2[j]) {
                res[cur++] = nums1[i];
                i++;
                j++;
            }
            else if (nums1[i] > nums2[j]) {
                j++;
            }
            else{
                i++;
            }

        }
      return Arrays.copyOf(res,cur);
    }
}
