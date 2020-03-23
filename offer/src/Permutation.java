import java.util.*;

/**
 * @author jgz
 * @Date 2020-03-16 15:37
 */
public class Permutation {
    Set<String> set = new HashSet<>();
    public String[] permutation(String s) {
        if (s.length() == 0) return new String[0];
        boolean[] visted = new boolean[s.length()];
        generate(s, "", visted);
        return set.toArray(new String[set.size()]);
    }

    private void generate(String s, String newS, boolean[] visted) {
        if (s.length() == newS.length()){
            set.add(newS);
        }

        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (visted[i]) continue;
            visted[i] = true;
            generate(s, newS + c, visted);
            visted[i] = false;
        }
    }

    public String[] permutation1(String s) {
        if (s.length() == 0) return new String[0];
        List<String> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] visted = new boolean[s.length()];
        backTrace(list, chars, new ArrayList<Character>(), visted);
        return list.toArray(new String[list.size()]);
    }

    private void backTrace(List<String> list, char[] s, List<Character> tempList, boolean[] visted) {
        if (s.length == tempList.size()){
            StringBuilder sb = new StringBuilder();
            for (char c : tempList){
                sb.append(c);
            }
            list.add(sb.toString());
            return;
        }
        for (int i=0; i<s.length; i++){
            if (visted[i] || i>0 && s[i] == s[i-1] && !visted[i-1]){
                continue;
            }
            tempList.add(s[i]);
            visted[i] = true;
            backTrace(list, s, tempList, visted);
            visted[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }


}
