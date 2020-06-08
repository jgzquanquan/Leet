/**
 * @author jgz
 * @Date 2020-04-03 20:23
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Result {
    /*
     * Complete the 'rollTheString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER_ARRAY roll
     */

    public static String rollTheString1(String s, List<Integer> roll) {
        // Write your code her
        for (Integer num : roll){
            s = roll(s,num);
        }
        return s;
    }
    public static String rollTheString(String s, List<Integer> roll) {
        // Write your code her
        int[] nums = new int[s.length()];
        for (Integer n : roll){
            for (int i=0; i<n; i++){
                nums[i]++;
            }
        }
        return roll1(s, nums);
    }

    private static String roll1(String s, int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<nums.length; i++){
            if (nums[i] == 0) {
                sb.append(s.charAt(i));
                continue;
            }
            nums[i] = (nums[i] % 26);
            char c = (char) (s.charAt(i) + nums[i]);
            if (c > 'z'){
                c -= 26;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    private static String roll(String s, Integer num) {
        if (s.length() < num)
            num = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<num; i++){
            char c = s.charAt(i);
            if (c - 'z' == 0)
                c = 'a';
            else
                c = (char) ((c - 'a' + 1) + 'a');
            sb.append(c);
        }

        for(int i = num; i<s.length(); i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = rollTheString("abz", Arrays.asList(new Integer[]{3,2,1}));
        System.out.println(s);
    }


}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int rollCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> roll = IntStream.range(0, rollCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        String result = Result.rollTheString(s, roll);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}

