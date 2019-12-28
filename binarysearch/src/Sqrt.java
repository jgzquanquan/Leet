/**
 * @author jgz
 * @Date 2019-11-26 20:34
 */

//69
public class Sqrt {
    public int mySqrt(int x) {
        long low = 0;
        long high = x/2+1;
        while (low < high){
            long mid = low + ((high-low)>>1);
            if (mid*mid>x){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return (int) low;
    }

    public static void main(String[] args) {
        new Sqrt().mySqrt(9);
    }
}
