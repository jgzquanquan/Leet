public class BubbleSort {
    private static void bubbleSort(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            //提前退出的标志位
            boolean flag = true;
            for (int j=0;j<arr.length-1-i;j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }
            if (flag) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,5,6,3,2,1};
        bubbleSort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
