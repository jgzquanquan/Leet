/**
 * @author jgz
 * @Date 2020-05-09 09:28
 */
public class MySqrt {
    public int mySqrt(int x) {
        if (x == 0){
            return x;
        }
        double c = x, x0 = x;
        while (true){
            double x1 = 0.5 * (x0 + c/x0);
            if (Math.abs(x0 - x1) < 1e-7){
                break;
            }
            x0 = x1;
        }
        return (int)x0;
    }

    public int mySqrt1(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r){
            int mid = (l+r) >> 1;
            if ((long) mid * mid <= x){
                ans = mid;
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new MySqrt().mySqrt(4);
    }

}
