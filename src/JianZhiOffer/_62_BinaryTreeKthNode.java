package JianZhiOffer;

import java.util.Stack;

/**
 * 二叉搜索树的第K个节点
 *给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */
public class _62_BinaryTreeKthNode {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    // 递归遍历
    int index = 0;
    TreeNode KthNode(TreeNode pRoot, int k){
        if (k < 1 || pRoot == null) return null;
        if (pRoot!=null){
            TreeNode node = KthNode(pRoot.left,k);
            // node 不为空就是递归找到了，输出就可以
            if (node != null)
                return node;
            index++;
            if (index == k)
                return pRoot;
            node = KthNode(pRoot.right,k);
            // 如上
            if (node != null)
                return node;
        }
        return null;
    }
    // 非递归遍历
    TreeNode KthNode_(TreeNode root,int k){
        if (root == null || k == 0) return null;
        Stack<TreeNode> stack = new Stack <TreeNode>();
        int count = 0;
        TreeNode node = root;
        do {
            if (node!=null){
                stack.push(node);
                node = node.left;

            }else {
                node = stack.pop();
                count++;
                if (count == k)
                    return node;
                node = node.right;
            }

        }while (!stack.isEmpty()||node !=null);

        return null;
    }



}
