package code5;

import java.util.List;

public interface Map <K, V>{
    public boolean containsKey(K key);

    public void put(K key, V val);

    public V get(K key);

    public int size();

    public List<K> keys();
}
