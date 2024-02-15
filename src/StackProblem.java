import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackProblem {


    //input [4, 10, 5, 8, 20, 15, 3, 12]
    //output [-1, 4, 4, 5, 8, 8, -1, 3]
    void findPreviousSmallerElement() {
        int[] input = new int[]{4, 10, 5, 8, 20, 15, 3, 12};
        List<Integer> output = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int item : input) {
            if (stack.isEmpty()) {
                output.add(-1);
                stack.add(item);
            }
            else {
                if (stack.peek() < item) {
                    output.add(stack.peek());
                    stack.add(item);
                } else {
                    while (!stack.isEmpty() && stack.peek() >= item) {
                        stack.pop();
                    }
                    if (stack.isEmpty()) {
                        output.add(-1);
                        stack.add(item);
                    } else {
                        output.add(stack.peek());
                        stack.add(item);
                    }
                }
            }

        }

        System.out.println("Output: ");
        for (Integer i : output) {
            System.out.print(i + " ");
        }
    }

    //input [4, 10, 5, 8, 20, 15, 3, 12]
    //output [-1, -1, 10, 10, -1, 20, 15, 15]
    void findPreviousBiggerElement() {
        int[] input = new int[]{4, 10, 5, 8, 20, 15, 3, 12};
        List<Integer> output = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int item : input) {
            while (!stack.isEmpty() && stack.peek() <= item) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                output.add(-1);
            }
            else {
                output.add(stack.peek());
            }
            stack.push(item);
        }

        System.out.println("Output: ");
        for (Integer i : output) {
            System.out.print(i + " ");
        }
    }

//    Input 1:
//    A = "(()())"
//    Output 1: 1
//
//    Input 2:
//    A = "(()"
//    Output 2: 0
// https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/w
    //Input: [()]{}{[()()]()}
    //output: true
    void balanceParantheses() {
        boolean isBalanced = true;
        String input = "(()())";
        Stack<Character> stack = new Stack<>();
        for (int i =0; i<input.length(); i++) {
            char ch = input.charAt(i);
            boolean isOpeningBrac = isOpeningBrace(ch);
            if (isOpeningBrac) {
                stack.push(ch);
            }
            else {
                if (stack.isEmpty()) {
                    isBalanced =  false;
                    break;
                }
                else {
                    char newCh = stack.peek();
                    boolean isMatching = isMatchingChar(ch, newCh);
                    if (isMatching) {
                        stack.pop();
                    }
                    else {
                        isBalanced = false;

                        break;
                    }
                }
            }
        }
        if (isBalanced) {
            System.out.println("Stack Balanced?" + isBalanced);
        }
        else {
            System.out.println("Stack Balanced?" + stack.isEmpty());
        }


    }

    private boolean isMatchingChar(char ch, char newCh) {

        return (newCh == '(' && ch == ')') ||
                (newCh == '{' && ch == '}') ||
                (newCh == '[' && ch == ']');
    }

    private boolean isOpeningBrace(char ch) {
        return ch == '{' || ch == '(' || ch == '[';
    }


}
