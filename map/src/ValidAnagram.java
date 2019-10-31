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
}
