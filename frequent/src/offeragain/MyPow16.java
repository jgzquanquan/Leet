package offeragain;

/**
 * @author jgz
 * @Date 2020-06-03 12:03
 */
public class MyPow16 {
    public double myPow(double x, int n) {
        Long N = Long.valueOf(n);
        if (N < 0){
            N = -N;
            x = 1 / x;
        }

        double cur = x;
        double res = 1;
        while (N > 0){
            if (N % 2 == 1){
                res *= cur;
            }
            cur = cur * cur;
            N = N >> 1;
        }
        return res;
    }
}
