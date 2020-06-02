/**
 * @author jgz
 * @Date 2020-03-25 11:07
 */
public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int bitMask = 0;
        for (int num : nums){
            bitMask ^= num;
        }
        int diff = bitMask & (-bitMask);
        int[] res = new int[2];
        for (int num : nums){
            if ((num & diff) == 0) res[0] ^= num;
            else res[1] ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        new SingleNumbers().singleNumbers(new int[]{4, 1, 4, 6});
    }
}
