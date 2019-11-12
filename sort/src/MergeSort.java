public class MergeSort {
    public static void mergeSort(int[] a){
        mergeSortInternally(a,0,a.length-1);
    }

    private static void mergeSortInternally(int[] a,int p,int r){
        if (p>=r){
            return;
        }
        int q = p + (r-p)/2;
        mergeSortInternally(a,p,q);
        mergeSortInternally(a,q+1,r);
        merge(a,p,q,r);
    }

    private static void merge(int[] a,int p,int q,int r){
        int i = p;
        int j = q+1;
        int k = 0;
        int[] tmp = new int[r-p+1];
        while (i<=q && j<=r){
            if (a[i] <= a[j]){
                tmp[k++] = a[i++];
            }else {
                tmp[k++] = a[j++];
            }
        }
        while (i<=q){
            tmp[k++] = a[i++];
        }
        while (j<=r){
            tmp[k++] = a[j++];
        }
        for (i=0;i<=r-p;i++){
            a[p+i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,5,6,3,2,1};
        mergeSort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
