/**
 * @author jgz
 * @Date 2020-05-24 09:04
 */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1+len2;
        int[] res = new int[len];
        int i=0,j=0,k=0;
        while (i<len1 && j<len2){
            if (nums1[i] < nums2[j]){
                res[k++] = nums1[i++];
            } else {
                res[k++] = nums2[j++];
            }
        }
        while (i < len1){
            res[k++] = nums1[i++];
        }
        while (j < len2){
            res[k++] = nums2[j++];
        }

        if (len == 0){
            return 0.0;
        }

        if ((len & 1) == 1){
            return res[len/2];
        } else {
            return (res[len/2-1]+res[len/2])/2.0;
        }
    }
}
