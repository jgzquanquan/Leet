package offeragain;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-06-02 11:39
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class ReversePrint06 {
    public int[] reversePrint(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        int count = 0;
        while (cur != null){
            count++;
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        int[] res = new int[count];
        int  i = 0;
        while (pre != null){
            res[i++] = pre.val;
            pre = pre.next;
        }
        return res;

    }

    public int[] reversePrint1(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int i=0;
        while (!stack.isEmpty()){
            res[i++] = stack.pop();
        }

        return res;

    }
}
