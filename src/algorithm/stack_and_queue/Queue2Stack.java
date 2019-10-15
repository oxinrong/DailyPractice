package algorithm.stack_and_queue;

import java.util.LinkedList;

public class Queue2Stack {
    LinkedList<Integer> queue1 = new LinkedList<>();
    LinkedList<Integer> queue2 = new LinkedList<>();

    public void push(int val) {
        queue1.addLast(val);
    }

    public int pop() {
        if (stackSize() != 0) { // 栈非空
            if (!queue1.isEmpty()) {
                putN_1ToAnother();
                return queue1.remove(0);
            } else {
                putN_1ToAnother();
                return queue2.remove(0);
            }
        } else return -1;
    }


    public int stackSize() {
        return queue1.size() + queue2.size();
    }

    public void putN_1ToAnother() {
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.addLast(queue1.remove(0));
            }
        } else if (!queue2.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.addLast(queue2.remove(0));
            }
        }
    }
}
