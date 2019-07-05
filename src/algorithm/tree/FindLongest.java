package algorithm.tree;

import java.util.ArrayList;

/*
    从二叉树的节点 A 出发，可以向上或者向下走，
    但沿途的节点只能经过一次，当到达节点 B 时，
    路径上的节点数叫作 A 到 B 的距离。对于给定的一棵二叉树，求整棵树上节点间的最大距离。

    给定一个二叉树的头结点 root，请返回最大距离。保证点数大于等于 2 小于等于 500.
 */
public class FindLongest {


    // 后序遍历确定
    private int longest = 0;
    public int findLongest(TreeNode root) {
        longest(root);
        return longest;
    }

    public int longest(TreeNode root) {
        if (root == null)
            return 0;
        int left = longest(root.left);
        int right = longest(root.right);
        longest = Math.max(longest, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
