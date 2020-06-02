/**
 * @author jgz
 * @Date 2020-04-19 10:08
 */
public class CountTheRepetitions {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int count1 = 0, count2 = 0, i = 0, j = 0;
        while (count1 < n1){
            if (chars1[i] == chars2[j]){
                j++;
                if (j == chars2.length){
                    j = 0;
                    count2++;
                }
            }
            i++;
            if (i == chars1.length){
                i = 0;
                count1++;
            }
        }
        return count2 / n2;
    }
}
