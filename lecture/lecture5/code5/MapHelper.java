package code5;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MapHelper {

    public static <K, V> V get(Map<K, V> map, K key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return null;
    }

    public static <K extends Comparator<K>, V> K maxKey(Map<K, V> map) {
        List<K> keyList = map.keys();
        K largest = keyList.get(0);

        for (K k : keyList) {
            if (k.compare(k, largest) > 0) {
                largest = k;
            }
        }

        return largest;
    }

    @Test
    public void testGet() {
        Map<String, Integer> map = new ArrayMap<>();
        map.put("lijalen", 23);

        Integer actual = MapHelper.get(map,"lijalen");
        Integer expected = 23;

        assertEquals(expected, actual);
        assertEquals(null, MapHelper.get(map, "leejalen"));
    }


}
