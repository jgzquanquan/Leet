package dfsAndbfs;

import java.util.*;

/**
 * @author jgz
 * @Date 2020-06-07 09:51
 */
public class WordLadderII {

    class Node {
        String word;
        int distance;
        List<String> path;
        Node(String word, int distance, List<String> path) {
            this.word = word;
            this.distance = distance;
            this.path = path;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Map<String,List<String>> map = new HashMap<>();
        for (String word : wordList){
            for (int i=0; i<word.length(); i++){
                String cur = word.substring(0,i) + "*" + word.substring(i+1, word.length());
                List<String> transformation = map.getOrDefault(cur, new ArrayList<>());
                transformation.add(word);
                map.put(cur, transformation);
            }
        }
        List<List<String>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        Map<String,Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        List<String> temp = new ArrayList<>();
        temp.add(beginWord);
        queue.add(new Node(beginWord,1, temp));
        List<String> curList = new ArrayList<>();
        int minLen = -1;
        int level = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            level++;
            for (int i=0; i<size; i++){
                Node node = queue.remove();
                String cur = node.word;
                if (minLen != -1 && node.distance > minLen){
                    continue;
                }
                if (node.word.equals(endWord)){
                    if (minLen == -1){
                        minLen = node.distance;
                    }
                    res.add(node.path);
                    continue;
                }
                for (int j=0; j<cur.length(); j++){
                    String reg = cur.substring(0,j) + "*" + cur.substring(j+1, cur.length());
                    for (String word : map.getOrDefault(reg, new ArrayList<>())){
                        if (visited.containsKey(word)){
                            continue;
                        }
                        List<String> newPath = new ArrayList<>(node.path);
                        newPath.add(word);
                        visited.put(word, true);
                        queue.add(new Node(word, node.distance+1, newPath));
                    }

                }
            }
        }
        return res;

    }
}
