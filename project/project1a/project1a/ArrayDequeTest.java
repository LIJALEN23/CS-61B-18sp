package project1a;

import project0.In;

public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque1 = new ArrayDeque<Integer>();


        deque1.addFirst(12);
        deque1.addFirst(23);
        deque1.addFirst(34);
        deque1.addFirst(45);
        deque1.addFirst(56);
        deque1.addFirst(67);
        deque1.addFirst(78);

        deque1.printDeque();

        deque1.addLast(23);
        deque1.addLast(34);
        deque1.addLast(45);
        deque1.addLast(56);
        deque1.addLast(67);
        deque1.addLast(78);

        deque1.printDeque();

        int first = (int) deque1.removeFirst();
        int last = (int) deque1.removeLast();

        System.out.println("first element is : " + first);
        System.out.println("last element is : " + last);

        deque1.printDeque();

        System.out.println("The size deque is " + deque1.size());

        System.out.println("The " + 5 + "th element is " + deque1.get(5) );

    }
}