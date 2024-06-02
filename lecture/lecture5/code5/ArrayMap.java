package code5;

import org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import org.junit.Test;

import static org.junit.Assert.*;
public class ArrayMap<K, V> implements Map <K, V>{
    private K[] keys;
    private V[] vals;
    int size;

    public ArrayMap() {
        keys = (K[]) new Object[100];
        vals = (V[]) new Object[100];
        size = 0;
    }

    private int keyIndex(K key) {
         for (int i = 0; i < size; i++) {
             if (keys[i].equals(key)) {
                 return i;
             }
         }
         return -1;
    }
    @Override
    public boolean containsKey(K key) {
        int index = keyIndex(key);
        return index > -1;
    }

    @Override
    public void put(K key, V val) {
        int index = keyIndex(key);
        if (index == -1) {
            keys[size] = key;
            vals[size] = val;
            size += 1;
            return;
        }

        //根据键的定义，这一步是多余的
//        keys[index] = key;
        vals[index] = val;
    }

    @Override
    public V get(K key) {
        int index = keyIndex(key);
        if (index == -1) {
            throw new IllegalArgumentException("The key provided " + key + " was not in the ArrayMap.");
        }

        return vals[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<K> keys() {
        List<K> keyList = new ArrayList<>();
        for (int i = 0; i < keys.length; i++) {
            keyList.add(keys[i]);
        }
        return keyList;
    }

    @Test
    public void test() {
        ArrayMap<Integer, Integer> map = new ArrayMap<>();

        map.put(12, 23);

        int expected = 23;

        assertEquals((Integer) expected, map.get(12));
    }

    public static void main(String[] args) {
        ArrayMap<String, Integer> map = new ArrayMap<>();

        map.put("lijalen", 23);
        map.put("leejalen", 45);
        map.put("lijalen", 12);

    }
}
