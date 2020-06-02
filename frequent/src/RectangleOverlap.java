/**
 * @author jgz
 * @Date 2020-03-18 09:55
 */
public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] ||
                 rec1[0] >= rec2[2] ||
                 rec1[1] >= rec2[3] ||
                 rec1[3] <= rec2[1]);
    }
}
