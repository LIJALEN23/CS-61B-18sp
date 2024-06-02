package code6;

import java.util.Iterator;

public class ArraySet<T> implements Iterable<T>{
    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map.
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if (x == null) {
            return;
        }
//        if (x == null) {
//            throw new IllegalArgumentException("can't add null!");
//        }

        if (contains(x)) {
            return;
        }
        items[size] = x;
        size += 1;
        return;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T> {
        private int widPos;

        public ArraySetIterator() {
            widPos = 0;
        }

        public boolean hasNext() {
            return widPos < size;
        }

        public T next() {
            T val = items[widPos];
            widPos += 1;
            return val;
        }

//        @Override
//        public String toString() {
//            String returnString = "[";
//
//            for (int i = 0; i < size - 1; i++) {
//                returnString += items[i].toString;
//                returnString += ", ";
//            }
//            returnString += items[size - 1];
//            returnString += ", ";
//
//            return returnString;
//        }


    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder("[");

        for (int i = 0; i < size - 1; i++) {
            returnString.append(items[i].toString());
            returnString.append(", ");
        }
        returnString.append(items[size - 1]);
        returnString.append(']');

        return returnString.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null) {
            return false;
        }

        ArraySet<T> o = (ArraySet<T>) other;

        for (T val : this) {
            if (!o.contains(val)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArraySet<String> s = new ArraySet<>();
        s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");
        System.out.println(s.contains("horse"));
        System.out.println(s.size());
        for (String i : s) {
            System.out.println(i);
        }
        String str = s.toString();
        System.out.println(str);
    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}
