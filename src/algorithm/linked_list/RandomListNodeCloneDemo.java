package algorithm.linked_list;

/*
    输入一个复杂链表（每个节点中有节点值，
    以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。
 */

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class RandomListNodeCloneDemo {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        RandomListNode head = new RandomListNode(arr[0]);
        RandomListNode tail = head;
        // 构建链表
        for (int i = 1; i < arr.length; i++) {
            tail.next = new RandomListNode(arr[i]);
            tail = tail.next;
        }

        RandomListNode cur = head;
        cur.random = tail;
        while (cur.next != null) {
            cur.next.random = cur;
            cur = cur.next;
        }


        RandomListNode node = new RandomListNodeCloneDemo().Clone(head);
        while (node != null) {
            System.out.println(node.label);
            node = node.next;
        }
    }

    public RandomListNode Clone(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode cur = head;
        RandomListNode next;

        // 复制所有结点
        while (cur != null) {
            next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = next;
        }

        cur = head;
        RandomListNode copyCur;

        // 给复制的结点 random 指针赋值
        while (cur != null) {
            next = cur.next.next;
            copyCur = cur.next;
            copyCur.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }

        RandomListNode res = head.next;
        cur = head;

        // 将复制的链表与原链表分割
        while (cur != null) {
            next = cur.next.next;
            copyCur = cur.next;
            cur.next = next;
            copyCur.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }
}
