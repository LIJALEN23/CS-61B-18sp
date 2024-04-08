package code8;

public class SLList<Item> {
    /*定义Node结点*/
    public static class Node<Item> {
        public Item val;
        public Node next;

        /*Node的构造函数*/
        public Node(Item val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;
    /*SLList的构造函数*/

    public SLList() {
        sentinel = new Node(null, null);
        size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    /*头插法*/
    public void addFirst(Item val) {
        Node newNode = new Node(val, sentinel.next);
        sentinel.next = newNode;
        size += 1;
    }

    /*尾插法*/
    public void addLast(Item val) {
        if (isEmpty()) {
            addFirst(val);
            return;
        }
        Node tempNode = sentinel.next;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }

        Node newNode = new Node(val, null);
        tempNode.next = newNode;
        size += 1;
    }

    public Item removeFirst() {
        Item v = (Item) sentinel.next.val;
        sentinel.next = sentinel.next.next;
        return v;
    }

    public Item removeLast() {
        Node tempNode = sentinel.next;
        while (tempNode.next.next != null) {
            tempNode = tempNode.next;
        }
        Item v = (Item) tempNode.next.val;
        tempNode.next = null;
        return v;
    }

    public Item getFirst() {
        return (Item) sentinel.next.val;
    }

    public Item getLast() {
        Node tempNode = sentinel.next;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        return (Item) tempNode.val;
    }

    public void printList() {
        Node tempNode = sentinel.next;
        System.out.print("Single Linked List: ");
        while (tempNode != null) {
            System.out.print(tempNode.val + " ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }
}
