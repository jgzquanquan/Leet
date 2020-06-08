package offeragain;

/**
 * @author jgz
 * @Date 2020-06-06 09:38
 */
public class PrintNumbers17 {
    public int[] printNumbers(int n) {
        int max = (int) Math.pow(10,n);
        int[] res = new int[max];
        for (int i=1; i<=max; i++){
            res[i-1] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        new PrintNumbers17().printNumbers(1);
    }
}
