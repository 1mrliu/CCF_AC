package JianZhiOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by liudong on 2019/3/18.
 * 之字形打印二叉树
 */
public class ZhiZiXing_ErChaShu {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        int layer =1;
        // s1 存放奇数层节点   奇数层先放右边然后再放左边 入栈
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        s1.push(pRoot);
        // s2 存放偶数层节点  偶数层先放左边然后再放右边 入栈
        Stack<TreeNode> s2 = new Stack<TreeNode>();

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        while(!s1.empty() || s2.empty()){
            if (layer%2 != 0) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while(!s1.empty()){
                    TreeNode node = s1.pop();
                    if (node != null) {
                        temp.add(node.val);
                        System.out.print(node.val + " ");
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                    System.out.println();
                }


            }else {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while (!s2.empty()){
                    TreeNode node = s2.pop();
                    if (node != null) {
                        temp.add(node.val);
                        System.out.print(node.val+" ");
                        s1.push(node.right);
                        s2.push(node.left);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            }
        }
        return list;
    }
}
