/*-
 * ========================LICENSE_START========================
 * Piston API
 * %%
 * Copyright (C) 2017 - 2018 Laxio
 * %%
 * This file is part of Piston, licensed under the MIT License (MIT).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * ========================LICENSE_END========================
 */
package org.laxio.piston.piston.util.map;

import java.util.HashMap;
import java.util.Map;

/**
 * A reversible HashMash
 *
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
