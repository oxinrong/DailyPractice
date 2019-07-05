package algorithm.tree;

/*
    请把纸条竖着放在桌⼦上，然后从纸条的下边向上⽅对折，
    压出折痕后再展 开。此时有 1 条折痕，突起的⽅向指向纸条的背⾯，
    这条折痕叫做 “下” 折痕 ；突起的⽅向指向纸条正⾯的折痕叫做 “上” 折痕。
    如果每次都从下边向上⽅ 对折，对折 N 次。请从上到下计算出所有折痕的⽅向。

    给定折的次数 n, 请返回从上到下的折痕的数组，若为下折痕则对应元素为 "down", 若为上折痕则为 "up".
 */

import java.util.ArrayList;

public class FoldPaperDemo {

    public static void main(String[] args) {
        String[] res = new FoldPaperDemo().foldPaper(3);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public String[] foldPaper(int n) {
        // 构造满二叉树，下为 0，上为 1
        TreeNode root = new TreeNode(0);
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        // 当前行末尾，下一行末尾
        TreeNode last = root, nextLast;
        while (n > 1) {
            TreeNode tmp = queue.remove(0);
            tmp.left = new TreeNode(1);
            tmp.right = new TreeNode(0);
            queue.add(tmp.left);
            queue.add(tmp.right);
            nextLast = tmp.right;

            if (tmp == last) {
                n--;
                last = nextLast;
            }
        }

        //右中左遍历
        return traversal(root).split(" ");
    }

    public String traversal(TreeNode root) {
        StringBuilder res = new StringBuilder();
        if (root == null) return "";

        res.append(traversal(root.right));
        res.append(root.val == 0 ? "down" : "up").append(" ");
        res.append(traversal(root.left));

        return res.toString();
    }
}
