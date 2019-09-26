package DataStructure;

public class _9_ {
    /**
     * 判断两个二叉树是否相等
     */
    //Definition for binary tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    private boolean isSameTree(TreeNode p, TreeNode q){
      if (p == null && q == null)  return false;
      if (p!= null && q== null) return false;
      if (p == null && q!= null) return false;
      if (p.val != q.val) return false;
      return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }



}
