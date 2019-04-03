package LeetCode;

/**
 * Created by liudong on 2019/3/26.
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.

 Your algorithm's runtime complexity must be in the order of O(log n).

 Example 1:

 Input: nums = [4,5,6,7,0,1,2], target = 0
 Output: 4
 Example 2:

 Input: nums = [4,5,6,7,0,1,2], target = 3
 Output: -1

 */
public class _33_SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        // O(n)时间复杂度
        //        for (int i = 0; i < nums.length; i++) {
//            if (target == nums[i]) {
//                return i;
//            }
//        }
//        return -1;
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid =low +  (high-low)/2;
            if (nums[mid] == target) {
                return mid;
            }
            // mid不在左半边的升序数组中
            if (nums[mid] < nums[low]) {
                if(target < nums[mid] || target >= nums[low]){
                    high = mid -1;
                }else {
                    low = mid +1;
                }
            }else {
                if (target > nums[mid] || target < nums[low]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

}
