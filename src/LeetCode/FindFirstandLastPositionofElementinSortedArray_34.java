package LeetCode;

/**
 * Created by liudong on 2019/3/29.
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of
 * a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindFirstandLastPositionofElementinSortedArray_34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result[0] = i;
                break;
            }
        }
        if (result[0] == -1) {
            return result;
        }
        for (int i = nums.length-1; i >= 0 ; i--) {
            if (nums[i] == target) {
               result[1] = i;
               break;
            }
        }
        return result;

    }
}
