package algorithm.stack_and_queue;

/*
    请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），
    要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。

    给定一个 int [] numbers(C++ 中为 vector&ltint>)，其中第一个元素为栈顶，
    请返回排序后的栈。
    请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
 */

import java.util.ArrayList;
import java.util.Stack;

public class TwoStacksSortDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(new TwoStacksSortDemo().twoStacksSort1(arr));
    }

    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        int len = numbers.length;
        int[] help = new int[len];
        int i = 0, j = len, current;

        while (i < len) {
            current = numbers[i++];
            if (j == len || current <= help[j]) {
                help[--j] = current;
            } else if (current > help[j]) {
                while (j < len && current > help[j]) {
                    numbers[--i] = help[j++];
                }
                help[--j] = current;
            }

        }

        ArrayList<Integer> res = new ArrayList<>();
        int k = 0;
        while (k < len) res.add(help[len - k++ - 1]);
        return res;
    }

    public ArrayList<Integer> twoStacksSort1(int[] numbers) {
        Stack<Integer> helpStack = new Stack<>();
        Stack<Integer> dataStack = new Stack();
        for (int i = 0; i < numbers.length; i++) {
            dataStack.push(numbers[i]);
        }

        while (!dataStack.empty()) {
            if (helpStack.empty() || dataStack.peek() > helpStack.peek()) {
                helpStack.push(dataStack.pop());
            }
            else {
                int temp = dataStack.pop();
                while (!helpStack.empty() && helpStack.peek() > temp) {
                    dataStack.push(helpStack.pop());
                }
                helpStack.push(temp);
            }
        }

        for (Integer integer : helpStack) {
            dataStack.push(integer);
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!dataStack.isEmpty()) res.add(dataStack.pop());
        return res;
    }

    public ArrayList<Integer> twoStacksSort2(int[] numbers) {
        ArrayList<Integer> temp = new ArrayList<>();
        Stack<Integer> helper = new Stack<>();
        int index = 0; //栈顶标记，当numbers中有数被弹出，index++
        int cur = numbers[index]; //被弹出的元素记为当前元素

        helper.push(cur);
        index++;

        while (index < numbers.length) {
            cur = numbers[index];
            index++;
            if (cur <= helper.peek()) {
                helper.push(cur);
            } else {
                while (!helper.isEmpty()) {
                    if (cur > helper.peek()) {
                        index--;
                        numbers[index] = helper.pop();
                    } else {
                        break;
                    }
                }
                helper.push(cur);
            }
        }

        //将helper栈的数据压回numbers栈
        index--;
        while (!helper.isEmpty()) {
            numbers[index] = helper.pop();
            index--;
        }

        //数组转list
        for (int i = 0; i < numbers.length; i++) {
            temp.add(numbers[i]);
        }

        return temp;
    }
}
