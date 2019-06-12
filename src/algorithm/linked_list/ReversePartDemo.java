package algorithm.linked_list;

/*
    翻转链表中第 m 个节点到第 n 个节点的部分
    注意：m，n 满足 1 ≤ m ≤ n ≤ 链表长度
    例如：给出链表 1->2->3->4->5->null， m = 2 和 n = 4，返回 1->4->3->2->5->null
 */

import java.util.Random;

public class ReversePartDemo {
    public ListNode first = null;//头结点
    private int pos = 0;

    public ReversePartDemo() {
        this.first = null;
    }

    public static void main(String[] args) {
        ReversePartDemo linklist1 = new ReversePartDemo();
        ListNode head = new ListNode(0);
        for (int i = 0; i < 10; i++) {
            linklist1.addNode(new Random().nextInt(100));
        }
        head.next = linklist1.getFirstNode();
        linklist1.displayAllData();
        linklist1.reverse(head, 2, 6);
        linklist1.displayAllData();
    }

    // from开始翻转的位置，to翻转的最后一个位置
    public void reverse(ListNode head, int from, int to) {
        ListNode pCur = head.next;
        int i;
        //找到开始翻转的位置的前一个节点
        for (i = 0; i < from - 1; i++) {
            head = pCur;
            pCur = pCur.next;
        }
        ListNode pPre = pCur;
        pCur = pCur.next;
        to--;
        ListNode pNext;
        for (; i < to; i++) {
            pNext = pCur.next;
            pCur.next = head.next;
            head.next = pCur;
            pPre.next = pNext;
            pCur = pNext;
        }
    }

    public void addNode(int data) {
        ListNode node = new ListNode(data);
        if (first == null) {
            first = node;
            return;
        }
        ListNode temp = first;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void displayAllData() {
        ListNode current = first;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public ListNode getFirstNode() {
        if (first != null)
            return first;
        else
            return null;
    }
}
