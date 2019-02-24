package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liudong on 2019/1/19.
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 使用递归的方法进行解决
 */
public class GenerateParentheses_22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        backtrack(res, "", 0,0,n);
        return res;
    }
    public void backtrack(List<String> ans,String cur,int open, int close,int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }
        if (open < max) {
            backtrack(ans, cur+"(",open+1,close,max);
        }
        if (close < open) {
            backtrack(ans, cur+")", open, close+1,max);
        }
    }
    public static void main(String[] args){
        GenerateParentheses_22 solution = new GenerateParentheses_22();
        System.out.print(solution.generateParenthesis(3));

    }
}
