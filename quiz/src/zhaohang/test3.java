package zhaohang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author jgz
 * @Date 2020-04-29 09:58
 */
public class test3 {
    public static void main(String[] args) {
        boolean show_debug = false;
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        List<Integer> heights = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            int temp = scan.nextInt();
            heights.add(temp);
        }
        Collections.sort(heights, Collections.reverseOrder());

        int ptr_head = k-1;
        int ptr_end = n-k;
        if(show_debug) {
            System.out.println(heights);
            System.out.println(ptr_head);
            System.out.println(ptr_end);
        }
        int step_head=0;
        int step_end=0;
        int k_head =0, k_end=0;
        for(int i=ptr_head+1;i<n;i++){
            if(heights.get(i)==heights.get(ptr_head)){
                k_head++;
            }
        }
        for(int i=ptr_end-1;i>=0;i--){
            if(heights.get(i)==heights.get(ptr_end)){
                k_end++;
            }
        }
        for(int i=0;i<=ptr_head;i++){
            step_head+=heights.get(i)-heights.get(ptr_head);
        }
        for(int i=n-1;i>=ptr_end;i--){
            step_end+=heights.get(ptr_end)-heights.get(i);
        }
        if(show_debug) {
            System.out.println(step_head);
            System.out.println(step_end);
        }
        System.out.println(Math.min(step_head-k_head, step_end-k_end));
    }
}
