package online_test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class XC1 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static ListNode partition(ListNode head, int m) {
        ListNode back = new ListNode(-1);
        ListNode curb = back;
        ListNode front = new ListNode(-1);
        ListNode curf = front;
        ListNode tmp = head;
        while (tmp != null) {
            if (tmp.val <= m) {
                curf.next = new ListNode(tmp.val);
                curf = curf.next;
            } else {
                curb.next = new ListNode(tmp.val);
                curb = curb.next;
            }
            tmp = tmp.next;
        }

        curf.next = back.next;
        return front.next;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListNode head = null;
        ListNode node = null;
        int m = in.nextInt();
        while (in.hasNextInt()) {
            int v = in.nextInt();
            if (head == null) {
                node = new ListNode(v);
                head = node;
            } else {
                node.next = new ListNode(v);
                node = node.next;
            }
        }
        head = partition(head, m);
        if (head != null) {
            System.out.print(head.val);
            head = head.next;
            while (head != null) {
                System.out.print(",");
                System.out.print(head.val);
                head = head.next;
            }
        }
        System.out.println();
    }
}
