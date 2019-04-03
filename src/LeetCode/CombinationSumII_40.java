package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liudong on 2019/4/3.
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * Each number in candidates may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 Example 1:
 Input: candidates = [10,1,2,7,6,1,5], target = 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 使用dfs进行遍历出所有的路径
 */
public class CombinationSumII_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        dfs(candidates,0,target,path,res);
        return res;
    }

    private void dfs(int[] candidates, int cur, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(path));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = cur; i < candidates.length; i++) {
            if (i > cur && candidates[i] == candidates[i-1]) {
                continue;
            }
            path.add(path.size(),candidates[i]);
            dfs(candidates,i+1,target-candidates[i],path,res);
            path.remove(path.size()-1);
        }


    }


}
