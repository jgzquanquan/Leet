import java.util.HashMap;
import java.util.HashSet;

/**
 * @author jgz
 * @Date 2020-04-30 10:45
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)){
            set.add(n);
            n = sumQuare(n);
        }
        return n == 1;
    }

    private int sumQuare(int n) {
        int sum = 0;
        while (n > 0){
            int temp = n % 10;
            sum += temp * temp;
            n = n / 10;
        }
        return sum;
    }

    public boolean isHappy1(int n) {
        int slow = n;
        int fast = sumQuare(n);
        while (slow != fast){
            slow = sumQuare(slow);
            fast = sumQuare(fast);
            fast = sumQuare(fast);
        }
        return slow == 1;
    }

    public static void main(String[] args) {
        new HappyNumber().isHappy(19);
    }
}
