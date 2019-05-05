package JianZhiOffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class _22_UpToDownPrintTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
         ArrayList<Integer> result = new ArrayList<>();
         ArrayList<TreeNode> queue = new ArrayList<>();
         if (root == null) return result;
         queue.add(root);
         while(queue.size() !=0){
               TreeNode node =  queue.remove(0);
               if (node.left != null) queue.add(node.left);
               if (node.right!=null) queue.add(node.right);
               result.add(node.val);
         }
         return result;
    }
}
