package project1a;

import java.util.Arrays;
/** 5.27完成了功能的实现但是没有运用异常处理来使代码更健壮*/

public class ArrayDeque<ElementType> {

    private ElementType[] items;
    private int size;
    private int front;
    private int rear;

    public ArrayDeque() {
        items = (ElementType[]) new Object[8];
        size = 0;
        front = 3;
        rear = 3;
    }

    private void resize() {
        double usageRate =(double) size / items.length;

        if (usageRate < 0.25 || usageRate > 0.95) {
            //将数组调整到一个合适的长度
            int newCapacity = (int) (size / 0.5);
            ElementType[] newItems =(ElementType[]) new Object[newCapacity];

            //有两种情况：1. front在rear前面(它们之间的为元素数组) 2. front在rear后面(元素数组分为两部分：front到末尾，首位到rear)
            if (front <= rear) {
                System.arraycopy(items, front, newItems, 0, size );
            }

            else {
                System.arraycopy(items, front, newItems, 0, items.length - front);
                System.arraycopy(items, 0, newItems, items.length - front, rear + 1);
            }

            front = 0;
            rear = size - 1;

            items = newItems;
        }

        else {
            //数组大小不用变
            return;
        }
    }

    public void addFirst(ElementType item) {
        //数组的长度开始使用大于等于8的时候才开始调整数组以减少性能的消耗
        if (size >= 8) {
            resize();
        }

        //size等于0的时候比较特殊
        if (size == 0) {
            items[front] = item;
            size += 1;
            return;
        }

        //通用的在队列前面加元素
        front = (front - 1 + items.length) % items.length;
        items[front] = item;
        size += 1;
    }

    public void addLast(ElementType item) {
        if (size >= 8) {
            resize();
        }

        //size等于0的时候比较特殊
        if(size == 0) {
            items[rear] = item;
            size += 1;
            return;
        }

        //通用的在队列后面加元素
        rear = (rear + 1) % items.length;
        items[rear] = item;
        size += 1;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        System.out.print("The ArrayDeque is : ");

        for (int i = front,  j = 0; j < size; i = (i + 1) % items.length, j += 1) {

            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public ElementType removeFirst() {
        ElementType val = items[front];

        items[front] = null;//防止内存泄露
        front = (front + 1) % items.length;

        size -= 1;
        return val;
    }

    public ElementType removeLast() {
        ElementType val = items[rear];

        items[rear] = null;
        rear = (rear - 1 + items.length) % items.length;

        size -= 1;
        return val;
    }

    public ElementType get(int index) {
        return items[(front + index - 1) % items.length];
    }
}