package LeetCode;

public class _101_SymmetricTree {
    // Definition for a binary tree node.
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
     }

    public boolean isSymmetric(TreeNode root) {
        return solve(root,root);

    }

    public boolean solve(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return solve(root1.left, root2.right) && solve(root1.right, root2.left);
    }
}
