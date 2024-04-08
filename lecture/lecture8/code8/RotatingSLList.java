package code8;

public class RotatingSLList<Item> extends SLList<Item> {
    /*super的构造函数*/
    public RotatingSLList() {
        super();
    }
    public void rotateRight() {
        Item val = removeLast();
        addFirst(val);
    }

    public static void main(String[] args) {
        RotatingSLList r1 = new RotatingSLList<Integer>();
        for (int i = 1; i < 7; i += 1) {
            r1.addLast(i);
        }
        r1.printList();

        r1.rotateRight();
        r1.printList();
    }
}

