package algorithm.tree;

/*
    请用递归方式实现二叉树的先序、中序和后序的遍历打印。

    给定一个二叉树的根结点 root，
    请依次返回二叉树的先序，中序和后续遍历 (二维数组的形式)。
 */


import java.util.ArrayList;

public class RecursiveTraversalDemo {


    public int[][] convert(TreeNode root) {
        ArrayList<Integer> resA = new ArrayList<>();
        ArrayList<Integer> resB = new ArrayList<>();
        ArrayList<Integer> resC = new ArrayList<>();

        leftOrder(root, resA);
        rootOrder(root, resB);
        rightOrder(root, resC);

        int[][] finalRes = new int[3][resA.size()];
        for (int i = 0; i < resA.size(); i++) {
            finalRes[0][i] = resA.get(i);
            finalRes[1][i] = resB.get(i);
            finalRes[2][i] = resC.get(i);
        }

        return finalRes;
    }

    // 先序
    public void leftOrder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) return;

        res.add(root.val);
        leftOrder(root.left, res);
        leftOrder(root.right, res);
    }

    // 中序
    public void rootOrder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) return;

        rootOrder(root.left, res);
        res.add(root.val);
        rootOrder(root.right, res);
    }

    // 后序
    public void rightOrder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) return;

        rightOrder(root.left, res);
        rightOrder(root.right, res);
        res.add(root.val);
    }
}
