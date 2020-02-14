/**
 * @author jgz
 * @Date 2020-02-14 17:55
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m];
        System.arraycopy(nums1,0,nums3,0,m);
        int i=0,j=0,k=0;
        for (;i<m && j<n;){
            if (nums3[i]<nums2[j])
                nums1[k++]=nums3[i++];
            else
                nums1[k++]=nums2[j++];
        }
        while (i<m) nums1[k++]=nums3[i++];
        while (j<n) nums1[k++]=nums2[j++];
    }

}
