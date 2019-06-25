package algorithm.linked_list;

/*
    现有两个升序链表，且链表中均无重复元素。请设计一个高效的算法，打印两个链表的公共值部分。

    给定两个链表的头指针 headA 和 headB，请返回一个 vector，元素为两个链表的公共部分。
    请保证返回数组的升序。两个链表的元素个数均小于等于 500。保证一定有公共值
 */

import java_base.gui.List;

import java.util.ArrayList;

public class CommonDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int[] arr1 = {2,4,6,8,10};

        ListNode head = new ListNode(arr[0]);
        ListNode tail = head;
        // 构建链表
        for (int i = 1; i < arr.length; i++) {
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }

        ListNode head1 = new ListNode(arr1[0]);
        ListNode tail1 = head1;
        // 构建链表
        for (int i = 1; i < arr1.length; i++) {
            tail1.next = new ListNode(arr1[i]);
            tail1 = tail1.next;
        }

        int[] res = new CommonDemo().findCommonParts(head, head1);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public int[] findCommonParts(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ArrayList<Integer> res = new ArrayList<>();

        while (headA != null && headB != null) {
            if (headA.val == headB.val) {
                res.add(headA.val);
                headA = headA.next;
                headB = headB.next;
            } else if (headA.val > headB.val){
                headB = headB.next;
            } else headA = headA.next;
        }

        int[] finalRes = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            finalRes[i] = res.get(i);
        }

        return finalRes;
    }
}
