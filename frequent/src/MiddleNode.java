/**
 * @author jgz
 * @Date 2020-03-23 09:04
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        int size = 0;
        while (pre.next != null){
            size++;
            pre = pre.next;
        }
        int k = size / 2;
        while (k > 0){
            head = head.next;
            k--;
        }
        return head;
    }

//快慢指针法
    public ListNode middleNode1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
