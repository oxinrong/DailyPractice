package algorithm.stack_and_queue;

import java.util.Stack;

/*
    编写一个类，只能用两个栈结构实现队列，支持队列的基本操作 (push，pop)。

    给定一个操作序列 ope 及它的长度 n，其中元素为正数代表 push 操作，为 0 代表 pop 操作，
    保证操作序列合法且一定含 pop 操作，请返回 pop 的结果序列。

    测试样例：
        [1,2,3,0,4,0],6
        返回：[1,2]
    */

public class Stack2Queue {
    Stack<Integer> stackPush = new Stack<>();
    Stack<Integer> stackPop = new Stack<>();

    public void push(int node) {
        if (stackPop.isEmpty()) {
            stackPop.push(node);
        } else {
            while (!stackPop.isEmpty()) {
                int tmp = stackPop.pop();
                stackPush.push(tmp);
            }

            stackPop.push(node);
            while (!stackPush.isEmpty()) {
                int tmp = stackPush.pop();
                stackPop.push(tmp);
            }
        }
    }

    public int pop() {
        if (stackPop != null)
            return stackPop.pop();
        else return -1;
    }

    public int[] twoStack(int[] ope, int n) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            if (ope[i] == 0)
                count++;
        }

        int[] res = new int[count];
        int j = 0;
        for(int i = 0; i < n; i++) {
            if (ope[i] > 0) {
                push(ope[i]);
            } else res[j++] = pop();
        }

        return res;
    }
}