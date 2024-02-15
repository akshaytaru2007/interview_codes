import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;

import static java.lang.Math.round;

public class Main2 {
    public static void main(String[] args) {

//        int[] array =  {100, 80, 70, 65, 60, 55, 50};
//        int maxProfit = getMaximumProfit(array);
//        System.out.println("Max profit: " + maxProfit);

        //performLowAndHighIndex_BinarySearch();
//
        //MergeIntervals intervals = new MergeIntervals();
        //intervals.merge(new int[][]{{1, 3}, {6, 8}, {2, 4},  {9, 10}});
//        MoveZeroToLeft moveZeroToLeft = new MoveZeroToLeft();
//        moveZeroToLeft.moveZeros();

        //binarySearchPractice();
        //performLeftRotation();
        //QuickSortAlgo quickSortAlgo = new QuickSortAlgo();
        //quickSortAlgo.performQuickSort();
//        BubbleSortAlgo bubbleSortAlgo = new BubbleSortAlgo();
//        bubbleSortAlgo.performSort();
        //performFibonachiSeries();
        //findMaximumSumInContiguousArray();
        //removeDuplicateFromString();
//        MergeSortAlgo mergeSortAlgo = new MergeSortAlgo();
//        mergeSortAlgo.performSort();

//        LinkedListProblem listProblem = new LinkedListProblem();
//        Node head = listProblem.createLinkList(new int[]{10, 16, 8, 12, 15, 6, 2});
//        listProblem.printLinkedList(head);
//        Node newNode = listProblem.insertNodeAtStart(15, head);
//        listProblem.printLinkedList(newNode);
//
//        Node nodeAtEnd = listProblem.insertNodeAtEnd(22, newNode);
//        listProblem.printLinkedList(nodeAtEnd);


        //findGCDOfTwoNumbers();

        //int num1 = 28, num2 = 20;
//        int result = findGCDOfTwoNumbersRecursive(num1, num2);
//        System.out.println("GCD of Two number is " + result);

        //findLCM(num1, num2);
        //convertDecimalFractionToBinary();

        //createFibTriangle();

//        Question1 question1 = new Question1();
//        question1.run();
//        BinaryTree binaryTree = new BinaryTree();
//        binaryTree.createBinaryTreeUsingDLL();


//        IbmQuestion ibmQuestion = new IbmQuestion();
//        ibmQuestion.question2();


        //longSubarrWthSumDivByK();
        //removeKdigits();
//        StackProblem stackProblem = new StackProblem();
//        stackProblem.balanceParantheses();

//        QueueProblems queueProblems = new QueueProblems();
//        queueProblems.modifyQueue();

//        InsertionSort sort = new InsertionSort();
//        sort.sort();

//        LinkedListRelatedOperations linkedListRelatedOperations = new LinkedListRelatedOperations();
//        linkedListRelatedOperations.insertionSort();


        //findDuplicateRowsInBinaryMatrix();

//        DynamicProgrammingBasic dynamicProgrammingBasic = new DynamicProgrammingBasic();
//        dynamicProgrammingBasic.lcs();

        BinaryTree tree = new BinaryTree();
        tree.findPaths();
//        DPKnapSack dpKnapSack = new DPKnapSack();
//        dpKnapSack.solve();

    }


    //Find duplicate rows in a binary matrix

    /**
     * matrix[][] = {{1, 0},
     *             {1, 0}}
     * Output:
     * 1
     * Explanation:
     * Row 1 is duplicate of Row 0.
     * -----------------
     * matrix[][] = {{ 1, 0, 0},
     *             { 1, 0, 0},
     *             { 0, 0, 0},
     *             { 0, 0, 0}}
     * Output:
     * 1 3
     * Explanation:
     * Row 1 and Row 3 are duplicates of Row 0 and 2 respectively.
     */
    private static void findDuplicateRowsInBinaryMatrix() {
//        int m = 2;
//        int n = 2;
//        int [][]matrix = new int[m][n];
//        matrix[0][0] = 1;
//        matrix[0][1] = 0;
//        matrix[1][0] = 1;
//        matrix[1][1] = 0;

        int m = 4;
        int n = 3;
        int [][]matrix = new int[m][n];
        matrix[0][0] = 1;
        matrix[0][1] = 0;
        matrix[0][2] = 0;

        matrix[1][0] = 1;
        matrix[1][1] = 0;
        matrix[1][2] = 0;

        matrix[2][0] = 0;
        matrix[2][1] = 0;
        matrix[2][2] = 0;

        matrix[3][0] = 0;
        matrix[3][1] = 0;
        matrix[3][2] = 0;


        Set<String> hashSet = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i=0; i < m; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j=0; j < n; j++) {
                builder.append(matrix[i][j]);
            }

            if (hashSet.contains(builder.toString())) {
                list.add(i);
            }
            else {
                hashSet.add(builder.toString());
            }
        }

        System.out.println("Numbers: ");
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }


    private static void removeKdigits() {
//        String S = "149811"; //output: 111
//        String S = "1002991"; //output: 21
//        int K = 3;
//        String S = "725083"; //output: 0
//        int K = 5;
//        String S = "1000000001"; //output: 0
//        int K = 5;
        String S = "6802036147"; //output: 602036147
        int K = 1;
        // code here

        String output  = removeKDigitFromString(S, K);
        System.out.println("Output: " + output);

    }

    private static String removeKDigitFromString(String input, int k) {

        BigInteger number = BigInteger.valueOf(0);
        if (input.isEmpty()) {
            input = "0";
        }
        number = new BigInteger(input);
        if (number.equals(BigInteger.valueOf(0))) {
            k = 0;
        }

        input = String.valueOf(number);
        if (k >0 ) {
            int length = input.length();
            int i = 0;
            int j = i + 1;
            int num1 = Integer.parseInt(String.valueOf(input.toCharArray()[i]));
            int num2 = 0;
            if (j < length) {
                num2 = Integer.parseInt(String.valueOf(input.toCharArray()[j]));
            }
            if (num1 > num2) {
                input = input.substring(i + 1, length);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(input.toCharArray(), i, j - i);
                stringBuilder.append(input, j+1, length);
                input = stringBuilder.toString();
            }
            k--;
            return removeKDigitFromString(input, k);
        }

        return input;
    }


    private static void longSubarrWthSumDivByK() {
//        int a[] = new int[]{2, 7, 6, 1, 4, 5};
        int a[] = new int[]{-2, 2, -5, 12, 11, 1, 7};
        int n = 7;
        int k = 3;
        int count = 0;
        int maxCount = 0;
        int sum = 0;

        for (int i=0; i <n ; i++) {
            count = 0;
            sum =0;
            sum += a[i];
            if (sum % k == 0) {
                count = i;
            }
            for (int j=i + 1; j < n; j++) {
                sum += a[j];
                if (sum % k == 0) {
                    count = j - i + 1;
                }
            }

            if (maxCount < count) {
                maxCount = count;
            }
        }


        System.out.println("Sum: " + maxCount);
    }

    /**
     *  1
     *  1 2
     *  3 5 8
     *  13 21 34 55
     *  89 144 233 377 610
     */
    private static void createFibTriangle() {
        int row = 5;
        int elements = row * (row + 1) / 2;

        System.out.println("Elements: " + elements);

        int []arr = new int[elements];
        arr[0] = 1; arr[1] = 1;
        for (int i = 2; i<elements; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        System.out.println("All Elements:");

        int index = 0;
        for (int i =0; i<arr.length; i++) {
            for (int j=0; j< i; j++) {
                if (index< arr.length)
                    System.out.print(arr[index++] + " ");
            }
            System.out.println("");

        }

    }

    private static void convertDecimalFractionToBinary() {
        double input = 4.47;
        int k = 3;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        int integralPart = (int) input;
        double fractionalPart = Double.valueOf(decimalFormat.format(input - integralPart));

        StringBuilder stringBuilder = new StringBuilder();
        int quotient = integralPart;
        while (quotient != 0) {
            int remainder = quotient % 2;
            stringBuilder.append(remainder);
            quotient = quotient / 2;
        }
        stringBuilder.reverse();
        stringBuilder.append(".");

        //double fractionalIntegral = 0;
        while (k > 0) {
            fractionalPart = fractionalPart * 2;
            int fractionalIntegral = (int) fractionalPart;
            stringBuilder.append(fractionalIntegral);
            fractionalPart = Double.valueOf(decimalFormat.format(fractionalPart - fractionalIntegral));
            k--;
        }

        System.out.println("Integral : " + integralPart + " Fractional: " + fractionalPart + ", output " + stringBuilder);
    }

    private static int findGCDOfTwoNumbersRecursive(int a, int b) {
        if (a == 0) {
            return b;
        }
        return findGCDOfTwoNumbersRecursive(b % a, a);
    }

    private static void findGCDOfTwoNumbers() {
        int num1 = 28, num2 = 20;

        int result = Math.min(num1, num2);
        while (result > 0) {
            if (num1  % result ==0  && num2 % result == 0) {
                break;
            }
            result--;
        }
        System.out.println("GCD of Two number is " + result);
    }

    /**
     * Formula is (a * b) = LCM(a, b) * GCD(a, b)
     *
     * LCM = (a * b) / GCD(a, b)
     * @param num1
     * @param num2
     * @return
     */
    private static void findLCM(int num1, int num2) {
        int result = (num1 * num2) / findGCDOfTwoNumbersRecursive(num1, num2);
        System.out.println("LCM of Two number is " + result);
    }

    /**
     * Given a string that contains duplicate occurrences of characters, remove these duplicate occurrences
     *       Eg.  Input: "abbabcddbabcdeedebc"
     *            Output: "abcde"
     *
     */
    private static void removeDuplicateFromString() {
        String input = "abbabcddbabcdeedebc";
//        StringBuilder builder = new StringBuilder();
//        char[] inputArr = input.toCharArray();
//
//        for (char c : inputArr) {
//            if (!containsChar(builder, c)) {
//                builder.append(c);
//            }
//        }
//        System.out.print("Final string: " + builder.toString());

        Set<Character> set = new LinkedHashSet<>();
        char[] inputArr = input.toCharArray();
        for (char c : inputArr) {
            set.add(c);
        }
       StringBuilder builder = new StringBuilder();
        for (Character c : set) {
            builder.append(c);
        }
        System.out.print("Final string: " + builder);
    }

    private static boolean containsChar(StringBuilder builder, char character) {
        boolean contains = false;
        for (char existingChar : builder.toString().toCharArray()) {
            if (existingChar == character) {
                return true;
            }
        }

        return contains;
    }

    //Kadane's algorith
    private static void findMaximumSumInContiguousArray() {
        int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3};
        int maxSum = 0;
        int maxSumSoFar = 0;
        for (int i= 0; i < arr.length; i++) {
            maxSumSoFar = maxSumSoFar + arr[i];
            if (maxSumSoFar > maxSum) {
                maxSum = maxSumSoFar;
            }
            if (maxSumSoFar < 0) {
                maxSumSoFar = 0;
            }
        }
        System.out.println("Maximum sum in Contiguous Array:" + maxSum);



    }



    private static void performFibonachiSeries() {
        int num = 9;
        int fibNumber = fibonachi(num);
        System.out.println("Fib number is: " + fibNumber);

    }

    private static int fibonachi(int num) {
        if (num <= 1)
            return num;
        return fibonachi(num -1) + fibonachi(num -2);
    }


    private static void performLowAndHighIndex_BinarySearch() {
        //https://www.educative.io/find-low-high-index
        /*
         * Given a sorted array of integers, return the low and high index of the given key.
         * Return -1 if not found. The array length can be in millions with lots of duplicates.
         * */


        int []array = {1, 2, 5, 5, 5, 5, 5, 5, 5, 5, 20};
        int key = 5;
        int low = performBinarySearch(array, 0, array.length-1, key);
        int high = performBinarySearch(array, 0, array.length-1, key);
        System.out.println("Low and High index: Low: " + low + ", High: " + high);

    }

    static int performBinarySearch(int []arr, int low, int high, int key) {
        if (high >= 0 && low < arr.length) {

            if (low == high) {
                if (key == arr[low]) {
                    return low;
                }
                else {
                    return -1;
                }
            }
            else {
                int mid = (high + low) / 2;
                if (key == arr[mid]) {
                    return mid;
                }
                else if (key < arr[mid]) {
                    low = mid + 1;
                    return performBinarySearch(arr, low, high, key);
                }
                else {
                    high = mid - 1;
                    return performBinarySearch(arr, low, high, key);
                }
            }
        }
        else {
            return  -1;
        }
    }

    private static void performLowAndHighIndex_LinearSearch() {
        //https://www.educative.io/find-low-high-index
        /*
         * Given a sorted array of integers, return the low and high index of the given key.
         * Return -1 if not found. The array length can be in millions with lots of duplicates.
         * */

        //Using linear search


        int []array = {1, 2, 5, 5, 5, 5, 5, 5, 5, 5, 20};
        int key = 5;

        int lowIndex = -1;
        int highIndex = Integer.MAX_VALUE;
        int index = 0;
        while (index < array.length) {
            if (key == array[index]) {
                if (lowIndex == -1) {
                    lowIndex = index;
                }
                else if (lowIndex > index){
                    lowIndex = index;
                }
            }
            index++;
        }

        System.out.println("Lowest index: " + lowIndex);
        index = array.length - 1;
        while (index > 0) {
            if (key == array[index]) {
                if (highIndex == Integer.MAX_VALUE) {
                    highIndex = index;
                }
               if (highIndex < index) {
                   highIndex = index;
               }
            }
            index--;
        }
        System.out.println("Highest index: " + highIndex);


    }

    private static int getMaximumProfit(int[] array) {
       int maxProfit = 0;
       int buy = array[0];
       for (int index = 1; index< array.length; index++) {
           if (buy > array[index]) {
               buy = array[index];
           }
           else if(maxProfit < array[index] - buy) {
               maxProfit = array[index] - buy;
           }
       }

        return maxProfit;
    }

    private static void binarySearchPractice() {

    }

    /**
     * https://www.geeksforgeeks.org/array-rotation/'
     * Given an integer array nums, rotate the array to the right by k steps,
     * where k is non-negative.
     */
    private static void performLeftRotation() {
        int[] array = new int[]{1,2,3,4,5,6,7};
        int rotationKey = 16;

        int[] temp = new int[array.length];

        if (rotationKey < array.length) {
            int i=0;
            for (int j=rotationKey; j<array.length; j++, i++) {
                temp[i] = array[j];
            }
            for (int j=0; j < rotationKey; j++, i++) {
                temp[i] = array[j];
            }
        }
        else {
            int newRotationKey = rotationKey % array.length;
            int i = 0;
            for (int j=newRotationKey; j<array.length; j++, i++) {
                temp[i] = array[j];
            }
            for (int j=0; j < newRotationKey; j++, i++) {
                temp[i] = array[j];
            }
        }
        for (int item : temp) {
            System.out.print(item + " ,");
        }

    }
}

class BinarySearchPractice {
    int search(int key, int low, int high, int[] arr) {
        if (high >= 0 && low < arr.length) {
            if (low == high) {
                if (key == arr[low]) {
                    return low;
                } else {
                    return -1;
                }
            } else {
                int mid = (high + low) / 2;
                if (arr[mid] == key) {
                    return mid;
                } else if (key < arr[mid]) {
                    high = mid - 1;
                    return search(key, low, high, arr);
                } else {
                    low = mid + 1;
                    return search(key, low, high, arr);
                }
            }
        }
        return -1;

    }

}

class QuickSortAlgo {

    protected void performQuickSort() {
        int[] input = new int[]{10, 16, 8, 12, 15, 6, 2};

        quickSort(input, 0, input.length - 1);
        for (int item : input) {
            System.out.print(item + " ,");
        }
    }

    private void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            int j = performPartition(arr, low, high);
            quickSort(arr, low, j);
            quickSort(arr, j + 1, high);
        }

    }

    private int performPartition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        while (i < j) {
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

    private void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}

class BubbleSortAlgo {

    protected void performSort() {
        int[] input = new int[]{10, 16, 8, 12, 15, 6, 2};
        for(int i=0; i< input.length; i++) {
            for(int j =1; j <input.length; j++) {
                if (input[j] < input[j-1]) {
                    swap(input, j, j-1);
                }
            }
        }
        for (int item : input) {
            System.out.print(item + " ,");
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}

class MergeSortAlgo {
    protected void performSort() {
        int[] input = new int[]{10, 16, 8, 12, 15, 6, 2};
        mergeSort(input, 0, input.length - 1);
        for (int item : input) {
            System.out.print(item + " ,");
        }
    }

    private void mergeSort(int[] input, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(input, low, mid);
            mergeSort(input, mid + 1, high);
            merge(input, low, mid, high);
        }
    }

    private void merge(int[] arr, int low, int mid, int high) {


        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        for (int l = 0; l < n1; l++) {
            leftArr[l] = arr[low + l];
        }

        for (int l = 0; l < n2; l++) {
            rightArr[l] = arr[mid + l + 1];
        }

        int i = 0;
        int k = low;
        int j = 0;


        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (j < n2) {
            arr[k++] = rightArr[j++];
        }

        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

    }
}

