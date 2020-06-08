package offeragain;

/**
 * @author jgz
 * @Date 2020-06-03 11:58
 */
public class HammingWeight15 {
    public int hammingWeight(int n) {
        int conut = 0;
        for (int i=0; i<32; i++){
            if ((n&1) == 1){
                conut++;
            }
            n = n >> 1;
        }
        return conut;
    }
}
