/**
 * @author jgz
 * @Date 2020-03-23 10:25
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA);
        int lenB = length(headB);
        while (lenA > lenB){
            lenA--;
            headA = headA.next;
        }

        while (lenA < lenB){
            lenB--;
            headB = headB.next;
        }

        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private int length(ListNode node){
        int len = 0;
        while (node != null){
            len++;
            node = node.next;
        }
        return len;
    }
}
