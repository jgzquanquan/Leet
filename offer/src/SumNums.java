/**
 * @author jgz
 * @Date 2020-03-30 10:58
 */
public class SumNums {
    public int sumNums(int n) {
        int sum = n;
        boolean b =(n>0) && ((sum += sumNums(n-1))>0);
        return sum;
    }
}
