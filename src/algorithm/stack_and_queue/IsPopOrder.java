package algorithm.stack_and_queue;

/*
    输入两个整数序列，第一个序列表示栈的压入顺序，
    请判断第二个序列是否可能为该栈的弹出顺序。
    假设压入栈的所有数字均不相等。
    例如序列 1,2,3,4,5 是某栈的压入顺序，
    序列 4,5,3,2,1 是该压栈序列对应的一个弹出序列，
    但 4,3,5,1,2 就不可能是该压栈序列的弹出序列。
    （注意：这两个序列的长度是相等的）
 */

import java.util.Stack;

public class IsPopOrder {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] arr2 = {4,5,3,2,1};
        int[] arr3 = {4,3,5,1,2};
        System.out.println(IsPopOrder1(arr, arr2));
        System.out.println(IsPopOrder1(arr, arr3));
    }

    /*
    借用一个辅助的栈，遍历压栈顺序，先讲第一个放入栈中，
    这里是 1，然后判断栈顶元素是不是出栈顺序的第一个元素，
    这里是 4，很显然 1≠4，所以我们继续压栈，直到相等以后开始出栈，
    出栈一个元素，则将出栈顺序向后移动一位，直到不相等，
    这样循环等压栈顺序遍历完成，
    如果辅助栈还不为空，说明弹出序列不是该栈的弹出顺序。
     */
    public static boolean IsPopOrder1(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> tmp = new Stack<>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            tmp.push(pushA[i]);
            //如果栈不为空，且栈顶元素等于弹出序列
            while (!tmp.empty() && tmp.peek() == popA[popIndex]) {
                //出栈
                tmp.pop();
                //弹出序列向后一位
                popIndex++;
            }
        }
        return tmp.isEmpty();
    }

    public static boolean IsPopOrder(int [] pushA, int [] popA) {
        if (pushA.length != popA.length)
            return false;

        int len = pushA.length;
        Stack<Integer> ori = new Stack<>();
        Stack<Integer> dest = new Stack<>();
        Stack<Integer> tmp = new Stack<>();

        for (int i = 0; i < len; i++) {
            ori.add(pushA[i]);
        }

        for (int i = len-1; i >= 0; i--) {
            dest.add(popA[i]);
        }

        while(ori.peek() != popA[0]) {
            tmp.add(ori.pop());
        }

        tmp.add(ori.pop());

        while (!dest.isEmpty()) {
            if (!tmp.isEmpty()) {
                if (tmp.pop() != dest.pop())
                    return false;
            continue;
            }

            if (!ori.isEmpty()) {
                if (ori.pop() != dest.pop())
                    return false;
            }
        }

        return true;
    }
}
