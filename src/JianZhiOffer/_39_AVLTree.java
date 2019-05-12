package JianZhiOffer;

/**
 * 平衡二叉树
 * 输入一棵二叉树，判断是不是平衡二叉树
 * 平衡二叉树的定义  左右子树的深度相差不超过1，就是平衡二叉树
 */
public class _39_AVLTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }
    //从下往上遍历，如果子树是平衡二叉树，则返回子树的高度；
    // 如果发现子树不是平衡二叉树，则直接停止遍历，这样至多只对每个结点访问一次。
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }

    public int getDepth(TreeNode root){
        if (root  == null ) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right==-1) return -1;
        return Math.abs(left-right) > 1 ? -1:1+Math.max(left,right);
    }
}
