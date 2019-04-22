package JianZhiOffer;

/**
 * 重建二叉树
 */

public class _4_rebuildBinaryTree {

    // Definition for binary tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        return dealBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode dealBinaryTree(int pre[], int startPreOrder, int endPreOrder, int in[], int startInOrder, int endInOrder) {

        //停止递归的条件
        if (startPreOrder > endPreOrder || startInOrder > endInOrder) {
            return null;
        }

        // 先序遍历  第一个就是root
        TreeNode root = new TreeNode(pre[startPreOrder]);
        for (int i = startInOrder; i <= endInOrder; i++) {
            if (pre[startPreOrder] == in[i]) {
                // 其中（i - startInOrder）为中序排序中左子树结点的个数
                //
                root.left = dealBinaryTree(pre, startPreOrder + 1, startPreOrder + (i - startInOrder), in, startInOrder, i - 1);

                root.right = dealBinaryTree(pre, (i - startInOrder) + startPreOrder + 1, endPreOrder, in, i + 1, endInOrder);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int preOrder[] = {1, 2, 4, 7, 3, 5, 6, 8};
        int inOrder[] = {4, 7, 2, 1, 5, 3, 8, 6};
        _4_rebuildBinaryTree ss = new _4_rebuildBinaryTree();
        TreeNode treeNode = ss.reConstructBinaryTree(preOrder, inOrder);
        System.out.println(treeNode);
    }
}
