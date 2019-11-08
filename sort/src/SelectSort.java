public class SelectSort {
    private static void selectSort(int[]arr){
        for (int i=0;i<arr.length-1;i++){
            int minIndex = i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,5,6,3,2,1};
        selectSort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
