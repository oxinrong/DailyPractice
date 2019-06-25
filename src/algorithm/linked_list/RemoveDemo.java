package algorithm.linked_list;

/*
    实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。
    思路：复制后一个结点的值给当前结点，并将后一个结点删除
    问题：复制时可能存在问题（非整型结点情况）、简单复制会影响外部依赖、尾结点处理问题等。
    没有较好的解决方法。

    下题则为简单删除：
    给定带删除的头节点和要删除的数字，请执行删除操作，
    返回删除后的头结点。链表中没有重复数字
 */

public class RemoveDemo {
    public ListNode removeNode(ListNode pNode, int delVal) {
        if (pNode == null) return null;
        if (pNode.val == delVal) return pNode.next;

        ListNode pre = pNode;
        ListNode cur = pNode.next;
        while (cur != null) {
            if (cur.val == delVal) {
                pre.next = cur.next;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return pNode;
    }
}
