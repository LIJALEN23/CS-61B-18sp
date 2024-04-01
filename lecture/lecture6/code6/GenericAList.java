package code6;

public class GenericAList<Item> {
    private Item[] items;
    private int size;

    public GenericAList() {
        items = (Item[]) new Object[100];
        size = 0;
    }
    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, temp, 0, size);
        items = temp;
    }

    public void addList(Item x) {
        if (items.length == size){
            resize(size * 4);
        }
        items[size] = x;
        size += 1;
    }

    public Item getLast() {
        return items[size - 1];
    }

    public Item get(int i) {
        return items[i];
    }

    public int size(){
        return size;
    }

    public Item removeLast() {
        Item x = items[size - 1];
        size -= 1;
        return x;
    }
}