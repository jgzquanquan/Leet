import java.util.HashSet;
import java.util.Set;

/**
 * @author jgz
 * @Date 2019-12-11 19:43
 * 202
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        boolean tag = true;
        Set set = new HashSet();
        while (tag){
            int sum = 0;
            while (n!=0){
                sum = sum + (n%10)*(n%10);
                n=n/10;
            }
            if (set.contains(sum)) tag=false;
            set.add(sum);
            if (sum==1) break;
            n=sum;
        }
        return tag;
    }

    public static void main(String[] args) {
        new HappyNumber().isHappy(19);
    }

    public boolean isHappy2(int n) {
        boolean tag = true;
        int fast = n;
        int slow = n;
        while (tag){
            slow = suqareSum(slow);
            fast = suqareSum(suqareSum(fast));
            if (slow == 1) break;;
            if (fast==slow) tag=false;
        }
        return tag;
    }

    public int suqareSum(int n){
        int sum = 0;
        while (n>0){
            sum += (n%10)*(n%10);
            n = n/10;
        }
        return sum;
    }
}
