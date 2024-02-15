public class InsertionSort {
    void sort() {
        int[] arr = new int[] {7, 3, 5, 2, 1, 8};

        for (int i =1; i< arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] >= current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }

        System.out.println("Sorted Array:");
        for (int i : arr) {
            System.out.print(" " + i);
        }
    }
}
