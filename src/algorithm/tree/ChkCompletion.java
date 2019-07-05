package algorithm.tree;

/*
    有一棵二叉树，请设计一个算法判断它是否是完全二叉树。

    给定二叉树的根结点 root，请返回一个 bool 值代表它是否为完全二叉树。
    树的结点个数小于等于 500。
 */

import java.util.ArrayList;

public class ChkCompletion {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new ChkCompletion().chk(root));
    }


    public boolean chk(TreeNode root) {
        if (root == null) return false;
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        boolean isLeaf = false;
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.remove(0);
            if (tmp.left != null && tmp.right == null && isLeaf) {
                return false;
            }

            if (tmp.left == null && tmp.right != null) {
                return false;
            }

            if (tmp.right == null && tmp.left == null) {
                isLeaf = true;
            }

            if (tmp.left != null) {
                queue.add(tmp.left);
            }

            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
        return true;
    }
}
