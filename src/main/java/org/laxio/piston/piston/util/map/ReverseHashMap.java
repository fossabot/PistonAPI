package org.laxio.piston.piston.util.map;

import java.util.HashMap;
import java.util.Map;

/**
 * A reversible HashMash
 * @param <K> Key type
 * @param <V> Value type
 */
public class ReverseHashMap<K, V> extends HashMap<K, V> implements ReverseMap<K, V> {

    public ReverseHashMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public ReverseHashMap(int initialCapacity) {
        super(initialCapacity);
    }

    public ReverseHashMap() {
        super();
    }

    public ReverseHashMap(Map<? extends K, ? extends V> m) {
        super(m);
    }

    @Override
    public ReverseHashMap<V, K> reverse() {
        ReverseHashMap<V, K> reversed = new ReverseHashMap<>();
        for (Entry<K, V> entry : entrySet()) {
            reversed.put(entry.getValue(), entry.getKey());
        }

        return reversed;
    }

}
