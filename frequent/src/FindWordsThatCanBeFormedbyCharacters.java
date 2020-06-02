import java.util.Arrays;

/**
 * @author jgz
 * @Date 2020-03-17 09:17
 */
public class FindWordsThatCanBeFormedbyCharacters {
    public int countCharacters(String[] words, String chars) {
        int wordLength = 0;
        int[] chs = new int[26];
        for (char c : chars.toCharArray()){
            chs[c-'a']++;
        }

        for (String word : words){
            int[] chCopy = Arrays.copyOf(chs, chs.length);
            boolean flag = true;
            for (char c : word.toCharArray()){
                if (--chCopy[c-'a'] < 0){
                    flag = false;
                    break;
                }
            }
            if (flag){
                wordLength += word.length();
            }
        }
        return wordLength;
    }
}
