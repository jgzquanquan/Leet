/**
 * @author jgz
 * @Date 2020-03-26 11:03
 */
public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++){
            sb.append(s.charAt((i+n)%s.length()));
        }
        return sb.toString();
    }
}
