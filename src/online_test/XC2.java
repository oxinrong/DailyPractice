package online_test;

import javafx.util.Pair;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class XC2 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ')') {
                if (stack.isEmpty()) {
                    return "";
                }
                reverseStr(arr, stack.pop(), i);
            } else if (arr[i] == '(') {
                stack.push(i);
            }
        }

        if(!stack.empty())
            return "";
        for (int i = 0; i < arr.length; i++) {
            if (Character.isLetter(arr[i]))
                sb.append(arr[i]);
        }
        return sb.toString();
    }

    static void reverseStr(char[] arr, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            char tmp = arr[startIndex];
            arr[startIndex++] = arr[endIndex];
            arr[endIndex--] = tmp;
        }
    }

    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(resolve(str));
    }
}
