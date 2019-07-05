package algorithm.tree;

/*
    从上往下打印出二叉树的每个节点，同层节点从左至右打印，保留层信息。
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

    public int[][] printTree(TreeNode root) {
        // 判断是否为空
        if ( root == null ) {
            throw new IllegalArgumentException();
        }
        // 暂存节点值
        ArrayList<TreeNode> queue = new ArrayList<>();
        TreeNode tmp;
        // 载入根节点
        queue.add(root);
        // 本行末
        TreeNode last = root;
        // 下一行末
        TreeNode nlast = null;
        // 打印信息
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> oneRowRes = new ArrayList<>();

        while ( !queue.isEmpty() ) {
            // 根节点出队
            tmp = queue.remove(0);
            oneRowRes.add(tmp.val);
            if (tmp.left != null) {
                queue.add(tmp.left);
                nlast = tmp.left;
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
                nlast = tmp.right;
            }
            // 到达行末
            if (tmp == last) {
                res.add(oneRowRes);
                // 新建一行
                oneRowRes = new ArrayList<>();
                last = nlast;
            }
        }
        // 转存打印格式
        int[][] printer = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            printer[i] = new int[res.get(i).size()];
            for ( int j = 0; j < printer[i].length; j++ ) {
                printer[i][j] = res.get(i).get(j);
            }
        }
        return printer;
    }

}
