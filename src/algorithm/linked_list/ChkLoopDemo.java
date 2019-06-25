package algorithm.linked_list;

/*
    如何判断一个单链表是否有环？
    有环的话返回进入环的第一个节点的值，无环的话返回 - 1。
    如果链表的长度为 N，请做到时间复杂度 O (N)，额外空间复杂度 O (1)。

    给定一个单链表的头结点 head（注意另一个参数 adjust 为加密后的数据调整参数，方
    便数据设置，与本题求解无关)，请返回所求值。
 */

public class ChkLoopDemo {

    public static void main(String[] args) {
        int[] arr = {1,1};
        ListNode head = new ListNode(arr[0]);
        ListNode tail = head;
        // 构建链表
        for (int i = 1; i < arr.length; i++) {
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }

        System.out.println(new ChkLoopDemo().chkLoop(head, 0));
    }

    public int chkLoop(ListNode head, int adjust) {
        if(head == null || head.next == null) return -1;

        ListNode slowNode = head.next;
        ListNode fastNode = head.next.next;

        // 检验是否存在环
        while (fastNode != slowNode) {
            if (slowNode == null) return -1;
            slowNode = slowNode.next;
            if (fastNode.next == null) return -1;
            fastNode = fastNode.next.next;
        }

        // 两者再次相遇的地方即为环的入口
        fastNode = head;
        while (fastNode != slowNode) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }

        return slowNode.val;
    }
}
