import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        TestCompanion.Companion.add(2);
        TestObject.INSTANCE.add(2);

        System.out.println("Hello world!");


        //binarySearch();
        //quickSort();
        //bubbleSort();
        mergeSort();
        int prices[] = { 7, 1, 5, 6, 4 };
        //int maxProfit = findMaximumProfitFromStocks(prices);
        //System.out.println("Maximum Profit: " + maxProfit);

        //int[] inputForKadanesAlgo = { -2, -3, 4, -1, -2, 1, 5, -3 };
       // int maxSum = findMaximumSumInContiguousArray(inputForKadanesAlgo);
        //System.out.println("Maximum Sum in Contiguous Array: " + maxSum);
        //findMaxSumInCircularArrayNotAdjacent();
        //int fibNum = performFibonacchi(9);
        ///System.out.println("Fib number: " + fibNum);

        //printLinkedList();
        //reverseLinkedList();

        //checkLoopedLinkedList();

        //createLinkedList();
        //checkPalindromeOfNumber();
        //checkStringPalindrome();
        //findLengthOfLogestSubstring();

        //queueUsingStacks();
        //findMinElementInArray();
        //findLargestSubArrayWithEqualNumber();


        //findSumbOfX();


    }


    /*
    X=66

{11,21,33,44,55,66} = N


11+55 = 66

     */
    private static void findSumbOfX() {
        int[] arr = new int[] {11,21,33,44,55,66};
        int key = 66;
        int tempStartIndex = 0;
        int startIndex =0;
        int endIndex = 0;

        for(int i=0; i< arr.length; i++) {
            tempStartIndex = i;
            for (int j = i +1; j<arr.length; j++) {
                if ((arr[i] + arr[j]) == key) {
                    endIndex = j;
                    startIndex = tempStartIndex;
                    break;
                }
            }
        }

        System.out.println(" Start index:" + startIndex +  ", EndIndex: " + endIndex);
    }

    private static void findLargestSubArrayWithEqualNumber() {
        int[] arr = new int[] {0, 0 , 1, 1, 0};
//        int[] arr = new int[] {1, 0 , 1, 1, 1, 0, 0};
        int startIndex = 0;
        int endIndex = 0;
        int lengthTillNow = 0;
        int tempStart = 0;
        int tempEnd = 0;
        int zeroCount = 0;
        int oneCount = 0;
        for (int i = 0; i< arr.length; i++) {
            zeroCount = 0; oneCount = 0;
            tempStart = i;
            if (arr[i] == 0) {
                zeroCount++;
            }
            else {
                oneCount++;
            }
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] == 0) {
                    zeroCount++;
                }
                else {
                    oneCount++;
                }
                if (zeroCount == oneCount) {
                    tempEnd = j;
                     if ((tempEnd + 1 - tempStart) > lengthTillNow) {
                         lengthTillNow = tempEnd + 1 - tempStart;
                         startIndex = tempStart;
                         endIndex = tempEnd;
                     }
                }
            }
        }

        System.out.println("Largest subarray with equal number of 0s and 1s: " );
        System.out.print("Start: " + startIndex +", End: " + endIndex);

    }

    private static void findMinElementInArray() {
        int[] array = new int[] {5, 6, 1, 3, 4};
        int min_now = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min_now > array[i]) {
                min_now = array[i];
            }
        }
        System.out.println("Min element is: " + min_now);
    }

    private static void queueUsingStacks() {
        int[] array = new int[] {4, 7, 9, 11, 34};
        QueueUsingStack queueUsingStack = new QueueUsingStack();
        for (int item : array) {
            queueUsingStack.enQueue(item);
        }
        queueUsingStack.printQueue();

        queueUsingStack.deQueue();
    }

    private static void findLengthOfLogestSubstring() {
        //the longest substring are “BDEFGA” and “DEFGAB”
        //String input = "BBBB";
        String input = "ABDEFGABEF";

        HashMap<String, Integer> substringSet = new HashMap<String, Integer>();

        char[] inputArr = input.toCharArray();
        for (int i=0; i<inputArr.length; i++) {
            char firstChar = inputArr[i];
            int nextPosition = -1;
            int j = i+1;
            while (j<inputArr.length) {
                if (firstChar == inputArr[j]) {
                    nextPosition = j;
                    break;
                }
                j++;
            }
            if (nextPosition != -1) {
                String tempString = input.substring(i + 1, nextPosition + 1);

                substringSet.put(tempString, tempString.length());
            }

        }
        System.out.println("Substrings are as follows:\n");
        substringSet.forEach((string, integer) -> {
            System.out.print(string + ", ");
        });

    }

    private static void checkStringPalindrome() {
        String input = "boob";
        boolean isPalindrome = true;
        char[] inputArray = input.toCharArray();
        int length = inputArray.length;
        int i = 0, j = length-1;
        while (i<length-1 && j >= 0) {
            if (inputArray[i] != inputArray[j]) {
                isPalindrome = false;
                break;
            }
            i++;
            j--;
        }
        if (isPalindrome) {
            System.out.println("String is Palindrome");
        }
        else {
            System.out.println("String is Not Palindrome");
        }

    }

    private static void checkPalindromeOfNumber() {

        int number = 154351;
        int original = number, reverseNumber =0, remainder;

        while (number != 0) {
            remainder = number % 10;
            reverseNumber = reverseNumber * 10 + remainder;
            number = number / 10;
        }

//        int number = 1331;
//        int original = number;
//        int reverseNumber =0, remainder;
//        while (number != 0) {
//            remainder = number % 10;
//            reverseNumber = reverseNumber * 10 + remainder;
//            number = number /10;
//        }

        if (original == reverseNumber) {
            System.out.println("Number is Palindrome");
        }
        else {
            System.out.println("Number is Not Palindrome");
        }

    }

    private static void createLinkedList() {
        int[] list = new int[] {4,6,2,1};
        LinkedListRelatedOperations operations = new LinkedListRelatedOperations();
        Node head = operations.createLinkedList(list);
        PrintLinkedList printLinkedList = new PrintLinkedList();
        printLinkedList.printList(head);

    }

    private static void checkLoopedLinkedList() {
        LinkedListRelatedOperations operations = new LinkedListRelatedOperations();
        boolean hasLoop = operations.isContainsLoop(getLoopedLinkedList());
        System.out.println("Does it contains loop: " +hasLoop);
    }

    private static void reverseLinkedList() {
        Node head = getTestNodes();
        PrintLinkedList printLinkedList = new PrintLinkedList();
        printLinkedList.printList(head);
        LinkedListRelatedOperations operations = new LinkedListRelatedOperations();
        Node reversedNode = operations.reverseLinkedList(head);
        printLinkedList.printList(reversedNode);

    }



    private static void printLinkedList() {
        PrintLinkedList printLinkedList = new PrintLinkedList();
        printLinkedList.printList(getTestNodes());
    }

    private static Node getTestNodes() {
        Node head = new Node(4);
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        return head;
    }

    private static int performFibonacchi(int num) {
        if (num <= 1) {
            return num;
        }
        return performFibonacchi(num-1) + performFibonacchi(num - 2);
    }

    private static void mergeSort() {
//        int[] input = new int[] {10, 2, 16, 12, 8, 12, 15, 6, 2};
        int[] input = new int[] {10, 16, 8, 12, 15, 6, 2};
        MergeSort mergeSort = new MergeSort();
        mergeSort.performMergeSort(input, 0, input.length-1);
        System.out.println("Merge Sort:\n");
        for (int i : input) {
            System.out.print(i + ", ");
        }
    }

    private static void bubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();
//        int[] input = new int[] {10, 2,16, 12, 8, 12, 15, 6, 2};
        int[] input = new int[] {10};
        bubbleSort.performBubbleSort(input);
        System.out.println("Bubble Sort:\n");
        for (int i : input) {
            System.out.print(i + ", ");
        }
    }

    private static void quickSort() {
        QuickSort quickSort = new QuickSort();
        int[] input = new int[] {10, 16, 8, 12, 15, 6, 2};
        quickSort.performQuickSort(input, 0, input.length -1);

        System.out.println("Quick Sort:\n");
        for (int i : input) {
            System.out.print(i + ", ");
        }
    }

    private static void binarySearch() {
        BinarySearch binarySearch = new BinarySearch();
        int[] inputArr = new int[] {2, 5, 8, 15, 16, 20};
        int result = binarySearch.performBinarySearch(0, inputArr.length - 1, inputArr, 20);
        System.out.println("Binary Search: " + result);
    }

    private static int findMaximumProfitFromStocks(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int buy = prices[0];
        for(int i= 1; i<n; i++) {
            if (buy > prices[i]) {
                buy = prices[i];
            }
            else if (prices[i] - buy > maxProfit) {
                maxProfit = prices[i] - buy;
            }
        }
        return maxProfit;
    }

    private static int findMaximumSumInContiguousArray(int arr[]) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        for (int i=0; i < arr.length; i++) {
            maxEndingHere = maxEndingHere + arr[i];
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }

    //https://www.geeksforgeeks.org/maximum-sum-in-circular-array-such-that-no-two-elements-are-adjacent/?ref=rp
    private static void findMaxSumInCircularArrayNotAdjacent() {
        int[] arr = new int[] {1, 2, 3, 1};
        int length = arr.length;
        int maxSoFar = 0;
        int maxHere = Integer.MIN_VALUE;
        for (int i=0;i< length ; i++) {
            maxHere = arr[i];
            for (int j = i+2; j< length; j = j + 2) {
                maxHere = maxHere + arr[j];
                if (maxHere > maxSoFar) {
                    maxSoFar = maxHere;
                }

                if (maxHere < 0) {
                    maxHere = 0;
                }
            }
        }

        System.out.println("Max Sum in Circular Array:" + maxSoFar);
    }

    private static Node getLoopedLinkedList() {
        Node head = new Node(4);
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        Node node4 = new Node(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        return head;
    }
}