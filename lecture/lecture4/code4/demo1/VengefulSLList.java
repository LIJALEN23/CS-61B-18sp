package code4.demo1;

public class VengefulSLList<Item> extends SLList<Item> {
    public SLList deletedItems;

    public VengefulSLList() {
        super();
        deletedItems = new SLList<Item>();
    }

    @Override
    public Item removeLast() {
        Item val = super.removeLast();

       deletedItems.addLast(val);

        return val;
    }

    public void printDeletedItems() {
        deletedItems.print();
    }

    public static void main(String[] args) {
        VengefulSLList<Integer> list = new VengefulSLList<>();
        
        list.addLast(12);

        list.addLast(23);
        list.addLast(34);
        list.addLast(45);
        list.addLast(56);
        list.addLast(67);

        list.print();

        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeLast();

        list.printDeletedItems();
    }
}
