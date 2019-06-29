package algorithm.arrays;

/*
    给定一棵完全二叉树的根节点 root，返回这棵树的节点个数。
    如果完全二叉树的节点数为 N，请实现时间复杂度低于 O (N) 的解法。

    给定树的根结点 root，请返回树的大小。
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class CountNodesDemo {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new CountNodesDemo().count(root));
    }


    public int count(TreeNode root) {
        TreeNode cur = root;
        // 根节点有一个
        int res = 1;
        int height = 0, rightHeight = 1;

        if (cur.left == null) return 1;

        // 确定层数
        while (cur != null) {
            height ++;
            cur = cur.left;
        }

        cur = root.right;
        // 确定右子树最左节点所在层数
        while (cur != null) {
            rightHeight ++;
            cur = cur.left;
        }

        // 判断左子树是否是满树
        // 左边是满的，还要算右子树；若右边是满的（少一层），还要算左子树。
        res += rightHeight == height ? (int)Math.pow(2, height - 1) - 1
                : (int)Math.pow(2, height - 2) - 1;

        res += rightHeight == height ? count(root.right)
                : count(root.left);

        return res;
    }

    // 非递归
    public int count1(TreeNode root) {
        int n = 0;
        int sum = 0;
        TreeNode node1 = root;
        while(node1 != null) {
            n++;
            node1 = node1.left;
        }
        if(n == 1) {
            return 1;
        }
        while( n > 1) {
            if(n == subcnt(root.right)) {
                sum += 2 << (n - 2);
                root = root.right;
            } else {
                sum += 2 << (n - 2) ;
                root = root.left;
            }
            n--;
        }
        return sum + 1;

    }

    public int subcnt(TreeNode root) {
        int n = 1;
        while(root != null) {
            root = root.left;
            n++;
        }
        return n;
    }

}
