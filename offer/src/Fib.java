import java.util.SortedMap;

/**
 * @author jgz
 * @Date 2020-03-01 23:00
 */
public class Fib {
    public int fib(int n) {
        if(n<=1) return n;
        Integer[] mem = new Integer[n+1];
        mem[0] = 0;
        mem[1] = 1;
        return helper(n,mem);
    }
    public int helper(int n, Integer[] mem){
        if(mem[n]!=null){
            return mem[n];
        }
        mem[n] = helper(n-1,mem) + helper(n-2,mem);
        return mem[n];
    }

    public static void main(String[] args) {
        new Fib().fib(3);
    }

}
