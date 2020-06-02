import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author jgz
 * @Date 2020-05-19 19:56
 */
public class Solution1 {
    public String sum (ArrayList<String> numbers) {
        // write code here
        BigInteger res = new BigInteger("0");
        for (String num : numbers){
            res.add(new BigInteger(num));
        }
        return res.toString();
    }

    public static void main(String[] args) {

    }
}
