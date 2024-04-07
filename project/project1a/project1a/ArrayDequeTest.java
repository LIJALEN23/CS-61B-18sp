package project1a;

import project0.In;

public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque d1 = new ArrayDeque<Integer>();

//        for (int i = 8; i <= 16; i++) {
//            d1.addLast(i);
//        }
//        d1.printDeque();

        for (int j = 9; j >= 1; j--) {
            d1.addFirst(j);
        }
        d1.printDeque();
    }
}
