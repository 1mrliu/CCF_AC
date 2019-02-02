package LeetCode;

import java.util.Arrays;

/**
 * Created by liudong on 2019/1/31.
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * Example:

 Given array nums = [-1, 2, 1, -4], and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 */
public class ThreeSumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {
//        int min = Math.abs(nums[0] + nums[1] + nums[2] - target);
//        int result = 0;
//        for (int i = 0; i < nums.length-2; i++) {
//            for (int j = 1; j < nums.length-1; j++) {
//                for (int k = 2; k < nums.length; k++) {
//                    if (Math.abs(nums[i]+nums[j]+nums[k]-target) < min){
//                        min = Math.abs(nums[i]+nums[j]+nums[k]-target);
//                        result = nums[i]+nums[j]+nums[k];
//                    }
//                }
//            }
//        }
        int result = nums[0] + nums[1] + nums[nums.length-1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int start = i+ 1,end=nums.length-1;
            while(start < end){
                int  sum = nums[i] + nums[start] + nums[end];
                if (sum > target) {
                    end--;
                }else{
                    start++;
                }
                if (Math.abs(sum-target) < Math.abs(result-target)) {
                    result = sum;
                }
            }
        }
       return result;
    }
}
