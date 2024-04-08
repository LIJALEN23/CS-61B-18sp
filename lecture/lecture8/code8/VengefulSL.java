package code8;

public class VengefulSL<Item> extends SLList<Item> {
    SLList<Item> deleteItems;
    public VengefulSL() {
        super();
        deleteItems = new SLList<Item>();
    }
    @Override
    public Item removeLast() {
        Item v = super.removeLast();
        deleteItems.addLast(v);
        return v;
    }
    public void printDeleteItems() {
        deleteItems.printList();
    }
}
