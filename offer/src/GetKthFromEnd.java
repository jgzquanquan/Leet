import java.util.List;

/**
 * @author jgz
 * @Date 2020-03-06 22:20
 */
public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int size = 0;
        ListNode cur = head;
        while (cur != null){
            size ++;
            cur = cur.next;
        }
        int offset = size - k;
        cur = head;
        for (int i=0; i<offset; i++){
            cur = cur.next;
        }
        return cur;
    }

    public ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i=0; i<k; i++){
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
