
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-05-19 19:56
 */
public class Solution1 {
    public String sum1 (ArrayList<String> numbers) {
        // write code here
        BigInteger res = new BigInteger("0");
        for (String num : numbers){
            res.add(new BigInteger(num));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayList<String> nums = new ArrayList<>();
        nums.add("20200201123456");
        nums.add("20200201123456789");
        nums.add("20200201123456789123456789");
        System.out.println(new Solution1().sum(nums));
    }

    public String sum (ArrayList<String> numbers) {
        // write code here
        if (numbers.size() == 0){
            return "0";
        }
        String res = numbers.get(0);
        for (int i =1; i<numbers.size(); i++){
            res = add(res, numbers.get(i));
        }
        return res;
    }

    public String add(String n1, String n2){
        StringBuilder res = new StringBuilder();
        n1 = new StringBuilder(n1).reverse().toString();
        n2 = new StringBuilder(n2).reverse().toString();
        int l1 = n1.length();
        int l2 = n2.length();
        int maxlen = l1 > l2 ? l1 : l2;
        int c = 0;
        if (l1 < l2){
            for (int i=l1;i<l2;i++){
                n1 += "0";
            }
        } else if (l1 > l2){
            for (int i=l2;i<l1;i++){
                n2 += "0";
            }
        }

        for (int i =0; i<maxlen;i++){
            int nsum = Integer.parseInt(n1.charAt(i) + "") + Integer.parseInt(n2.charAt(i) + "") + c;
            int ap = nsum % 10;
            res.append(ap);
            c = nsum / 10;
        }
        if (c > 0){
            res.append(c);
        }
        return res.reverse().toString();
    }

}
