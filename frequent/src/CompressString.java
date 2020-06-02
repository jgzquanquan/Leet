/**
 * @author jgz
 * @Date 2020-03-16 08:36
 */
public class CompressString {
    public String compressString(String S) {
        if (S.length() == 0 || S == null) return "";
        StringBuilder sb = new StringBuilder();
        int num = 1;
        for (int i=1; i<S.length(); i++){
            if (S.charAt(i) != S.charAt(i-1)){
                sb.append(S.charAt(i-1));
                sb.append(num);
                num = 1;
            }else {
                num ++;
            }
        }
        sb.append(S.charAt(S.length()-1));
        sb.append(num);
        String compress = sb.toString();
        return compress.length() < S.length() ? compress : S;
    }
}
