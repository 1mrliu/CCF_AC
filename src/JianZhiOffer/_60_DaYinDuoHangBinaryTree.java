package JianZhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 把二叉树打印成多行
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class _60_DaYinDuoHangBinaryTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) return listAll;
        // 使用队列，先进先出
        Queue<TreeNode> queue = new LinkedList<>();
        // 存放每行的列表
        ArrayList list = new ArrayList();
        // 记录本层打印了多少个
        int start  = 0;
        // 记录下层打几个
        int end = 1;
        queue.add(pRoot);
        while (!queue.isEmpty()){
            TreeNode temp = queue.remove();
            // 添加到本行的arrayList
            list.add(temp.val);
            start++;
            // 每打印一个节点，就把此节点的下一层的左右节点加入队列，并记录下一层要打印的个数
            if (temp.left != null){
                queue.add(temp.left);
            }
            if (temp.right != null){
                queue.add(temp.right);
            }

            //判断本层打印是否完成
            if (start == end) {
                //此时的queue中存储的都是下一层的节点，则end即为queue大小
                end = queue.size();
                start = 0;
                //把arrayList添加到结果列表arrayLists中
                listAll.add(list);
                //重置arrayList
                list = new ArrayList();
            }
        }

        return listAll;
    }

}
