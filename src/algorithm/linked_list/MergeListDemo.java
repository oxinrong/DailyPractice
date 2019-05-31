package algorithm.linked_list;

/*
    输入两个单调递增的链表，输出两个链表合成后的链表，
    当然我们需要合成后的链表满足单调不减规则。

 */

public class MergeListDemo {

    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        ListNode node1 = new ListNode(1);

        ListNode node2 = Merge3(node, node1);

        System.out.println(node2.val);
        System.out.println(node2.next.val);
    }

    public static ListNode Merge2(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    public static ListNode Merge3(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        // 头结点
        ListNode dummy = new ListNode(-1);
        // 活动节点
        ListNode list = dummy;
        while(list1 != null && list2 != null) {
            if(list1.val > list2.val) {
                list.next = list2;
                list = list.next;
                list2 = list2.next;
            } else {
                list.next = list1;
                list = list.next;
                list1 = list1.next;
            }
        }
        while(list1 != null) {
            list.next = list1;
            list = list.next;
            list1 = list1.next;
        }
        while(list2 != null) {
            list.next = list2;
            list = list.next;
            list2 = list2.next;
        }
        // 抛弃头结点（-1）
        return dummy.next;
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode newNode = null;

        while (list1.next != null && list2.next != null) {
            if (list1.val <= list2.val) {
                newNode = list1;
                newNode = newNode.next;
                list1 = list1.next;
            } else {
                newNode = list2;
                newNode = newNode.next;
                list2 = list2.next;
            }
        }

        while (list1.next != null ) {
            newNode = list1;
            newNode = newNode.next;
            list1 = list1.next;
        }

        while (list2.next != null ) {
            newNode = list2;
            list2 = list2.next;
            newNode = newNode.next;
        }

        return newNode;
    }
}
