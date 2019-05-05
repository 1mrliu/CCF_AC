package JianZhiOffer;

import sun.reflect.generics.tree.Tree;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，
 * 只能调整树中结点指针的指向
 */
public class _26_BinarySearchTreeShuangXiangList {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
       if (pRootOfTree == null) return null;
       if (pRootOfTree.left == null && pRootOfTree.right == null) return pRootOfTree;
       //将左子树构建成双链表，并返回链表头节点
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode p = left;
        // 定位到左子树双链表最后一个节点
        while ( p!= null && p.right!= null){
            p = p.right;
        }
        // 左子树链表不为空将根节点添加到左子树链表
        if (left!=null){
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }
        // 构造右子树为双链表，返回头节点
        TreeNode right= Convert(pRootOfTree.right);
        //右子树链表不为空将链表添加到根节点以后
        if (right != null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }

        return left!=null? left:pRootOfTree;
    }

}
