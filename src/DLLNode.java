public class DLLNode extends Node {
    int data;
    DLLNode previous;

    DLLNode(int data) {
        super(data);
        this.data = data;
        next = null;
        previous = null;
    }
}
