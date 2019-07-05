package algorithm.tree;

/*
    有一棵二叉树，请设计一个算法判断这棵二叉树是否为平衡二叉树。

    给定二叉树的根结点 root，请返回一个 bool 值，代表这棵树是否为平衡二叉树。
 */

public class ChkAVL {

    public boolean check(TreeNode root) {
        return subChk(root) != -1;
    }

    public int subChk(TreeNode root) {
        if (root == null) return 0;

        int left = subChk(root.left);
        if (left == -1) return -1;

        int right = subChk(root.right);
        if (right == -1) return -1;

        if (Math.abs(right - left) > 1) return -1;

        return (Math.max(left, right) + 1);
    }

}
