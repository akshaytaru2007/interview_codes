public class LinkedListProblem {


    Node createLinkList(int[] numbers) {
        Node head = null;
        for (int number : numbers) {
            if (head == null) {
                head = new Node(number);
            } else {
                Node node = new Node(number);
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = node;
            }
        }
        return head;
    }


    void printLinkedList(Node head) {
        Node node = head;
        System.out.println("Print Linked List:");
        while (node != null) {
            System.out.print(" " + node.data);
            System.out.print("->");
            node = node.next;
        }
    }

    Node insertNodeAtStart(int number, Node head) {
        if(head == null) {
           head = new Node(number);
           return head;
        }
        else {
            Node node = new Node(number);
            node.next = head;
            return node;
        }
    }

    Node insertNodeAtEnd(int number, Node head) {
        if(head == null) {
            head = new Node(number);
            return head;
        }
        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            Node node = new Node(number);
            current.next = node;
            return head;
        }
    }

}
