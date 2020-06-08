/**
 * @author jgz
 * @Date 2020-06-07 16:48
 */
public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        return merge(lists, 0, lists.length-1);
    }

    private  ListNode merge(ListNode[] lists, int l, int r) {
        if (l==r){
            return lists[l];
        }
        int mid = (l+r) >> 1;
        ListNode left = merge(lists, l, mid);
        ListNode right = merge(lists, mid+1, r);
        return mergeTwoList(left, right);
    }

    private  ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode solider = new ListNode(0);
        ListNode pre = solider;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                pre.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                pre.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if (l1 != null){
            pre.next = l1;
        }

        if (l2 != null){
            pre.next = l2;
        }
        return solider.next;
    }


}
