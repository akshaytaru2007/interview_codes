import java.util.Stack;

public class QueueUsingStack {

    //Input: 4, 7, 9, 11, 34
    //Output: 34, 11, 9, 7, 4

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    void enQueue(int data) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack1.push(data);

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

    }

    void deQueue() {
        if (stack1.isEmpty()) {
            System.out.print("Queue is Empty");
        }

        int data = stack1.pop();
        System.out.println("DeQueue: " + data);

    }

    void printQueue() {
        System.out.println("Printing Queue: ");
        stack1.forEach(integer ->
                System.out.print(integer + ", "));
    }

}
