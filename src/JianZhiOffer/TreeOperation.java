package JianZhiOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对树进行的操作
 */

class Node{
    public int data;
    public Node left;
    public Node right;
    // 左子数距离根结点的最大距离
    public int leftMaxDistance;
    // 右子树距离根节点的最大距离
    public int rightMaxDistance;
    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

}
public class TreeOperation {

    private Node root;
    public TreeOperation(){
        root = null;
    }

    /**
     * 队列
     * 层序遍历二叉树
     */
    public void layerTranverse(){
        if(this.root == null)
            return ;

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            Node n = q.poll();

            if (n.left != null)
                q.add(n.left);

            if (n.right != null)
                q.add(n.right);
        }
    }


    private int maxLen = 0;

    /**
     * 找到左右结点距离的最大距离
     * @param root
     */
    public void findMaxDistance(Node root){
        if (root == null) return;
        if (root.left == null) root.leftMaxDistance = 0;
        if (root.right == null) root.rightMaxDistance = 0;
        if (root.left != null) findMaxDistance(root.left);
        if (root.right != null) findMaxDistance(root.right);
        if (root.left != null) root.leftMaxDistance = Math.max(root.left.leftMaxDistance,root.left.rightMaxDistance);
        if (root.right != null) root.rightMaxDistance = Math.max(root.right.leftMaxDistance,root.right.rightMaxDistance);
        if (root.leftMaxDistance + root.rightMaxDistance > maxLen)
            maxLen = root.leftMaxDistance + root.rightMaxDistance;
    }





}
