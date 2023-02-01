public class BubbleSort {
    void performBubbleSort(int arr[]) {
        for (int i=0; i<arr.length; i++) {
            for (int j = 1; j<arr.length; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j-1);
                }
            }
        }
    }

    void swap(int arr[], int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
