import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//242
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for (int i=0; i<s.length();i++){
            Character tmp = s.charAt(i);
            map1.put(tmp,map1.getOrDefault(tmp,0) + 1);
        }
        for (int i=0; i<t.length();i++){
            Character tmp = t.charAt(i);
            map2.put(tmp,map2.getOrDefault(tmp,0) + 1);
        }
        return map1.equals(map2);
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length()!=t.length()) return false;
        int[] res = new int[26];
        for (int i=0;i<s.length();i++){
            res[s.charAt(i)-'a']++;
        }
        for (int i=0;i<t.length();i++){
            res[t.charAt(i)-'a']--;
            if (res[t.charAt(i)-'a'] < 0) return false;
        }
        return true;
    }

    //排序
    public boolean isAnagram2(String s, String t) {
        if(s.length()!=t.length()) return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr,tArr);
    }

    public static void main(String[] args) {
        new ValidAnagram().isAnagram1("a","b");
    }
}
