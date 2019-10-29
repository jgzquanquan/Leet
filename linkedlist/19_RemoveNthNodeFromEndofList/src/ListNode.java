public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode solider = new ListNode(0);
        solider.next = head;
        ListNode first = head;
        int length = 0;
        while (first != null){
            first = first.next;
            length++;
        }
        length = length - n;
        first = solider;
        while (length != 0){
            first = first.next;
            length--;
        }
        first.next = first.next.next;
        return solider.next;
    }

}

class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode solider = new ListNode(0);
        solider.next = head;
        ListNode first = solider;
        ListNode second = solider;
        for (int i = 1; i <= n+1; i++){
            first = first.next;
        }
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return solider.next;
    }

}
