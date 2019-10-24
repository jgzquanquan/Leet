import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && slow != null && fast.next!=null ){
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)){
                return true;
            }
        }
        return false;
    }
}
class Solution2{
    public boolean hasCycle(ListNode head) {
        ListNode cur = head;
        Set<ListNode> listNodes = new HashSet<>();
        while (cur != null){
            if (listNodes.contains(cur)){
                return true;
            }
            listNodes.add(cur);
            cur = cur.next;
        }
        return false;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
