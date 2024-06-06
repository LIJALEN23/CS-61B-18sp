package demo1;

import java.util.TreeMap;
import java.util.HashMap;

public class BiDividerMap<K, V> {
    /**设计：
     * TreeMap<K, V> keyToValue：存储键值对，并通过 headMap 方法有效地查找小于给定键的键的数量。
     * HashMap<V, K> valueToKey：存储值键对，以便通过值查找键。
     * */
    private TreeMap<K, V> keyToValue;
    private HashMap<V, K> valueToKey;

    //构造函数
    public BiDividerMap() {
        keyToValue = new TreeMap<K, V>();
        valueToKey = new HashMap<V, K>();
    }

    //插入一个键值对
    public void put(K key,V val) {
        keyToValue.put(key, val);
        valueToKey.put(val, key);
    }

    //通过键寻找值
    public V getByKey(K key) {

        return keyToValue.get(key);
    }

    //通过值寻找键
    public K getByValue(V val) {

        return valueToKey.get(val);
    }

    //返回键小于给定键的映射数量
    public int numLessThan(K key) {

        return keyToValue.headMap(key).size();
    }
}
