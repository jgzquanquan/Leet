/**
 * @author jgz
 * @Date 2020-03-20 11:40
 */
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[1690];
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        ugly[0] = 1;
        int min = 0;
        for (int i=1; i<n; i++){
            min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;
            if (factor2 == min){
                factor2 = 2*ugly[++index2];
            }
            if (factor3 == min){
                factor3 = 3*ugly[++index3];
            }
            if (factor5 == min){
                factor5 = 5*ugly[++index5];
            }
        }
        return ugly[n-1];
    }
}
