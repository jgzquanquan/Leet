package mogan;

import java.util.*;

/**
 * @author jgz
 * @Date 2020-04-14 15:29
 */
public class Result1 {

    static Set<List<Integer>> res;
    static List<Integer> arrS;
    static int n;

    public static long maxInversions(List<Integer> arr) {
        // Write your code here
        arrS = arr;
        n = arr.size();
        res = new HashSet<>();
        helper(new ArrayList<Integer>(), 0);
        return res.size();



    }

    private static void helper(ArrayList<Integer> cur, int start) {
        if (cur.size() == 3){
            res.add(new ArrayList<Integer>(cur));
            return;
        }

        for (int i = start; i < arrS.size();i++){
            if (cur.size() == 0 || cur.get(cur.size() - 1) >= arrS.get(i)){
                cur.add(arrS.get(i));
                helper(cur, start+1);
                cur.remove(cur.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        maxInversions(Arrays.asList(new Integer[]{5,8,6,1,4,5}));
    }
}

