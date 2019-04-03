package LeetCode;

import java.util.Scanner;

/**
 * Created by liudong on 2018/12/5.
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Example 1:

 Input: [1,3,5,6], 5
 Output: 2
 Example 2:

 Input: [1,3,5,6], 2
 Output: 1
 Example 3:

 Input: [1,3,5,6], 7
 Output: 4
 Example 4:

 Input: [1,3,5,6], 0
 Output: 0
 */
public class _35_Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        int result = 0 ;
        int max = nums[nums.length-1];
        int min = nums[0];
        if (target > max) {
            result = nums.length;
        }
        if (target < min) {
            result = 0;
        }
        for (int i = 0; i <= nums.length-1; i++) {
            if (target == nums[i]) {
                result = i;
            }
            if (target > nums[i] && target < nums[i+1]) {
                result = i + 1;
            }
        }
        return result;

    }

    /**
     *Python 就一句话  return len([x for x in nums if x<target]) Cool
     */

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] nums = {1,3,5,6};
        int target = sc.nextInt();
        _35_Search_Insert_Position s = new _35_Search_Insert_Position();
        int result = s.searchInsert(nums, target);
        System.out.print(result);
    }
}
