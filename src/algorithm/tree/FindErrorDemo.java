package algorithm.tree;

import java.util.ArrayList;

/*
    一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，
    使得这棵二叉树不再是搜索二叉树，请找到这两个错误节点并返回他们的值。
    保证二叉树中结点的值各不相同。
    给定一棵树的根结点，请返回两个调换了位置的值，其中小的值在前。
 */
public class FindErrorDemo {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        int[] res = new FindErrorDemo().findError(root);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public int[] findError(TreeNode root) {
        // 中序遍历
        ArrayList<Integer> res = new ArrayList<>();
        inOrder(root, res);
        int[] finalRes = new int[2];

        // 查看降序
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i) > res.get(i+1)) {
                finalRes[1] = res.get(i);
                break;
            }
        }

        for (int i = res.size()-1; i > 0; i--) {
            if (res.get(i) < res.get(i - 1)) {
                finalRes[0] = res.get(i);
                break;
            }
        }

        return finalRes;
    }

    public void inOrder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }

        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }
}
