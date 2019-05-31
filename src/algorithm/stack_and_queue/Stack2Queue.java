package algorithm.stack_and_queue;

import java.util.Stack;

/*
用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。 队列中的元素为 int 类型。
 */

public class Stack2Queue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        if (stack2.isEmpty()) {
            stack2.push(node);
        } else {
            while (!stack2.isEmpty()) {
                int tmp = stack2.pop();
                stack1.push(tmp);
            }

            stack2.push(node);
            while (!stack1.isEmpty()) {
                int tmp = stack1.pop();
                stack2.push(tmp);
            }
        }
    }

    public int pop() {
        if (stack2 != null)
            return stack2.pop();
        else return -1;
    }
}