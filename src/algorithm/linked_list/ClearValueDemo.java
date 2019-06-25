package algorithm.linked_list;

/*
    现在有一个单链表。链表中每个节点保存一个整数，
    再给定一个值 val，把所有等于 val 的节点删掉。

    给定一个单链表的头结点 head，同时给定一个值 val，
    请返回清除后的链表的头结点，保证链表中有不等于该值的其它值。请保证其他元素的相对顺序。
 */

public class ClearValueDemo {

    public static void main(String[] args) {
        int[] arr = {2, 4, 2, 5, 2};
        int num = 2;
        ListNode head = new ListNode(arr[0]);
        ListNode tail = head;
        // 构建链表
        for (int i = 1; i < arr.length; i++) {
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }

        ListNode node = new ClearValueDemo().clear(head, num);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }


    public ListNode clear(ListNode head, int val) {
        ListNode cur = head;
        ListNode newHead = null, newTail = null;

        while (cur != null) {
            if (cur.val != val) {
                if (newHead == null) {
                    newHead = cur;
                    newTail = newHead;
                } else {
                    newTail.next = cur;
                    newTail = newTail.next;
                }
            }
            cur = cur.next;
        }

        if (newTail != null)
            newTail.next = null;
        return newHead;
    }
}
