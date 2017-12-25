package org.laxio.piston.piston.util.map;

import java.util.Map;

/**
 * A map that can be reversed
 * @param <K> Key type
 * @param <V> Value type
 */
public interface ReverseMap<K, V> extends Map<K, V> {

    /**
     * Swaps key and value assignment around
     * @return A reversed copy of this Map
     */
    ReverseHashMap<V, K> reverse();

}
