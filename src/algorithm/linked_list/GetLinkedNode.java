package algorithm.linked_list;


public class GetLinkedNode {

    public static void main(String[] args) {
        int n = 2;
        ListNode listNode = new ListNode(0);

        for (int i = 1; i < 5; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }

        System.out.println(listNode.val);
        System.out.println(FindKthToTail(listNode, n));
    }

    public static ListNode FindKthToTail(ListNode head, int k) {
        ListNode p, q;
        p = q = head;
        int i = 0;
        for (; p != null; i++) {
            if (i >= k)
                q = q.next;
            p = p.next;
        }
        return i < k ? null : q;
    }
}
