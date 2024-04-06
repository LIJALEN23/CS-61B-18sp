package project1a;

public class ArrayDeque<T> implements Deque<T>{
    private T[] array;
    private int size;
    private int length;
    private int front;
    private int rear;

    public ArrayDeque() {
        array = (T[])new Object[8];
        size = 8;
        length = 0;
        front = 0;
        rear = 0;
    }

    private void resize(int capacity) {
        size = capacity;
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0; i < length; i++) {
            newArray[i] = array[i];
        }
    }
    public void addFirst(T item){
        if (length == size ) {
            resize(size * 4);
        }
        front = (front - 1 + size) % size;
        array[front] = item;
        length++;
    }
    public void addLast(T item){
        if (length == size) {
            resize(size * 4);
        }
        array[rear] = item;
        rear = (rear + 1 ) % size;
        length++;
    }
    public boolean isEmpty(){
        return (length == 0);
    }
    public int size(){
        return length;
    }
    public void printDeque(){

    }
    public T removeFirst(){

        return
    }
    public T removeLast(){

    }
    public T get(int index){

    }
}
