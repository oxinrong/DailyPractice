package algorithm.stack_and_queue;

import java.util.Stack;

/*
    定义栈的数据结构，
    请在该类型中实现一个能够得到栈中所含最小元素的 min 函数
    （时间复杂度应为 O（1））。
 */

/*
    应用一个辅助栈，压的时候，
    如果 A 栈的压入比 B 栈压入大，B 栈不压
    ，，，，小于等于，AB 栈同时压入，出栈，
    如果，AB 栈顶元素不等，A 出，B 不出。
 */
class MyStack {
    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();
    Integer temp = null;
    public void push(int node) {
        if(temp != null){
            if(node <= temp ){
                temp = node;
                min.push(node);
            }
            data.push(node);
        }else{
            temp = node;
            data.push(node);
            min.push(node);
        }
    }

    public void pop() {
        int num = data.pop();
        int num2 = min.pop();
        if(num != num2){
            min.push(num2);
        }
    }

    public int top() {
        int num = data.pop();
        data.push(num);
        return num;
    }

    public int min() {
        int num = min.pop();
        min.push(num);
        return num;
    }
}

public class GetMinDemo {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

    }


}
