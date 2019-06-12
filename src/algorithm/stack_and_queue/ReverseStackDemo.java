package algorithm.stack_and_queue;

/*
    实现一个栈的逆序，但是只能用递归函数和这个栈本身的 pop 操作来实现，
    而不能自己申请另外的数据结构。

    给定一个整数数组 A 即为给定的栈，同时给定它的大小 n，请返回逆序后的栈。
 */

import java.util.Stack;

public class ReverseStackDemo {

    public int getBottom(Stack<Integer> myStack) {
        int res = myStack.pop();
        if (myStack.isEmpty()) {
            return res;
        } else {
            int last = getBottom(myStack);
            // 压入上一个值
            myStack.push(res);
            return last;
        }
    }

    public void reverse(Stack<Integer> myStack) {
        if (myStack.isEmpty()) return;

        int i = getBottom(myStack);
        reverse(myStack);
        myStack.push(i);
    }

    public int[] reverseStack(int[] A, int n) {
        Stack<Integer> myStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            myStack.push(A[i]);
        }

        reverse(myStack);
        for (int i = 0; i < n; i++) {
            A[i] = getBottom(myStack);
        }

        return A;
    }

    public int[] reverseStack1(int[] A, int n) {
        if (n == 0)
            return null;
        int node = A[n - 1];
        reverseStack1(A, n - 1);
        A[A.length - n] = node;
        return A;
    }

    public static void main(String[] args) {
        int[] A = {4, 3, 2, 1};
        int[] res = new ReverseStackDemo().reverseStack(A, A.length);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
