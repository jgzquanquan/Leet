/**
 * @author jgz
 * @Date 2020-03-20 11:56
 */
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        int[] map = new int[128];
        for (char c : s.toCharArray()){
            map[c]++;
        }
        for (char c : s.toCharArray()){
            if (map[c] == 1){
                return c;
            }
        }
        return ' ';
    }
}
