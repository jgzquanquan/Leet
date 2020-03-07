import java.util.List;

/**
 * @author jgz
 * @Date 2020-03-06 11:20
 */
public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode solider = new ListNode('0');
        solider.next = head;
        ListNode pre = solider;
        ListNode cur = head;
        while (pre.next!=null && cur.next!=null){
            while (cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            if (pre.next == cur){
                pre = pre.next;
            }else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return solider.next;
    }
}
