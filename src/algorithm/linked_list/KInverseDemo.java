package algorithm.linked_list;

/*
    有一个单链表，请设计一个算法，使得每 K 个节点之间逆序，
    如果最后不够 K 个节点一组，则不调整最后几个节点。
    例如链表 1->2->3->4->5->6->7->8->null，K=3 这个例子。
    调整后为，3->2->1->6->5->4->7->8->null。
    因为 K==3，所以每三个节点之间逆序，但其中的 7，8 不调整，因为只有两个节点不够一组。

    给定一个单链表的头指针 head, 同时给定 K 值，返回逆序后的链表的头指针。
 */

public class KInverseDemo {

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 3};
        int num = 2;
        ListNode head = new ListNode(arr[0]);
        ListNode tail = head;
        // 构建链表
        for (int i = 1; i < arr.length; i++) {
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }

        ListNode node = new KInverseDemo().inverse1(head, num);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    /*
    利用递归，不需要任何辅助数据结构，不改变数据值，使用变更链表 next 指针的方式。
    1、编写递归反转链表方法，此方法在达到链表末时返回 null，然后获取下一个递归中反转后被反转的节点，
       如果这个节点没到达末尾，则将其 next 指针指向当前节点。
    2、编写 k 长度节点翻转方法，此方法首先遍历当前节点之后的剩余链表部分，若遍历到末尾或遍历到第 k 个则停止，
       然后递归调用翻转方法得到第 k + 1 个节点（若是末尾节点则返回 null）翻转之后的头节点 u。
    3、然后判断当前链表头到末尾是否足够 k 个节点：
       如果足够 k 个节点则将这 k 个节点用方法 1 中的递归法翻转，然后将翻转后的链表头尾翻转即可；
       若不足够 k 个节点，则此次递归传如的链表头就是要返回的链表头，链表尾则是先前遍历过的链表尾
    4、然后根据前三步得到的本次递归的链表尾指向 u，再返回链表头即可。
    */
    public ListNode inverse(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        //此时 cur 为第 k + 1 个节点
        if (count == k) {
            cur = inverse(cur, k);
            while (count-- > 0) {
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            //cur为翻转后的第一个节点
            head = cur;
        }
        return head;
    }

    // 正常解法
    public ListNode inverse1(ListNode head, int k) {
        if (k < 2) {
            return head;
        }
        //当前位置
        ListNode cur = head;
        //开始位置
        ListNode start = null;
        //开始的前一个
        ListNode pre = null;
        //end 的后一个
        ListNode next = null;
        int count = 1;
        while (cur != null) {
            //获取当前的下一个
            next = cur.next;
            //如果 count 为 k 执行逆序操作
            if (count == k) {
                //判断 pre 是否为空，为空 start = head 不为空 start = pre 的下一个节点
                start = pre == null ? head : pre.next;
                //判断 pre 是否为空 为空 head 变为当前节点(逆序后当前 cur 为 head 了) 不为空 head = head 只进行一次判断
                head = pre == null ? cur : head;
                //传入前一个节点(起到连接的作用) 首节点 当前节点，当前节点的下一个节点
                resign(pre, start, cur, next);
                pre = start; //start (第一个值赋给 pre )
                count = 0;
            }
            count++;
            cur = next;
        }
        return head;
    }

    // 部分逆序
    public void resign(ListNode left, ListNode start, ListNode end, ListNode right) {
        ListNode pre = start;
        ListNode cur = start.next;
        ListNode next;
        //逆序开始
        //保留首节点 pre cur ( pre 下一个节点 要转换的 即 cur.next = pre ) 和 next 节点
        while (cur != right) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //如果不是空
        if (left != null) {
            left.next = end;
        }
        start.next = right; //可以是 right 或者 next
    }
}
