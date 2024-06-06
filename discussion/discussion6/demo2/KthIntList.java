package demo2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class KthIntList implements Iterator <Integer> {
    public static class IntList {
        public int head;
        public IntList tail;

        public IntList(int head, IntList tail) {
            this.head = head;
            this.tail = tail;
        }
    }
    public int k;
    private IntList curList;
    private boolean hasNext;

    public KthIntList(IntList list, int k) {
        curList = list;
        this.k = k;
        hasNext = (curList != null);
    }
    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public Integer next() {
        if (!hasNext) {
            throw new NoSuchElementException();
        }

        Integer result = curList.head;
        for (int i = 0; i < k; i++) {
            if (curList.tail != null) {
                curList = curList.tail;
            }
            else {
                hasNext = false;
                break;
            }
        }
        return result;
    }
}
