package algorithm.strings;

/*
    对于两棵彼此独立的二叉树 A 和 B，请编写一个高效算法，
    检查 A 中是否存在一棵子树与 B 树的拓扑结构完全相同。
    给定两棵二叉树的头结点 A 和 B，
    请返回一个 bool 值，代表 A 中是否存在一棵同构于 B 的子树。
 */

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class ChkIndenticalDemo {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
        A.left.left = new TreeNode(4);
        A.left.right = new TreeNode(5);
        A.right.left = new TreeNode(6);
        A.right.right = new TreeNode(7);

        TreeNode B = new TreeNode(2);
        B.left = new TreeNode(4);
        B.right = new TreeNode(5);

        System.out.println(new ChkIndenticalDemo().chkIdentical(A, B));

    }

    // 如果不记录空指针，仅靠前序遍历无法确定二叉树
    public boolean chkIdentical(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        StringBuilder aString = new StringBuilder();
        StringBuilder bString = new StringBuilder();

        ArrayList<TreeNode> listA = new ArrayList<>();
        ArrayList<TreeNode> listB = new ArrayList<>();

        // 实际上是模拟栈
        listA.add(A);
        while (!listA.isEmpty()) {
            A = listA.remove(listA.size() - 1);
            aString.append(A.val + "!");
            if (A.right != null) {
                listA.add(A.right);
            } else aString.append("#!");

            if (A.left != null) {
                listA.add(A.left);
            } else aString.append("#!");

        }

        listB.add(B);
        while (!listB.isEmpty()) {
            B = listB.remove(listB.size() - 1);
            bString.append(B.val + "!");
            if (B.right != null) {
                listB.add(B.right);
            } else bString.append("#!");

            if (B.left != null) {
                listB.add(B.left);
            } else bString.append("#!");
        }

        String bs = bString.toString();
        String as = aString.toString();
        return as.contains(bs);
    }

    public boolean chkIdentical1(TreeNode t1, TreeNode t2) {
        String t1Str = serialByPre(t1);
        System.out.println(t1Str);
        String t2Str = serialByPre(t2);
        System.out.println(t2Str);
        return getIndexOf(t1Str, t2Str) != -1;
    }

    public String serialByPre(TreeNode head) {
        if (head == null) {
            return "#!";
        }
        String res = head.val + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    public int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();
        int[] nextArr = getNextArray(ms);
        int index = 0;
        int mi = 0;
        while (index < ss.length && mi < ms.length) {
            if (ss[index] == ms[mi]) {
                index++;
                mi++;
            } else if (nextArr[mi] == -1) {
                index++;
            } else {
                mi = nextArr[mi];
            }
        }
        return mi == ms.length ? index - mi : -1;
    }

    public int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
        }
        int[] nextArr = new int[ms.length];
        nextArr[0] = -1;
        nextArr[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < nextArr.length) {
            if (ms[pos - 1] == ms[cn]) {
                nextArr[pos++] = ++cn;
            } else if (cn > 0) {
                cn = nextArr[cn];
            } else {
                nextArr[pos++] = 0;
            }
        }
        return nextArr;
    }
}
