package project1a;

public class LinkListDeque<T> implements Deque<T> {
    /**Inner class Node. */
    public class Node {
        private T item;
        private Node pre;
        private Node next;

        /** The conductor for class Node*/
        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next =  next;
        }
        /** The conductor for sentinel Node*/
        public Node(Node pre, Node next) {
            this.pre = pre;
            this.next = next;
        }
    }
    private Node sentinel;
    private int size;

    public LinkListDeque() {
        sentinel = new Node(null, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item){
        Node newNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.pre = newNode;
        sentinel.next = newNode;
        size++;
    }
    public void addLast(T item){
        Node newNode = new Node(item, sentinel.pre, sentinel);
        sentinel.pre.next = newNode;
        sentinel.pre = newNode;
        size++;
    }
    public boolean isEmpty(){
        return (size == 0);
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        if (!isEmpty()) {
            System.out.print("LinkListDeque:");
            Node ptr = sentinel.next;
            while (ptr != sentinel) { // 遍历直到返回到 sentinel 节点
                System.out.print(ptr.item + " ");
                ptr = ptr.next;
            }
            System.out.println();
        }
        else {
            System.out.println("List is empty!");
        }
    }
    public T removeFirst(){
        if (!isEmpty()) {
            T val = sentinel.next.item;
            sentinel.next.next.pre = sentinel;
            sentinel.next = sentinel.next.next;
            size--;
            return val;
        }
        return null;
    }
    public T removeLast(){
        if (!isEmpty()) {
            T val = sentinel.pre.item;
            sentinel.pre.pre.next = sentinel;
            sentinel.pre = sentinel.pre.pre;
            size--;
            return val;
        }
        return null;
    }
    public T get(int index){
        if (index > size ) {
            return null;
        }
        Node ptr = sentinel;
        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }
        return ptr.item;
    }
    private T getRecursiveHelp(Node start, int index) {
        if (index == 0) {
            return start.item;
        }
        else {
            return getRecursiveHelp(start.next, index - 1);
        }
    }

    public T getRecursive(int index) {
        if (index > size) {
            return null;
        }
        return getRecursiveHelp(sentinel.next, index - 1);
    }
}
