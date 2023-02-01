public class BinarySearch {


    int performBinarySearch(int low, int high, int arr[], int key) {
        if (high >= 0 && low < arr.length) {
            if (low == high) {
                if (key == arr[low]) {
                    return low;
                } else {
                    return -1;
                }
            } else {
                int mid = (low + high) / 2;
                if (key == arr[mid]) {
                    return mid;
                } else if (key < arr[mid]) {
                    high = mid - 1;
                    return performBinarySearch(low, high, arr, key);
                } else {
                    low = mid + 1;
                    return performBinarySearch(low, high, arr, key);
                }

            }
        }
        else {
            return -1;
        }
    }
}
