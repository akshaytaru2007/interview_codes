import java.util.*;

public class BinaryTree {


    public void createBinaryTreeUsingDLL() {
        Node root = getTopViewTreeMock();
        Node head = null, prev = null;
        head = convertToDLL(root, head, prev);

        System.out.println(head.data);
    }

    private Node convertToDLL(Node root, Node head, Node prev) {
        if (root == null) {
            return prev;
        }
        convertToDLL(root.left, head, prev);

        if (prev == null) {
            head = root;
        }
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        convertToDLL(root.right, head, prev);

        return head;
    }


    public void calculateRightViewOfTree() {
        Node root = getTopViewTreeMock();
        Map<Integer, Integer> list = new TreeMap<>();

        rightView(root, list, 0);
        System.out.println("Printing Right View:");
        for (Map.Entry<Integer, Integer> entry : list.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }

    private void rightView(Node root, Map<Integer, Integer> list, int level) {
        if (root == null) {
            return;
        }
        list.put(level, root.data);
        rightView(root.left, list, level + 1);
        rightView(root.right, list, level + 1);
    }

    public void calculateLeftViewOfTree() {
        Node root = getTopViewTreeMock();
        Map<Integer, Integer> list = new TreeMap<>();

        leftView(root, list, 0);
        System.out.println("Printing Left View:");
        for (Map.Entry<Integer, Integer> entry : list.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }

    private void leftView(Node root, Map<Integer, Integer> list, int level) {
        if (root == null)
            return;

        if (!list.containsKey(level)) {
            list.put(level, root.data);
        }

        leftView(root.left, list, level + 1);
        leftView(root.right, list, level + 1);
    }

    public void calculateTopViewOfTree() {
        Node root = getTopViewTreeMock();

        topView(root);

    }

    public void calculateBottomViewOfTree() {
        Node root = getTopViewTreeMock();

        bottomView(root);

    }

    private void topView(Node root) {
        if (root == null) {
            return;
        }

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0, root));

        Map<Integer, Integer> map = new TreeMap<>();

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            if (!map.containsKey(current.hd)) {
                map.put(current.hd, current.node.data);
            }
            if (current.node.left != null) {
                queue.add(new Pair(current.hd - 1, current.node.left));
            }
            if (current.node.right != null) {
                queue.add(new Pair(current.hd + 1, current.node.right));
            }
        }

        ArrayList<Integer> topViewItems = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            topViewItems.add(entry.getValue());
        }

        for (Integer topViewItem : topViewItems) {
            System.out.print(topViewItem + " ");
        }

    }

    //https://www.geeksforgeeks.org/problems/paths-from-root-with-a-specified-sum/1
    int totalMax = -3;
    int found = 0;
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<ArrayList<Integer>> globalList = new ArrayList<>();
    public void findPaths() {
        Node root = getPathNodes();


        res = new ArrayList<>();
        int sum = -3;
        ArrayList<Integer> path = new ArrayList<>();
        solveFindPathToSum(root, sum, 0, path);

        for (ArrayList<Integer> integers : res) {
            System.out.println("List:");
            for (Integer integer : integers) {
                System.out.print(" " + integer);
            }
        }
//        return res;
//        int sum = 0;
//        Stack<Integer> stack = new Stack<>();
//        findPathToSum(root, sum, stack);
//        for (ArrayList<Integer> integers : globalList) {
//            System.out.println("List:");
//            for (Integer integer : integers) {
//                System.out.print(" " + integer);
//            }
//
//        }

    }

    private void solveFindPathToSum(Node cur, int sum, int csum, ArrayList<Integer> path) {
        // always add cur to path
        path.add(cur.data);

        if( csum + cur.data  == sum){
            ArrayList<Integer> arr = (ArrayList)path.clone();
            res.add(arr);
        }

        if(cur.left!=null) solveFindPathToSum(cur.left, sum, csum + cur.data, path);
        if(cur.right!=null) solveFindPathToSum(cur.right, sum, csum + cur.data, path);

        // exclude current value from path while returning
        path.remove(path.size()-1);
    }

    private int findPathToSum(Node root, int sum, Stack<Integer> stack) {
        if (root == null) {
            return 0;
        }
        if (totalMax < 0 ){
            if (sum + root.data >= totalMax) {
                stack.push(root.data);
                sum = sum + root.data;
            }
//            else {
//                return sum;
//            }
        }
        else {

            if (sum + root.data <= totalMax) {
                stack.push(root.data);
                sum = sum + root.data;
            } else {
                return sum;
            }
        }
        if (sum == totalMax) {
            globalList.add(getListFromQueue(stack));
        }


        findPathToSum(root.left, sum, stack);
        while (stack.peek() != null && stack.peek() != root.data) {
            stack.pop();
        }
        findPathToSum(root.right, sum, stack);

        return 0;
    }

    private ArrayList<Integer> getListFromQueue(Stack<Integer> stack) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer i : stack) {
            list.add(i);
        }
        return list;
    }


    private Node getPathNodes() {
        Node root = new Node(-2);
//        root.left = new Node(20);
//        Node right = new Node(3);
//        root.right = right;
//        Node fourth = new Node(4);
//        fourth.left = new Node(6);
//        fourth.right = new Node(7);
//        right.left = fourth;
//        Node fifteen = new Node(15);
//        fifteen.left = new Node(8);
//        fifteen.right = new Node(9);
//        right.right = fifteen;
        Node minusFour = new Node(-4);
        root.left = minusFour;
        Node right = new Node(-1);
        root.right = right;
        Node zeroLeft = new Node(0);
        zeroLeft.left = new Node(4);
        zeroLeft.right = new Node(2);
        Node three = new Node(3);

        Node zeroRight = new Node(0);
        zeroRight.left = new Node(1);

        minusFour.left = zeroLeft;
        minusFour.right = three;
        right.left = zeroRight;


        return root;
    }

    class Pair {
        //Horizontal Distance
        int hd;
        Node node;

        public Pair(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }

    private void bottomView(Node root) {
        if (root == null) {
            return;
        }

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0, root));

        Map<Integer, Integer> map = new TreeMap<>();

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            map.put(current.hd, current.node.data);
            if (current.node.left != null) {
                queue.add(new Pair(current.hd - 1, current.node.left));
            }
            if (current.node.right != null) {
                queue.add(new Pair(current.hd + 1, current.node.right));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }


    private Node getTopViewTreeMock() {
        int[] data = new int[]{3, 5, 2, 1, 4, 6};
        //int[] data = new int[]{1, 2, 5, 3, 4, 6};
        //int[] data = new int[] {47, 2, 40, 20, 38, 30, 14, 28, 10, 16, 19, 44, 39, 27, 7, 9, 31, 12, 43, 21, 5, 41, 34, 49, 13, 33, 3, 4, 25, 22, 29, 15, 32, 35, 6, 24, 23, 26, 1, 11, 42, 36, 37, 17, 18, 8, 45, 48, 50, 46};
        Node root = null;
        for (int item : data) {
            root = insert(root, item);
        }
        return root;
    }

    public void calculateHeight() {
        Node root = getMockTree();
        int height = height(root);
        System.out.println("Height is : " + height);
    }

    private int height(Node root) {
        if (root == null) return 0;

        int size = Math.max(height(root.left), height(root.right)) + 1;
        System.out.println("Size: " + size + " for node: " + root.data);
        return size;
    }


    private Node getMockTree() {
        int[] data = new int[]{3, 5, 2, 1, 4, 6, 7};
        Node root = null;
        for (int item : data) {
            root = insert(root, item);
        }
        return root;
    }

    private Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            if (data <= root.data) {
                root.left = insert(root.left, data);
                return root;
            } else {
                root.right = insert(root.right, data);
                return root;
            }
        }
    }



    public void distributeCandy() {
        Node node = candyTree();
        System.out.println("Abs: " + Math.abs(-2));
        int[] moves = new int[1];
        distributeCandyEvenly(node, moves);
        System.out.println("Ans: " +moves[0]);
    }

    private int distributeCandyEvenly(Node node, int[] moves) {
        if (node == null) {
            return 0;
        }
        int left = distributeCandyEvenly(node.left, moves);
        int right = distributeCandyEvenly(node.right, moves);
        moves[0] += Math.abs(left) + Math.abs(right);
        int newAns = node.data + left + right - 1;
        return newAns;
    }

    private Node candyTree() {
        Node root = new Node(0);
        root.left = new Node(3);
        root.right = new Node(0);
        return root;
    }


    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

}


