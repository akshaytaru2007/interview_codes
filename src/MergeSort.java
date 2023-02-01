public class MergeSort {

    void performMergeSort(int arr[], int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            performMergeSort(arr, low, mid);
            performMergeSort(arr, mid + 1, high);
            performMerge(arr, low, mid, high);
        }
        
    }

    private void performMerge(int[] arr, int low, int mid, int high) {
        int i = low;
        int k = low;
        int j = mid + 1;
        int[] sortArr = new int[high + 1];
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                sortArr[k++] = arr[i++];
            }
            else {
                sortArr[k++] = arr[j++];
            }
        }

        for ( ; i<=mid; i++){
            sortArr[k++] = arr[i++];
        }

        for ( ; j<=high; j++) {
            sortArr[k++] = arr[j++];
        }
        for (int l=low; l<=high; l++) {
            arr[l] = sortArr[l];
        }
    }
    
    /*void  performMergeSort(int arr[], int low, int high) {
        if (low <high) {
            int mid = (low + high) / 2;
            performMergeSort(arr, low, mid);
            performMergeSort(arr, mid + 1, high);
            performMerge(arr, low, mid, high);
        }
    }

    private void performMerge(int[] arr, int low, int mid, int high) {
        int i = low;
        int k = low;
        int j = mid + 1;
        int[] sortArr = new int[high + 1];

        while (i<= mid && j<= high) {
            if (arr[i] <= arr[j]) {
                sortArr[k++] = arr[i++];
            }
            else {
                sortArr[k++] = arr[j++];
            }
        }
        for ( ; i<=mid; i++) {
            sortArr[k++] = arr[i++];
        }
        for ( ; j<=high; j++) {
            sortArr[k++] = arr[j++];
        }
        for (int l= low; l <= high; l++) {
            arr[l] = sortArr[l];
        }
    }*/
}
