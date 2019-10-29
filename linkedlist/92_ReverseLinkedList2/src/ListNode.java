
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x){ val = x; }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //首先判断边界情况即，head本身就是null，m和n相等时则直接不需要交换
        if (head == null || m >= n || m < 1 || n < 1){
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        //注意我们要引入两个额外指针，分别称为 tail 和 con。tail 指针指向从链表头起的第m个结点，此结点是反转后链表的尾部，故称为 tail。
        // con 指针指向第 m 个结点的前一个结点，此结点是新链表的头部。
        ListNode con = null;
        ListNode tail = null;
        int i = 1;
        while (cur != null){
            if (i < m || i > n){
                pre = cur;
                cur = cur.next;
                i++;
            }else {
                if (i == m){
                    con = pre;
                    tail = cur;
                }
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
                if (i == n){
                    //这里如果con是null则说明m是从1 开始。那么第一个相当于是从head开始反转，此时只需要head等于目前的pre节点即可
                    if (con != null){
                        con.next = pre;
                    }else {
                        head = pre;
                    }
                    tail.next = cur;
                    break;
                }
                i++;
            }
        }
        return head;
    }
}


