package bit;

/**
 * @author jgz
 * @Date 2020-04-28 12:49
 */
public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 0){
            return false;
        }
        //
        long x  = (long) n;
        // 判断最右一位是不是其本身，因为如果是2的幂次则一定是只有一个1
        return (x & (-x)) == x;
    }

    public boolean isPowerOfTwo1(int n) {
        if (n == 0){
            return false;
        }
        //
        long x  = (long) n;
        // 清除最后一位1判断结果是不是0，因为如果是2的幂次则一定是只有一个1
        return (x & (x - 1)) == 0;
    }
}
