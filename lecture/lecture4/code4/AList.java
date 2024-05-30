package code4;

import java.awt.*;

public class AList<Item> implements List61B<Item> {

    private Item[] items;

    private int size;

    public AList() {
        //不能直接使用new Item[] 要通过new Object[]后再强制转化成Item
        items = (Item[]) new Object[100];
        size = 0;
    }

    private void resize(int newSize) {
        Item[] newItems = (Item[]) new Object[newSize];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    @Override
    public void addFirst(Item x) {
        if (size == items.length) {
            resize(size + 10);
        }

        System.arraycopy(items, 0, items, 1, size);
        items[0] = x;
    }

    @Override
    public void addLast(Item y) {
        if (size == items.length) {
            resize(size + 10);
        }

        items[size] = y;
    }

    @Override
    public Item getFirst() {
        return items[0];
    }

    @Override
    public Item getLast() {
        return items[size - 1];
    }

    @Override
    public Item removeLast() {
        Item val = items[size - 1];
        size -= 1;

        return val;
    }

    @Override
    public Item get(int i) {
        return items[i - 1];
    }

    @Override
    public void insert(Item x, int position) {
        if (size == items.length) {
            resize(size + 10);
        }


        System.arraycopy(items, position - 1, items, position, size - position + 1);

        items[position - 1] = x;
    }

    @Override
    public int size() {
        return size;
    }
}
