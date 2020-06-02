package bit;

/**
 * @author jgz
 * @Date 2020-04-28 12:48
 */

//https://leetcode-cn.com/problems/number-of-1-bits/
public class Numberof1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        n ^= 0;
        while(n != 0){
            count++;
            //清除最右边是1的位；
            n = n & (n-1);
        }
        return count;
    }
}
