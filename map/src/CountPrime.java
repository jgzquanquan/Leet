import java.util.Arrays;

/**
 * @author jgz
 * @Date 2019-12-11 20:27
 * 204
 */
public class CountPrime {
    public int countPrimes(int n) {
        if (n<3) return 0;
        int count = 1;
        for (int i=3;i<n;i++){
            if (i%2==0) continue;
            boolean sign = true;
            for (int j=3;j*j<=i;j+=2){
                if (i%j==0){
                    sign=false;
                    break;
                }
            }
            if (sign) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CountPrime().countPrimes(10));
    }

    public int countPrimes2(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes,true);
        int count = 0;
        for (int i=2;i<n;i++){
            if (primes[i]){
                count++;
                for (int j=i+i;j<n;j=j+i){
                    primes[j]=false;
                }
            }
        }

        return count;
    }

}
