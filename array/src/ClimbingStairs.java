/**
 * 1.当题目没思路的时候试试暴力法
 * 2.找重复子单元
 *
 * 70
 * @author jgz
 * @Date 2020-02-13 22:47
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n<=2) return n;
        int f1=1,f2=2,f3=3;
        for (int i=3;i<=n;i++){
            f3 = f1+f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

//   动态规划
    public int climbStairs1(int n) {
        if(n<=2) return n;
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    //   动态规划
    public int climbStairs3(int n) {
        int[]mem = new int[n+1];
        return recur(0,n,mem);
    }

    private int recur(int i, int n, int[] mem) {
        if (i>n){
            return 0;
        }
        if (i==n){
            return 1;
        }
        if (mem[i]>0){
            return mem[i];
        }
        mem[i] = recur(i+1,n,mem) + recur(i+2,n,mem);
        return mem[i];
    }
}
