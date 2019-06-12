package algorithm.stack_and_queue;

/*
    对于一个没有重复元素的整数数组，请用其中元素构造一棵 MaxTree，
    MaxTree 定义为一棵二叉树，其中的节点与数组元素一一对应，
    同时对于 MaxTree 的每棵子树，它的根的元素值为子树的最大值。
    现有一建树方法，对于数组中的每个元素，
    其在树中的父亲为数组中它左边比它大的第一个数和右边比它大的第一个数中更小的一个。
    若两边都不存在比它大的数，那么它就是树根。请设计 O (n) 的算法实现这个方法。

    给定一个无重复元素的数组 A 和它的大小 n，请返回一个数组，
    其中每个元素为原数组中对应位置元素在树中的父亲节点的编号，若为根则值为 - 1。

    测试样例： [3,1,4,2], 4  |   返回：[2,0,-1,2]
 */

import java.util.Stack;

public class MaxTreeDemo {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2};
        int[] res = new MaxTreeDemo().buildMaxTree(arr, arr.length);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public int[] buildMaxTree(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];

        // 从左起左半部分判断
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();
        // 从右起右半部分判断
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                    stack.pop();
            }

            if (!stack.isEmpty()) {
                if (res[i] != -1)
                    // 左右两边选择较小的那个
                    res[i] = arr[stack.peek()] < arr[res[i]] ? stack.peek() : res[i];
                else res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }
}
