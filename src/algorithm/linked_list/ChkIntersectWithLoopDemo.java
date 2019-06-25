package algorithm.linked_list;

/*
    如何判断两个有环单链表是否相交？相交的话返回第一个相交的节点，不想交的话返回空。
    如果两个链表长度分别为 N 和 M，请做到时间复杂度 O (N+M)，额外空间复杂度 O (1)。

    给定两个链表的头结点 head1 和 head2
    (注意，另外两个参数 adjust0 和 adjust1 用于调整数据，与本题求解无关)。
    请返回一个 bool 值代表它们是否相交。
 */

public class ChkIntersectWithLoopDemo {

    public static void main(String[] args) {
        int[] arr = {1,1};
        ListNode head = new ListNode(arr[0]);
        ListNode tail = head;
        // 构建链表
        for (int i = 1; i < arr.length; i++) {
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }

        System.out.println(new ChkIntersectWithLoopDemo().chkInter(head, head.next, 0, 0));
    }

    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        if(head1 == null || head2 == null) return false;
        ListNode loopGate1 = chkLoop(head1, 0);
        ListNode loopGate2 = chkLoop(head2, 0);
        ListNode cur;
        if (loopGate1 == loopGate2) {
            // 环入口结点已相交
            return true;
        } else {
            // 找环内的结点
            cur = loopGate1.next;
            while (cur != loopGate1) {
                if (cur == loopGate2) return true;
                cur = cur.next;
            }
        }

        return false;
    }

    public ListNode chkLoop(ListNode head, int adjust) {
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

}
