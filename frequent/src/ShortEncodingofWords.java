import java.util.*;

/**
 * @author jgz
 * @Date 2020-03-28 09:20
 */

class TrieNode{
    HashMap<Character, TrieNode> next = new HashMap<>();
    int depth;
}

public class ShortEncodingofWords {
//  Set解法
    public int minimumLengthEncoding(String[] words) {
        Set<String> stringSet = new HashSet<>(Arrays.asList(words));
        for (String word : words){
            for (int i=1; i<word.length(); i++){
                stringSet.remove(word.substring(i));
            }
        }
        int ans = 0;
        for (String s : stringSet){
            ans += s.length() + 1;
        }
        return ans;
    }

//    字典树解法
    public int minimumLengthEncoding1(String[] words) {
        TrieNode root = new TrieNode();
        Set<String> stringSet = new HashSet<>(Arrays.asList(words));
        List<TrieNode> leaves = new ArrayList<>();
        for (String word : stringSet){
            TrieNode cur = root;
            for (int i=word.length()-1; i>=0; i--){
                char j = word.charAt(i);
                if (!cur.next.containsKey(j)) cur.next.put(j, new TrieNode());
                cur = cur.next.get(j);
            }
            cur.depth = word.length()+1;
            leaves.add(cur);
        }

        int ans = 0;
        for (TrieNode leave : leaves){
            if (leave.next.isEmpty())
                ans += leave.depth;
        }
        return ans;
    }

}


