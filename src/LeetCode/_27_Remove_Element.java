package LeetCode;

/**
 * Created by liudong on 2018/12/5.
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1)
 extra memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 Example 1:

 Given nums = [3,2,2,3], val = 3,

 Your function should return length = 2, with the first two elements of nums being 2.

 It doesn't matter what you leave beyond the returned length.

 空间复杂度只能是O（1）
 */
public class _27_Remove_Element {
    // 构建
    public int removeElement(int[] nums, int val){
       int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[result] = nums[i];
                result++;
            }
        }
       return result;
    }

    public static void main(String[] args){
     int[]  nums = {3,2,2,3};
     int val = 3;
     _27_Remove_Element r = new _27_Remove_Element();
     int result =  r.removeElement(nums,val);
     System.out.print(result);
    }
}
