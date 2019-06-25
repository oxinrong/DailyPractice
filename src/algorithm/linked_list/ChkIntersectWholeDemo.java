package algorithm.linked_list;

/*
    给定两个单链表的头节点 head1 和 head2，如何判断两个链表是否相交？相交的话返回 true，不想交的话返回 false。

    给定两个链表的头结点 head1 和 head2
    (注意，另外两个参数 adjust0 和 adjust1 用于调整数据，与本题求解无关)。
    请返回一个 bool 值代表它们是否相交。
 */

public class ChkIntersectWholeDemo {

    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        ListNode loopGate1 = chkLoop(head1);
        ListNode loopGate2 = chkLoop(head2);

        // 一个有环一个无环 不相交
        if ((loopGate1 != null && loopGate2 == null) || (loopGate1 == null && loopGate2 != null)) {
            return false;
        }

        // 都有环
        if (loopGate1 != null && loopGate2 != null) {
            return chkLoopInter(loopGate1, loopGate2);
        }

        return chkIntersect(head1, head2);
    }

    // 找环入口点
    public ListNode chkLoop(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode slowNode = head.next;
        ListNode fastNode = head.next.next;

        // 检验是否存在环
        while (fastNode != slowNode) {
            if (slowNode == null) return null;
            slowNode = slowNode.next;
            if (fastNode.next == null) return null;
            fastNode = fastNode.next.next;
        }

        // 两者再次相遇的地方即为环的入口
        fastNode = head;
        while (fastNode != slowNode) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }

        return slowNode;
    }

    // 判断环内是否相交
    public boolean chkLoopInter(ListNode head1, ListNode head2) {
        ListNode cur;
        if (head1 == head2) {
            // 环入口结点已相交
            return true;
        } else {
            // 找环内的结点
            cur = head1.next;
            while (cur != head1) {
                if (cur == head2) return true;
                cur = cur.next;
            }
        }
        return false;
    }

    // 无环判断是否相交
    public boolean chkIntersect(ListNode headA, ListNode headB) {
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
