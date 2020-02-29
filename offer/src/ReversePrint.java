import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author jgz
 * @Date 2020-02-28 09:25
 */


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

public class ReversePrint {

// 借助栈 时间O(N)  空间O(N)
    public int[] reversePrint(ListNode head) {
        if (head==null) return new int[0];
        Stack<Integer> stack = new Stack<>();
        while (head!=null){
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()){
            res[i++] = stack.pop();
        }
        return res;
    }

//   递归解法 时间O(N) 空间O(N)
    public int[] reversePrint1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        reversePrint(head,list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void reversePrint(ListNode head, List<Integer> list) {
        if (head == null) return;
        if (head.next != null) reversePrint(head.next,list);
        list.add(head.val);
    }
}
