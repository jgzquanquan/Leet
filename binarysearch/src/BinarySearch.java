/**
 * @author jgz
 * @Date 2019-11-26 19:36
 */
public class BinarySearch {

    public int bsearch(int[] a,int value){
        int low = 0;
        int high = a.length-1;
        while (low<=high){
            int mid = low + ((high-low)>>1);
            if (a[mid]==value){
                return mid;
            }else if (a[mid]<value){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        int[] a = new int[]{1,5,8,18,28,38,48,90,300};
        System.out.println(BinarySearch.class.newInstance().bsearch(a,90));
    }
}
