package LeetCode;

import java.util.Arrays;

/**
 * Created by liudong on 2018/11/23.
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 You may assume nums1 and nums2 cannot be both empty.

 Example 1:

 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:

 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5
 *
 */
public class _4_MedianofTwoSortedArrays {
    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] nums = new int[n];
        double result = 0.0 ;

        for (int i = 0; i < nums1.length; i++) {
            nums[i] = nums1[i];
        }

        for (int j = nums1.length; j < n ; j++) {
             nums[j] = nums2[j-nums1.length];
        }

        Arrays.sort(nums);

//        for (int i = 0; i < n ; i++) {
//            System.out.print(nums[i]);
//        }
        if (n % 2 == 1) {
            result = nums[n/2];
        }
        if (n % 2 == 0) {
            result = (float)((nums[n/2] + nums[(n/2)-1]))/2;
        }

        return result ;
    }



}
