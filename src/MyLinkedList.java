public class MyLinkedList<T> {
    private Node<T> head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public void insertToFront(T data) {
        if (data == null) {
            throw new IllegalStateException("Data cannot be null");
        }

        Node<T> newNode = new Node<>(data);
        newNode.setNext(head);
        head = newNode;

        size++;
    }

    public void insertAfter(Node<T> node, T data) {
        if (node == null) {
            throw new IllegalStateException("Node cannot be null");
        }
        if (data == null) {
            throw new IllegalStateException("Data cannot be null");
        }

        Node<T> newNode = new Node<>(data);
        newNode.setNext(node.getNext());
        node.setNext(newNode);

        size++;
    }

    public Node<T> remove(T data) {
        if (data == null) {
            throw new IllegalStateException("Data cannot be null");
        }

        Node<T> current = head;
        Node<T> previous = null;

        while (current != null) {
            if (data.equals(current.getData())) {
                if (previous == null) {
                    head = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                size--;
                return current;
            }
            previous = current;
            current = current.getNext();
        }

        return null;
    }

    public Node<T> find(T data) {
        if (data == null) {
            throw new IllegalStateException("Data cannot be null");
        }

        Node<T> current = head;

        while (current != null) {
            if (data.equals(current.getData())) {
                return current;
            }
            current = current.getNext();
        }

        return null;
    }
}
