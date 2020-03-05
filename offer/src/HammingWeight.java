/**
 * @author jgz
 * @Date 2020-03-04 14:35
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        int cnt = 0;
        int mask = 1;
        for(int i=0; i<32; i++){
            if ((n & mask)!=0){
                cnt++;
            }
            mask <<= 1;
        }
        return cnt;
    }

    public int hammingWeight1(int n) {
        int cnt = 0;
        while (n != 0){
            cnt++;
            n = n & (n - 1);
        }
        return cnt;
    }
}
