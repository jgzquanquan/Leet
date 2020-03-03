import java.util.*;

/**
 * @author jgz
 * @Date 2020-02-19 16:13
 */

//使用排序加map O(nKlog(K))
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List> map = new HashMap<>();
        for (String s:strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            if (!map.containsKey(key)) map.put(key,new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }

//使用count计数 复杂度O(nK),但实际运行测试速度还排序加map快，主要因为构建这个要26位数组，还要拼成字符串
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String,List> map = new HashMap<>();
        int[] arr = new int[26];
        for (String s:strs){
            Arrays.fill(arr,0);
            for (int i=0;i<s.length();i++) arr[s.charAt(i)-'a']++;
            StringBuilder sb = new StringBuilder();
            for (int i: arr) {
                sb.append('#');
                sb.append(i);
            }
            String key = sb.toString();
            if (!map.containsKey(key)) map.put(key,new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }

    public static void main(String[] args) {
        String[]strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        new GroupAnagrams().groupAnagrams(strings);
    }
}
