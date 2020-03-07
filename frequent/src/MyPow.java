/**
 * @author jgz
 * @Date 2020-03-05 11:26
 */
public class MyPow {
//   暴力法
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0){
            x = 1/x;
            N = -N;
        }
        double ans = 1;
        for (long i=0; i<N; i++){
            ans *= x;
        }
        return ans;
    }

    public double myPow1(double x, int n) {
        long N = n;
        if (N < 0){
            x = 1/x;
            N = -N;
        }
        double ans = 1;
        double cur = x;
        for (long i=N; i>0; i/=2){
            if (i % 2 == 1){
                ans = ans * cur;
            }
            cur = cur * cur;
        }
        return ans;
    }
}
