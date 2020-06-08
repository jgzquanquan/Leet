package dfsAndbfs;

import java.util.*;

/**
 * @author jgz
 * @Date 2020-06-07 09:01
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String,List<String>> map = new HashMap<>();
        for (String word : wordList){
            for (int i=0; i<word.length(); i++){
                String cur = word.substring(0,i) + "*" + word.substring(i+1, word.length());
                List<String> transformation = map.getOrDefault(cur, new ArrayList<>());
                transformation.add(word);
                map.put(cur, transformation);
            }
        }

        Queue<String> queue = new LinkedList<>();
        Map<String,Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        queue.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            level++;
            for (int i=0; i<size; i++){
                String cur = queue.remove();
                for (int j=0; j<cur.length(); j++){
                    String reg = cur.substring(0,j) + "*" + cur.substring(j+1, cur.length());
                    for (String word : map.getOrDefault(reg, new ArrayList<>())){
                        if (word.equals(endWord)){
                            return level;
                        }

                        if (visited.containsKey(word)){
                            continue;
                        }

                        visited.put(word, true);
                        queue.add(word);
                    }
                }
            }
        }
        return 0;
    }
}
