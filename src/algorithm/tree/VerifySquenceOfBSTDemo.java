package algorithm.tree;

/*
    输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
    如果是则输出 Yes, 否则输出 No。假设输入的数组的任意两个数字都互不相同。
 */

public class VerifySquenceOfBSTDemo {

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 7, 9, 8, 6};
        System.out.println(new VerifySquenceOfBSTDemo().VerifySquenceOfBST(arr));
    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) return false;
        return verify(sequence, 0, sequence.length - 1);
    }


    /*
        BST 的后序序列的合法序列是，对于一个序列 S，最后一个元素是 x （也就是根），
        如果去掉最后一个元素的序列为 T，那么 T 满足：T 可以分成两段，
        前一段（左子树）小于 x，后一段（右子树）大于 x，且这两段（子树）都是合法的后序序列。
     */
    public boolean verify(int[] sequence, int start, int end) {
        if (start >= end) return true;
        int index = end;

        // 右子树范围判定
        while (index > start && sequence[index - 1] > sequence[end])
            index --;

        // 前半部分（左子树）与最后比较
        for (int j = index - 1; j >= start; j--)
            if (sequence[j] > sequence[end]) return false;

            // 前一半和后一半再递归判断
        return verify(sequence, start, index - 1)
                && verify(sequence, index, end - 1);
    }

}
