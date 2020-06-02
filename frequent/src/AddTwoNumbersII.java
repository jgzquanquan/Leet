import java.util.List;
import java.util.Stack;

/**
 * @author jgz
 * @Date 2020-04-14 10:07
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode pre = null;
        int flag = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || flag != 0){
            int a = s1.isEmpty() ? 0 : s1.pop();
            int b = s2.isEmpty() ? 0 : s2.pop();
            int sum = a + b + flag;
            flag = sum / 10;
            ListNode cur = new ListNode(sum % 10);
            cur.next = pre;
            pre = cur;
        }
        return pre;
    }
}
