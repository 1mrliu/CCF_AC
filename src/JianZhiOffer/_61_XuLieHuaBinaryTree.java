package JianZhiOffer;

/**
 * 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class _61_XuLieHuaBinaryTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    int index  = -1;
    // 序列化二叉树
    String Serialize(TreeNode root) {
        if (root == null) return "#!";
        String res = root.val + "!";
        res  += Serialize(root.left);
        res  += Serialize(root.right);
        return res;
    }
    // 反序列化二叉树
    TreeNode Deserialize(String str) {
        index++;
        String[] strs = str.split("!");
        TreeNode node = null;
        if (!strs[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strs[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }

}
