package offeragain;

import java.util.List;

/**
 * @author jgz
 * @Date 2020-06-06 09:47
 */
public class DeleteNode18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode solider = new ListNode(0);
        solider.next = head;
        ListNode pre = solider;
        while (pre.next != null){
            if (pre.next.val == val){
                pre.next = pre.next.next;
                break;
            }
            pre = pre.next;
        }
        return solider.next;

    }
}
