package algorithm.linked_list;
import java.util.ArrayList;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    public boolean hasNext () {
        return next != null;
    }

    public ListNode next() {
        return next;
    }
}

public class PrintList {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null) {
            return null;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        while (listNode != null) {
            arr.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arrReverse = new ArrayList<>();
        for (int i = arr.size() - 1; i >= 0; i--) {
            arrReverse.add(arr.get(i));
        }
        return arrReverse;
    }
}
