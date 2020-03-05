/**
 * @author jgz
 * @Date 2020-03-05 09:33
 */
public class DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int i = 0;
        while (candies != 0){
            res[i%num_people] += Math.min(candies, i+1);
            candies -= Math.min(candies, i+1);
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        new DistributeCandiesToPeople().distributeCandies(7,4);
    }
}
