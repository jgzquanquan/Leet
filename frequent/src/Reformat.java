import java.util.ArrayList;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-04-19 10:33
 */
public class Reformat {
    public String reformat(String s) {
        char[] chars = s.toCharArray();
        List<Integer> numList = new ArrayList<>();
        List<Integer> charList = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] <= '9' && chars[i] >= '0') {
                numList.add(i);
            } else {
                charList.add(i);
            }
        }
        if ((numList.size() == charList.size() + 1) || (charList.size() == numList.size() + 1) || (numList.size() == charList.size())) {
            StringBuilder sb = new StringBuilder();
            if (numList.size() >= charList.size()) {
                for (int i = 0; i < charList.size(); i++) {
                    sb.append(chars[numList.get(i)]);
                    sb.append(chars[charList.get(i)]);
                }
                if (numList.size() > charList.size()){
                    sb.append(chars[numList.get(numList.size() - 1)]);
                }
            }else {
                for (int i = 0; i < numList.size(); i++) {
                    sb.append(chars[charList.get(i)]);
                    sb.append(chars[numList.get(i)]);
                }
                sb.append(chars[charList.get(charList.size() - 1)]);
            }
            return sb.toString();
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(new Reformat().reformat("covid2019"));
    }
}
