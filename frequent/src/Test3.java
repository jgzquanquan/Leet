import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-04-12 17:23
 */
public class Test3 {
    public int[] WaitInLine (int[] a, int[] b) {
        // write code here
        List<int[]> all = new ArrayList<>();
        int [] list = new int[a.length];
        for (int i=1; i<=a.length; i++){
            list[i-1] = i;
        }
        prem(list, all, 0);
        int[] minres = new int[a.length];
        for (int[] res : all){
            int min = Integer.MAX_VALUE;
            for (int i=0; i<res.length; i++){
                int  sum = a[res[i]-1] * (i+1-1) + b[res[i]-1]*(res.length-i-1);
                if (sum < min){
                    min = sum;
                    minres = res;
                }
            }
        }
        return minres;
    }

    private void prem(int[] list, List<int[]> all, int start) {
        if (start == list.length-1){
            int[] temp = new int[list.length];
            System.arraycopy(list,0,temp,0, list.length);
            all.add(temp);
        }else {
            for (int i=start; i<=list.length-1;i++){
                swap(list, start, i);
                prem(list, all, start+1);
                swap(list, start, i);
            }
        }
    }

    private void swap(int[] list, int start, int i) {
        int temp = list[start];
        list[start] = list[i];
        list[i] = temp;
    }

    class Node{
        int a;
        int b;
        int index;

        public Node(int a, int b, int index) {
            this.a = a;
            this.b = b;
            this.index = index;
        }
    }

    public int[] WaitInLine1 (int[] a, int[] b) {
        // write code here
        int[] res = new int[a.length];
        List<Node> list = new ArrayList<>();
        for (int i=0;i<a.length;i++){
            list.add(new Node(a[i],b[i],i+1));
        }
        Collections.sort(list, (o1, o2) -> (o2.a-o2.b) - (o1.a-o1.b));
        for (int i=0; i<list.size(); i++){
            res[i] = list.get(i).index;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Test3().WaitInLine1(new int[]{8,9,7},new int[]{5,8,3})));
    }


}
