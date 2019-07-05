package algorithm.tree;

import java.util.ArrayList;
import java.util.Stack;

/*
    请用非递归方式实现二叉树的先序、中序和后序的遍历打印。
    给定一个二叉树的根结点 root，请依次返回二叉树的先序，中序和后续遍历 (二维数组的形式)。
 */
public class NonRecursiveTraversalDemo {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int[][] ans = new NonRecursiveTraversalDemo().convert(root);
        System.out.println("" + ans[0][0] + ans[0][1] + ans[0][2]);
    }

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
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            if (tmp == null)
                continue;
            res.add(tmp.val);
            stack.push(tmp.right);
            stack.push(tmp.left);
        }
    }

    // 中序
    public void rootOrder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
    }

    // 后序
    public void rightOrder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        // 当前栈顶元素与最近一个弹出的元素
        TreeNode cur, h = root;

        stack.push(h);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if (cur.left != null && (cur.left != h && cur.right != h)) {
                stack.push(cur.left);
            } else if (cur.right != null && cur.right != h) {
                stack.push(cur.right);
            } else {
                //  stack.pop() == cur
                res.add(stack.pop().val);
                h = cur;
            }
        }
    }
}
