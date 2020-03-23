import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-03-19 11:56
 */
public class MinNumber {
    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums){
            list.add(String.valueOf(num));
        }
        list.sort((s1,s2) -> (s1+s2).compareTo(s2+s1));
        StringBuilder sb = new StringBuilder();
        for (String str : list){
            sb.append(str);
        }
        return sb.toString();
    }
}
