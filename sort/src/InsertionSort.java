public class InsertionSort {
    private static void insertionSort(int[] arr){
        for (int i=1;i<arr.length;i++){
            int value = arr[i];
            int j = i-1;
            //从后往前比较
            for (;j>=0&&arr[j]>value;j--){
                arr[j+1] = arr[j];
            }
            arr[j+1] = value;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,5,6,3,2,1};
        insertionSort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
