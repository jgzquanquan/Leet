/**
 * @author jgz
 * @Date 2020-05-26 09:53
 */
public class FindtheDuplicateNumber {

    //二分查找法
    public int findDuplicate(int[] nums) {
        int l = 1, r = nums.length - 1;
        int cnt = 0, ans = -1;
        while (l <= r){
            int mid = (l+r) >> 1;
            cnt = 0;
            for (int i=0; i<nums.length; i++){
                if (nums[i] <= mid){
                    cnt++;
                }
            }
            if (cnt <= mid){
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    //使用位运算的方法
    public int findDuplicate1(int[] nums) {
        int ans = 0;
        int bitMax = 31;
        int n = nums.length - 1;
        while (((n) >> bitMax) == 0){
            bitMax -= 1;
        }
        for (int bit = 0; bit <= bitMax; bit++){
            int x = 0, y = 0;
            for (int i=0; i<=n; i++){
                if ((nums[i] & (1 << bit)) != 0){
                    x++;
                }

                if (i >= 1 && (i & (1 << bit)) != 0){
                    y++;
                }
            }
            if (x > y){
                ans += (1 << bit);
            }
        }
        return ans;
    }

    //快慢指针
    public int findDuplicate2(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        new FindtheDuplicateNumber().findDuplicate1(new int[]{1,3,4,2,2});
    }
}
