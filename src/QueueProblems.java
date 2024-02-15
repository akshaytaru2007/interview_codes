import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueProblems {



    //https://www.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/1
    //Reverse First K elements of Queue
    void modifyQueue() {
        Queue<Integer> queue = new ArrayDeque<>();
//        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] arr = new int[]{4,3,2,1};
        int k = 4;
        int n = k;
        for (int i : arr) {
            queue.add(i);
        }
        int queueSize = queue.size();
        //------Start of Problem
        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            stack.push(queue.poll());
            n--;
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        int rotate = queueSize - k;
        while (rotate > 0) {
            queue.add(queue.poll());
            rotate--;
        }
        System.out.println("Queue: ");
        for (Integer i : queue) {
            System.out.print(" " + i);
        }

    }

}
