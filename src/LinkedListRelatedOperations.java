import java.util.HashSet;

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
