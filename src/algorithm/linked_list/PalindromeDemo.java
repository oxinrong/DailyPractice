package algorithm.linked_list;

/*
    请编写一个函数，检查链表是否为回文。

    给定一个链表 ListNode* pHead，请返回一个 bool，代表链表是否为回文。
    测试样例：
    {1,2,3,2,1}
    返回：true
    {1,2,3,2,3}
    返回：false
 */

import java.util.Stack;

public class PalindromeDemo {

    public static void main(String[] args) {
        int[] arr = {1,1};
        ListNode head = new ListNode(arr[0]);
        ListNode tail = head;
        // 构建链表
        for (int i = 1; i < arr.length; i++) {
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }

        System.out.println(new PalindromeDemo().isPalindrome1(head));
    }

    // 一半入栈
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode fastCur = head;
        ListNode slowCur = head;
        int flag = 0;

        // 判断奇偶
        while (slowCur != null) {
            slowCur = slowCur.next;
            flag++;
        }

        slowCur = head;
        while (fastCur != null && fastCur.next != null) {
            stack.push(slowCur.val);
            slowCur = slowCur.next;
            fastCur = fastCur.next.next;
        }

        // 判断最中间是否入栈
        slowCur = flag % 2 == 0 ? slowCur : slowCur.next;

        while (slowCur != null) {
            if (slowCur.val != stack.pop())
                return false;
            slowCur = slowCur.next;
        }
        return true;
    }

    public boolean isPalindrome1(ListNode head) {
        ListNode cur = head;
        ListNode fastCur = head;
        ListNode slowCur = head;
        int flag = 0;

        // 判断奇偶
        while (cur != null) {
            cur = cur.next;
            flag++;
        }

        // slow 到达中部 fast 到达末尾
        while (fastCur != null && fastCur.next != null) {
            slowCur = slowCur.next;
            fastCur = fastCur.next.next;
        }

        ListNode pre = slowCur;
        ListNode next;
        // 若是奇数正中间那个则跳过比较
        slowCur = flag % 2 == 0 ? slowCur : slowCur.next;
        cur = slowCur;

        // 将链表后半截逆序指向中间
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        // 中间断开
        if (slowCur != null)
            slowCur.next = null;

        // 从两端开始往中间比较
        ListNode leftCur = head;
        ListNode rightCur = pre;

        // 判断是否回文
        while (leftCur != null && rightCur != null) {
            if (leftCur.val != rightCur.val) {
                return false;
            }
            leftCur = leftCur.next;
            rightCur = rightCur.next;
        }

        cur = pre;
        pre = null;
        // 恢复链表结构
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

        return true;
    }
}
