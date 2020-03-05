import java.math.BigInteger;

/**
 * @author jgz
 * @Date 2020-03-04 11:34
 */
public class CuttingRope {
//   动态规划
    public int cuttingRope(int n) {
        if(n < 2) return 0;
        if (n <= 3) return n-1;
        int[]dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i=4; i<=n; i++){

            for (int j=1; j<=i/2; j++){
                dp[i] = Math.max(dp[i],dp[j]*dp[i-j]);
            }
        }
        return dp[n];
    }

//    贪心

    public int cuttingRope1(int n) {
        if(n < 2) return 0;
        if (n <= 3) return n-1;
        int a = n/3;
        int b = n%3;
        if (b == 0) return (int) Math.pow(3, a);
        else if (b == 1) return (int) (Math.pow(3, a-1) * 4);
        else return (int) (Math.pow(3, a) * 2);
    }


    public int cuttingRope2(int n) {
        if(n < 2) return 0;
        if (n <= 3) return n-1;
        BigInteger[]dp = new BigInteger[n+1];
        dp[1] = BigInteger.valueOf(1);
        dp[2] = BigInteger.valueOf(2);
        dp[3] = BigInteger.valueOf(3);
        for (int i=4; i<=n; i++){
            dp[i] = new BigInteger("0");
            for (int j=1; j<=i/2; j++){
                dp[i] = dp[i].max(dp[j].multiply(dp[i-j]));
            }
        }
        return dp[n].mod(new BigInteger("1000000007")).intValue();
    }

    public int cuttingRope3(int n) {
        if(n < 2) return 0;
        if (n <= 3) return n-1;
        int mod = 1000000007;
        long res = 1;
        while (n > 4){
            res = res * 3 % mod;
            n -= 3;
        }
        return (int) (res * n % mod);
    }



    public static void main(String[] args) {
        new CuttingRope().cuttingRope(10);
    }
}
