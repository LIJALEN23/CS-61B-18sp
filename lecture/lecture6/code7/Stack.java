package code7;

public class Stack extends SLList{
    private int size;
    private SLList stack;

    public Stack() {
        stack = new SLList();
        size = 0;
    }

    public void push(int val) {
        stack.addLast(val);
        size += 1;
    }

    public int pop() {
        if (size == 0) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return stack.deleteLast();
    }

    public int top() {
        if (size == 0) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return stack.getLast();
    }
}
