package demo1;

public class BadIntegerStack {
    public static class Node {
        public Integer val;
        public Node pre;

        public Node(int val, Node pre) {
            this.val = val;
            this.pre = pre;
        }
    }

    private Node top;
    private int size;

    public BadIntegerStack() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int val) {
        if (size == 100) {
            throw new IllegalStateException("The stack is full!");
        }
        top = new Node(val, top);
        size += 1;
    }

    public Integer pop() {
        if (isEmpty()) {
            throw new IllegalStateException("The stack is empty!");
        }

        int val = top.val;
        top = top.pre;
        size -= 1;

        return val;
    }

    public Integer peek() {
        if (isEmpty()) {
            throw new IllegalStateException("The stack is empty!");
        }

        return top.val;
    }
}
