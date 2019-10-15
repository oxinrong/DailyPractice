package algorithm;

import java.util.ArrayList;

/*
    输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
    路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
    (注意：在返回值的 list 中，数组长度大的数组靠前)
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class FindPathDemo {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(1);
        System.out.println(new FindPathDemo().FindPath(root, 6));
    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return res;
        path.add(root.val);
        target -= root.val;

        if (target < 0){
            path.remove(path.size() - 1);
            return res;
        }

        if (target == 0 && root.left == null && root.right == null)
            // 否则 res 中所有的引用都指向了同一个 path
            res.add(new ArrayList<>(path));
        FindPath(root.left, target);
        FindPath(root.right, target);
        // 移除最后一个元素
        // 递归到叶子节点如果还没有找到路径，就要回退到父节点继续寻找，依次类推
        path.remove(path.size() - 1);

        return res;
    }
}
