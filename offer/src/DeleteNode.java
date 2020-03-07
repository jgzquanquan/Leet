/**
 * @author jgz
 * @Date 2020-03-05 12:36
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = head;
        while( cur != null && cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return pre.next;
    }
}
