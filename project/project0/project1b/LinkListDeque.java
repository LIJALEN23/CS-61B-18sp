package project1b;

public class LinkListDeque<T> implements Deque<T> {

    public class Node {
        private Node pre;
        private T item;
        private Node next;

        public Node(Node pre, T item, Node next) {
            this.pre = pre;
            this.item = item;
            this.next = next;
        }

        public Node(Node pre, Node next) {
            this.pre = pre;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;

    public LinkListDeque() {
        sentinel = new Node(null, null);

        size = 0;
    }

    @Override
    public void addFirst(T item) {
        if (size == 0) {
            Node newNode = new Node(sentinel.pre, item, sentinel.next);

            newNode.pre = newNode;
            newNode.next = newNode;

            sentinel.pre = newNode;
            sentinel.next = newNode;

            size += 1;
        }

        else {
            Node newNode = new Node(sentinel.pre, item, sentinel.next);

            sentinel.pre.next = newNode;
            sentinel.next.pre = newNode;

            sentinel.next = newNode;

            size += 1;
        }

    }

    @Override
    public void addLast(T item) {
        if (size == 0) {
            Node newNode = new Node(sentinel.pre, item, sentinel.next);

            newNode.pre = newNode;
            newNode.next = newNode;

            sentinel.pre = newNode;
            sentinel.next = newNode;

            size += 1;
        }

        else {
            Node newNode = new Node(sentinel.pre, item, sentinel.next);

            sentinel.pre.next = newNode;
            sentinel.next.pre = newNode;

            sentinel.pre = newNode;

            size += 1;
        }
    }

    @Override
    public boolean isEmpty() {

        return (size == 0);
    }

    @Override
    public void printDeque() {
        Node temp = sentinel.next;

        System.out.print("Deque is : ");

        for (int i = 0; i < size; i += 1) {

            System.out.print(temp.item + " ");

            temp = temp.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        T val = sentinel.next.item;

        if (size == 1) {
            sentinel.next = null;
            sentinel.pre = null;

            size -= 1;
        }

        else {
            sentinel.next = sentinel.next.next;
            sentinel.next.pre = sentinel.pre;
            sentinel.pre.next = sentinel.next;
            size -= 1;
        }

        return val;
    }

    @Override
    public T removeLast() {

        T val = sentinel.pre.item;

        if (size == 1) {
            sentinel.next = null;
            sentinel.pre = null;

            size -= 1;
        }

        else {
            sentinel.pre = sentinel.pre.pre;
            sentinel.pre.next = sentinel.next;
            sentinel.next.pre = sentinel.pre;
            size -= 1;
        }

        return val;
    }

    @Override
    public T get(int index) {
        if (size == 0) {

            System.out.println("ERROR!");
//            return -1;
        }

        Node temp = sentinel.next;
        T val;

        for(int i = 1; i < index; i += 1) {
            temp = temp.next;
        }

        val = temp.item;

        return val;
    }

    @Override
    public int size() {
        return size;
    }

}