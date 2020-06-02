/**
 * @author jgz
 * @Date 2020-04-10 09:31
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strs = s.split(" ");

        for (int i= strs.length-1; i>=0; i--){
            if (!strs[i].equals("")){
                sb.append(strs[i]);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
