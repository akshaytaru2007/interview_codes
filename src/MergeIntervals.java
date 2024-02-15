
/*
 * Given an array of intervals as input where each interval has a start and end timestamps.
 * Input array is sorted by starting timestamps.
 * Merge overlapping intervals and return output array (list).
 * Eg:
 * Input: Intervals [(1, 5), (4, 6), (3, 7), (6, 8)]
 * Output: [(1, 8)]
 * Input: Intervals = [(6, 8), (1, 9), (2, 4), (4, 7)]
 * Output: [(1, 9)]
 * Input: Intervals =  [(1, 3), (2,4), (9,10), (6,8)]
 * Output: [(1, 4), (6, 8), (9, 10)]
 *
 * */

/*
 * Solution: Linear Scan
 * Runtime Complexity - Linear, O(n)
 * Memory Complexity - Constant O(1)
 * */

import java.util.*;

public class MergeIntervals {

    public void merge(int[][] intervals) {

        //[(1, 3), (2,4), (9,10), (6,8)]
        if (intervals.length == 0) {
            List<int[]> list = new ArrayList<>();
            Collections.addAll(list, intervals);
            printTwoDArray(list);
        }

        //Sort collections
        Arrays.sort(intervals, Comparator.comparingInt(value -> value[0]));
        List<int[]> result = new ArrayList<>();

        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int[] interval : intervals) {
            if (interval[0] < newInterval[1]) {
                newInterval[1] = Integer.max(interval[1], newInterval[1]);
            }
            else {
                newInterval = interval;
                result.add(newInterval);
            }

        }
        printTwoDArray(result);


    }

    void printTwoDArray(List<int[]> arr) {
        for (int[] item : arr) {
            System.out.println("(" +item[0] + ", " + item[1] + "), ");
        }
    }

}
