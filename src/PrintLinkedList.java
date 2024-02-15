public class PrintLinkedList {

    void printList(Node head) {
        Node node = head;
        System.out.println("Printing Linked List:");
        while (node !=null) {
            System.out.print(node.data + "->");
            node = node.next;
        }

    }

}
