package offeragain;

/**
 * @author jgz
 * @Date 2020-06-02 11:13
 */
public class ReplaceSpace05 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == ' '){
                sb.append("%20");
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new ReplaceSpace05().replaceSpace("     ");
    }
}
