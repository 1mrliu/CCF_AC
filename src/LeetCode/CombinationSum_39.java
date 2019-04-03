package LeetCode;

import java.util.*;

/**
 * Created by liudong on 2019/4/2.
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.

 The same repeated number may be chosen from candidates unlimited number of times.

 Note:

 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 Example 1:

 Input: candidates = [2,3,6,7], target = 7,
 A solution set is:
 [
 [7],
 [2,2,3]
 ]
 Example 2:

 Input: candidates = [2,3,5], target = 8,
 A solution set is:
 [
 [2,2,2,2],
 [2,3,3],
 [3,5]
 ]

 */
public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 对数组进行排序
        Arrays.sort(candidates);
        List<List<Integer>>[] dp  = new ArrayList[target+1];

        for (int t = 0; t <= target; t++) {
            dp[t] = new ArrayList();
            List<List<Integer>> combList = new ArrayList();

            // 对于每一个t，找寻可能的结果
            for (int j = 0; j < candidates.length && candidates[j] <= t; j++) {
                if (candidates[j] == t) {
                    combList.add(Arrays.asList(candidates[j]));
                }else{
                    for (List<Integer> prevlist: dp[t-candidates[j]]){
                        if (candidates[j] >= prevlist.get(prevlist.size()-1)) {
                            List temp = new ArrayList(prevlist);
                            temp.add(candidates[j]);
                            combList.add(temp);
                        }
                    }
                }
            }
            dp[t] = combList;
        }
        return dp[target];
    }
}
