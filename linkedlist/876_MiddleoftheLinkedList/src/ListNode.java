import jdk.nashorn.internal.runtime.regexp.joni.SearchAlgorithm;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

class Solution2 {
    public ListNode middleNode(ListNode head) {
        ListNode listNode[] = new ListNode[100];
        int i = 0;
        ListNode cur = head;
        while (cur != null){
            listNode[i] = cur;
            cur = cur.next;
            i++;
    }
        return listNode[i/2];
}

}
