package algorithm.tree;

/*
    从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */


import java.util.ArrayList;

public class PrintTree {
    public static void main(String[] args) {

    }

    // 模拟队列
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        if (root == null)
            return list;

        treeNodes.add(root);

        while (treeNodes.size() != 0) {
            TreeNode tmp = treeNodes.remove(0);
            if (tmp.left != null) {
                treeNodes.add(tmp.left);
            }

            if (tmp.right != null) {
                treeNodes.add(tmp.right);
            }

            list.add(tmp.val);
        }

        return list;
    }

}
