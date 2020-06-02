import java.util.Arrays;

/**
 * @author jgz
 * @Date 2020-03-26 10:35
 */
public class ReverseWords {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i=strings.length-1; i>=0; i--){
            if (strings[i].equals("")) continue;
            sb.append(strings[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        new ReverseWords().reverseWords("a good   example");
    }
}
