package algorithm.stack_and_queue;

import java.util.Stack;

/*
    定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的 min 函数。
    （时间复杂度应为 O（1））
 */

/*
    应用一个辅助栈，压的时候，
    如果 A 栈的压入比 B 栈压入大，B 栈不压
    ，，，，小于等于，AB 栈同时压入，出栈，
    如果，AB 栈顶元素不等，A 出，B 不出。
 */

public class GetMinDemo {
    Stack<Integer> dataStack = new Stack();
    Stack<Integer> minStack = new Stack();

    public void push(int node) {
        dataStack.push(node);
        if (minStack.isEmpty() || minStack.peek() > node)
            minStack.push(node);
    }

    public void pop() {
        if (minStack.peek() == dataStack.peek())
            minStack.pop();
        dataStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
