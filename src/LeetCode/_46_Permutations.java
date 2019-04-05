package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liudong on 2019/4/5.
 *Given a collection of distinct integers, return all possible permutations.

 Example:

 Input: [1,2,3]
 Output:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 对给定的数组进行  排列组合
 */
public class _46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> list = new ArrayList<>();
         getResult(list, new ArrayList<>(),nums);
         return list;
    }

    private void getResult(List<List<Integer>> list,List<Integer> tempList, int[] nums){
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        }else{
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                getResult(list, tempList,nums);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {1,2,3};
        _46_Permutations ss = new _46_Permutations();
        System.out.print(ss.permute(nums));
    }
}
