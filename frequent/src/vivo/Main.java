package vivo;

/**
 * @author jgz
 * @Date 2020-06-07 15:42
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<String> lines = new ArrayList<>();

        Scanner scanner = null;
        int n = scanner.nextInt();
        ListNode[] heads = new ListNode[n];
        int i=0;
        try {
            scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {

                // write your code here
                ListNode head = new ListNode(0);
                ListNode cur = head;
                String line = scanner.nextLine();
                String[] array = line.split(" ");
                for (int j = 0; j<array.length; j++){
                    cur.next = new ListNode(Integer.valueOf(array[j]));
                }
                heads[i++] = head.next;
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        // TODO output

    }

    static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    private static ListNode mergeNodes(ListNode[] lists ) {

        // write your code here
        if (lists == null || lists.length == 0){
            return null;
        }

        return merge(lists, 0, lists.length-1);
    }

    private static ListNode merge(ListNode[] lists, int l, int r) {
        if (l==r){
            return lists[l];
        }
        int mid = (l+r) >> 1;
        ListNode left = merge(lists, l, mid);
        ListNode right = merge(lists, mid+1, r);
        return mergeTwoList(left, right);
    }

    private static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode solider = new ListNode(0);
        ListNode pre = solider;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                pre.next = new ListNode(l1.val);
            } else {
                pre.next = new ListNode(l2.val);
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