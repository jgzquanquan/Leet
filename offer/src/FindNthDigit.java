/**
 * @author jgz
 * @Date 2020-03-18 13:49
 */
public class FindNthDigit {
    public int findNthDigit(int n) {
        n -= 1;
        int first = 1;
        int digit = 1;
        while (n/first/digit/9 >= 1){
            n -= 9*first*digit;
            digit++;
            first *= 10;
        }
        return (first + n/digit + "").charAt(n%digit) - '0';
    }

    public static void main(String[] args) {
        new FindNthDigit().findNthDigit(1000);
    }
}
