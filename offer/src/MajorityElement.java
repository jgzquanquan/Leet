/**
 * @author jgz
 * @Date 2020-03-17 10:07
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int cur = -1;
        int count = 0;
        for (int num : nums){
            if (count == 0){
                cur = num;
            }
            count += (cur == num) ? 1 : -1;
        }
        return cur;
    }
}
