import java.util.HashSet;
import java.util.Set;

public class LinkedListRelatedOperations {

    //85-> 15-> 4-> 20
    Node reverseLinkedList(Node head) {
        Node prev = null;
        Node next = null;
        Node current = head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;

        return head;
    }

    boolean isContainsLoop(Node head) {
        boolean containsLoop = false;
        HashSet<Node> set = new HashSet<>();
        Node node = head;
        while (node != null) {
            if (set.contains(node)) {
                return true;
            }

            set.add(node);
            node = node.next;
        }

        return containsLoop;
    }

    Node createLinkedList(int[] numbers) {
        Node head = null;
        for (int num : numbers) {
            if (head == null) {
                head = new Node(num);
            }
            else {
                Node node = new Node(num);
                Node current = head;
                while (current.next !=null) {
                    current = current.next;
                }
                current.next = node;
            }
        }
        return head;
    }



    void insertionSort() {
        Node head = createLinkedList(new int[]{7, 3, 5, 2, 1, 8});


        Node node = performInsertionSort(head);
        System.out.println("Linked List:");
        System.out.println("Linked List:" + node.data);
    }

    Node sorted = null;
    private Node performInsertionSort(Node head) {

        Node current = head;
        while (current != null) {
            Node next = current.next;
            sortedInsert(current);
            current = next;
        }


        return sorted;
    }

    private void sortedInsert(Node newNode) {

        if (sorted == null || sorted.data >= newNode.data) {
            newNode.next = sorted;
            sorted = newNode;
        }
        else {
            Node current = sorted;
            while (current.next != null && current.next.data < newNode.data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }

    }


//    private Node performInsertionSort(Node head) {
//        sorted = null;
//        Node current = head;
//        while (current != null)
//        {
//            // Store next for next iteration
//            Node next = current.next;
//            // insert current in sorted linked list
//            sortedInsert(current);
//            // Update current
//            current = next;
//        }
//        // Update head_ref to point to sorted linked list
//        head = sorted;
//
//        return head;
//    }




//    void sortedInsert(Node newnode)
//    {
//        /* Special case for the head end */
//        if (sorted == null || sorted.data >= newnode.data)
//        {
//            newnode.next = sorted;
//            sorted = newnode;
//        }
//        else
//        {
//            Node current = sorted;
//            /* Locate the node before the point of insertion */
//            while (current.next != null && current.next.data < newnode.data)
//            {
//                current = current.next;
//            }
//            newnode.next = current.next;
//            current.next = newnode;
//        }
//    }

//    Node reverseLinkedList(Node head) {
//        Node prev = null;
//        Node current = head;
//        Node next = null;
//        while (current !=null) {
//            next = current.next;
//            current.next = prev;
//            prev = current;
//            current = next;
//        }
//        head = prev;
//        return head;
//    }
}
