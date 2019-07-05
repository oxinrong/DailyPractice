package algorithm.tree;

import java.util.Stack;

/*
    首先我们介绍二叉树先序序列化的方式，假设序列化的结果字符串为 str，
    初始时 str 等于空字符串。先序遍历二叉树，如果遇到空节点，
    就在 str 的末尾加上 “#!”，“#” 表示这个节点为空，节点值不存在，
    当然你也可以用其他的特殊字符，“!” 表示一个值的结束。
    如果遇到不为空的节点，假设节点值为 3，就在 str 的末尾加上 “3!”。现在请你实现树的先序序列化。

    给定树的根结点 root，请返回二叉树序列化后的字符串。
 */
public class Tree2String {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new Tree2String().toString2(root));
    }



    public String toString2(TreeNode root) {
        if (root == null) return "";

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        StringBuilder res = new StringBuilder();

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                res.append(cur.val).append("!");
                stack.push(cur);
                cur = cur.left;
            } else {
                res.append("#!");
                cur = stack.pop().right;
            }
        }
        res.append("#!");

        return res.toString();
    }
}
