/**
 * @author jgz
 * @Date 2020-02-26 18:16
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c:s.toCharArray()){
            if (c==' ') sb.append("%20");
            else sb.append(c);
        }
        return sb.toString();
    }

    public String replaceSpace1(String s) {
        char[]res = new char[s.length()*3];
        int size = 0;
        for (char c:s.toCharArray()){
            if (c==' ') {
                res[size++]='%';
                res[size++]='2';
                res[size++]='0';
            }else{
                res[size++]=c;
            }
        }
        return new String(res,0,size);
    }
}
