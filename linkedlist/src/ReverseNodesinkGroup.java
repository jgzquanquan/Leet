import java.util.List;

/**
 * @author jgz
 * @Date 2020-02-15 22:59
 */
public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode solider = new ListNode(0);
        solider.next = head;
        ListNode pre = solider;
        ListNode end = solider;
        while (end.next != null){
            for (int i=0;i<k && end!=null;i++) end = end.next;
            if (end==null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return solider.next;
    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

