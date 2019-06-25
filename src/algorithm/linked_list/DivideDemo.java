package algorithm.linked_list;

/*
    对于一个链表，我们需要用一个特定阈值完成对它的分化，
    使得小于等于这个值的结点移到前面，
    大于该值的结点在后面，同时保证两类结点内部的位置关系不变。

    给定一个链表的头结点 head，同时给定阈值 val，
    请返回一个链表，使小于等于它的结点在前，大于等于它的在后，保证结点值不重复。
 */

public class DivideDemo {

    public static void main(String[] args) {
        int[] arr = {1,4,2,5};
        int num = 2;
        ListNode head = new ListNode(arr[0]);
        ListNode tail = head;
        // 构建链表
        for (int i = 1; i < arr.length; i++) {
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }

        ListNode node = new DivideDemo().listDivide0(head, num);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    // 题意要求解法 小于等于在前 大于在后
    public ListNode listDivide0(ListNode head, int val) {
        if (head == null || head.next == null) return head;

        // 为了保证 minHead 与 min 起始相同，先弄一个临时结点 0
        ListNode cur = head, min = new ListNode(0), minHead = min,
                max = new ListNode(0), maxHead = max;
        while(cur != null) {
            if (cur.val <= val) {
                min.next = cur;
                min = cur;
            } else {
                max.next = cur;
                max = cur;
            }
            cur = cur.next;
        }
        // 链接大小节点
        min.next = maxHead.next;
        max.next = null;

        head = minHead.next;

        return head;
    }

    // 类似荷兰国旗 小的前 等的中 大的后
    public ListNode listDivide1(ListNode head, int val) {
        if (head == null || head.next == null) return head;

        ListNode cur = head, pre,
                min = new ListNode(0), minHead = min,
                equal = new ListNode(0), equalHead = equal,
                max = new ListNode(0), maxHead = max;
        while(cur != null) {
            pre = cur;
            if (cur.val < val) {
                min.next = pre;
                min = pre;
            } else if (cur.val == val) {
                equal.next = pre;
                equal = pre;
            } else {
                max.next = pre;
                max = pre;
            }
            cur = cur.next;
        }
        min.next = null;
        equal.next = null;
        max.next = null;

        head = minHead.next;
        if (head == null) {
            head = equalHead.next;
            if (maxHead.next != null) {
                equal.next = maxHead.next;
            }
        } else {
            if (equalHead.next != null) {
                min.next = equalHead.next;
                if (maxHead.next != null) {
                    equal.next = maxHead.next;
                }
            } else if (maxHead.next != null) {
                min.next = maxHead.next;
            }
        }

        return head;
    }

    public ListNode listDivide(ListNode head, int pivot) {
        ListNode sH = null; // small head
        ListNode sT = null; // small tail
        ListNode bH = null; // big head
        ListNode bT = null; // big tail
        ListNode next = null; // save next node
        // every node distributed to three lists
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val <= pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            }else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        if (sT != null) {
            sT.next = bH;
        }
        return sH != null ? sH : bH;
    }
}
