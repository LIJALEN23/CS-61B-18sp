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
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0; i < length; i++) {
            newArray[i] = array[(front + i) % size];
        }
        size = capacity;
        array = newArray;
        front = 0;
        rear = length;
    }
    public void addFirst(T item){
        if (length == size ) {
            resize(size * 2);
        }
        if (length == 0) {
            array[front] = item;
        }
        front = (front - 1 + size) % size;
        array[front] = item;
        length++;
    }
    public void addLast(T item){
        if (length == size) {
            resize(size * 2);
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
        if (!isEmpty()) {
            System.out.print("ArrayDeque : ");
            for (int i = front; i < front + length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
        else {
            System.out.println("ArrayDeque is empty!");
        }
    }
    public T removeFirst(){
        if (!isEmpty()) {
            T val = array[front];
            length--;
            front = (front + 1 + size - 1) % size;
            return val;
        }
        return null;
    }
    public T removeLast(){
        if (!isEmpty()){
            T val = array[rear];
            length--;
            rear = (rear - 1 + size -1) % size;
            return val;
        }
        return null;
    }
    public T get(int index){
        if (index > 0 && index <= length) {
            return array[(front + index - 1) % length];
        }
        return null;
    }
}