package code4;

public class RotatingSLList<Item> extends SLList<Item> {

    public void rotatingRight() {
        Item val = removeLast();
        addFirst(val);
    }

    public static void main(String[] args) {
        RotatingSLList<Integer> list = new RotatingSLList<>();

        list.addFirst(12);
        list.addFirst(23);
        list.addFirst(34);
        list.addFirst(45);
        list.addFirst(56);
        list.print();

        list.rotatingRight();
        list.print();
    }
}
