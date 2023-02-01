public class QuickSort {

    void performQuickSort(int arr[], int low, int high) {
        if(low < high) {
            int j = partition(arr, low, high);
            performQuickSort(arr, low, j);
            performQuickSort(arr, j+1, high);
        }
    }


    int partition(int arr[], int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        while(i<j) {

            while (arr[i] <= pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }

            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    private void swap(int arr[], int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
