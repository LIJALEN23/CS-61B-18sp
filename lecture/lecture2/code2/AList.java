package code2;

public class AList<T> {

    private T[] items;
    private int size;

    public AList() {
        items = (T[]) new Object[100];
        size = 0;
    }

    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    public void addLast(T item ) {

        if (size == items.length) {
            resize(size + 1);
        }

        items[size] = item;
        size += 1;
    }

    public T getLast() {
        return items[size - 1];
    }

    public T get(int index) {
        return items[index - 1];
    }

    public int size() {
        return size;
    }

    public T removeLast() {
        T val = items[size - 1];

        size -= 1;

        return val;
    }

}
