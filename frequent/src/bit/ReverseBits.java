package bit;

/**
 * @author jgz
 * @Date 2020-04-28 14:20
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int res = 0;
        for (int i=0; i<32; i++){
            int cur = n & 1;
            res += cur << (31 - i);
            n = n >> 1;
        }
        return res;
    }
}
