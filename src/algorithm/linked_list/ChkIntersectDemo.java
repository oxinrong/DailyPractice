package algorithm.linked_list;

/*
    现在有两个无环单链表，若两个链表的长度分别为 m 和 n，
    请设计一个时间复杂度为 O (n + m)，额外空间复杂度为 O (1) 的算法，判断这两个链表是否相交。

    给定两个链表的头结点 headA 和 headB，请返回一个 bool 值，代表这两个链表是否相交。
    保证两个链表长度小于等于 500。
    * 1）一旦两个链表相交，那么两个链表中的节点一定有相同地址。
    （2）一旦两个链表相交，那么两个链表从相交节点开始到尾节点一定都是相同的节点。
    首先搞清楚什么叫两个链表相交，相交的意思是 从某个节点开始，两个链表的节点重合
    一直到结束。
    所有长链表的前面多出来的部分可以不用比较 直接遍历跳过
 */

public class ChkIntersectDemo {

    public static void main(String[] args) {
        int[] arr = {1,1};
        ListNode head = new ListNode(arr[0]);
        ListNode tail = head;
        // 构建链表
        for (int i = 1; i < arr.length; i++) {
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }

        System.out.println(new ChkIntersectDemo().chkIntersect(head.next, head));
    }

    public boolean chkIntersect(ListNode headA, ListNode headB) {
        int lengthA = 0, lengthB = 0;
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != null) {
            lengthA ++;
            curA = curA.next;
        }

        while (curB != null) {
            lengthB ++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;
        boolean flag = lengthA > lengthB;
        int steps = Math.abs(lengthA - lengthB);

        if (flag) {
            while (steps-- > 0) {
                curA = curA.next;
            }
        } else  {
            while (steps-- > 0) {
                curB = curB.next;
            }
        }

        while (curA != null) {
            if (curA == curB) {
                return true;
            }
            curA = curA.next;
            curB = curB.next;
        }

        return false;
    }

    // 解法二，可以直接判断最后两个指针是否相同
    public boolean chkIntersect1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return false;
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA.next != null) {
            curA = curA.next;
        }

        while (curB.next != null) {
            curB = curB.next;
        }

        return curA == curB;
    }
}
