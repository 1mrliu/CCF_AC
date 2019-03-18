package JianZhiOffer;

import java.util.ArrayList;

/**
 * Created by liudong on 2019/3/18.
 * 二叉树中和为某一个值的路径
 */
public class ErChaShu_MaxSumNode{
     public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
         ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return paths;
        }
        find(paths,new ArrayList<Integer>(), root,target);
        return paths;
    }

    public void find(ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path, TreeNode root,int target) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                paths.add(path);
            }
            return;
        }
        ArrayList<Integer> path2 = new ArrayList<>();
        path2.addAll(path);
        if (root.left != null) {
            find(paths,path,root.left,target-root.val);
        }
        if (root.right != null) {
            find(paths,path,root.right,target-root.val);
        }
     }

    public static void main(String[] args){

    }

}
