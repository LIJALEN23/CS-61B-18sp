package code4;

public class SLList<Item> implements List61B<Item> {
    public static class Node<Item> {
        public Item val;
        public Node next;

        public Node() {
            this.val = null;
            this.next = null;
        }

        public Node(Item val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    private Node sentinel;
    private int size;

    public SLList() {
        sentinel = new Node<>();
        this.size = 0;
    }

    @Override
    public void addFirst(Item x) {
        sentinel.next = new Node<>(x, sentinel.next);
        size += 1;
    }

    @Override
    public void addLast(Item y) {
        Node temp = sentinel;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node<>(y, null);

        size += 1;
    }

    @Override
    public Item getFirst() {

        return (Item) sentinel.next.val;
    }

    @Override
    public Item getLast() {
        Node temp = sentinel.next;

        while (temp.next != null) {
            temp = temp.next;
        }

        return (Item) temp.val;
    }

    @Override
    public Item removeLast() {
        Node temp = sentinel.next;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        Item val =(Item) temp.next.val;
        temp.next = null;

        return val;
    }

    @Override
    public Item get(int index) {
        if (size < index) {
            System.out.println("ERROR!");
            return null;
        }

        Node temp = sentinel;

        for (int i = 0; i < index; i += 1) {
            temp = temp.next;
        }

        return (Item) temp.val;
    }

    @Override
    public void insert(Item x, int index) {
        Node temp = sentinel;

        //将temp指针指向要插入位置的前一个
        for (int i = 0; i < index - 1; i += 1) {
            temp = temp.next;
        }

        Node newNode = new Node<>(x, temp.next);

        temp.next = newNode;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        Node temp = sentinel.next;

        System.out.print("List is : ");
        for (int i = 0; i < size && temp != null; i += 1) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
