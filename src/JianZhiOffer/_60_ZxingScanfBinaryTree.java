package JianZhiOffer;
import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Z字形扫描二叉树
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class _60_ZxingScanfBinaryTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {

        int layer = 1;
        // s1存储奇数层的节点
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        s1.push(pRoot);
        // s2存储偶数层的节点
        Stack<TreeNode> s2 = new Stack<TreeNode>();

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        while (!s1.empty() || !s2.empty()){
              if (layer%2 != 0){
                  ArrayList<Integer> temp = new ArrayList<>();
                  while (!s1.empty()){
                     TreeNode node = s1.pop();
                     if (node != null){
                         temp.add(node.val);
                         System.out.print(node.val+" ");
                         s2.push(node.left);
                         s2.push(node.right);
                     }
                  }
                  if (!temp.isEmpty()){
                      list.add(temp);
                      layer++;
                      System.out.println();
                  }

              }else {
                  ArrayList<Integer> temp = new ArrayList<>();
                  while (!s2.empty()){
                      TreeNode node = s2.pop();
                      if (node!=null){
                          temp.add(node.val);
                          System.out.print(node.val+" ");
                          s1.push(node.right);
                          s1.push(node.left);
                      }
                  }
                  if (!temp.isEmpty()){
                      list.add(temp);
                      layer++;
                      System.out.println();
                  }

              }

        }

        return list;
    }
}
