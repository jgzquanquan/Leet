import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jgz
 * @Date 2020-05-17 10:02
 */
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int count = 0;

        int[] indeg = new int[numCourses];
        for (int[] p : prerequisites){
            indeg[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<numCourses; i++){
            if (indeg[i] == 0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            int cur = queue.poll();
            res[count++] = cur;
            for (int[] p : prerequisites){
                if (p[1] == cur){
                    indeg[p[0]]--;
                    if (indeg[p[0]] == 0){
                        queue.offer(p[0]);
                    }
                }

            }
        }
        return count == numCourses ? res : new int[0];
    }
}
