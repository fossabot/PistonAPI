package org.laxio.piston.piston.event.listener;

        /*-
         * #%L
         * Piston API
         * %%
         * Copyright (C) 2017 Laxio
         * %%
         * This file is part of Piston, licensed under the MIT License (MIT).
         *
         * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
         *
         * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
         *
         * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
         * #L%
         */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodList<T, M extends ListenerMethod<T>> {

    private List<Listener> listeners;
    private Map<Class<?>, Map<ListenerPriority, List<M>>> methods;

    public MethodList() {
        this.listeners = new ArrayList<>();
        this.methods = new HashMap<>();
    }

    public List<Listener> getListeners() {
        return listeners;
    }

    public void call(T type) {
        Map<ListenerPriority, List<M>> map = new HashMap<>();
        for (Map.Entry<Class<?>, Map<ListenerPriority, List<M>>> entry : methods.entrySet()) {
            if (entry.getKey().isAssignableFrom(type.getClass())) {
                Map<ListenerPriority, List<M>> value = entry.getValue();
                for (Map.Entry<ListenerPriority, List<M>> entry2 : value.entrySet()) {
                    map.computeIfAbsent(entry2.getKey(), k -> new ArrayList<>()).addAll(entry2.getValue());
                }
            }
        }

        for (ListenerPriority priority : ListenerPriority.values()) {
            List<M> methods = map.computeIfAbsent(priority, k -> new ArrayList<>());

            for (M method : methods) {
                method.call(type);
            }
        }
    }

    public void register(Listener listener, Class<?> cls, ListenerPriority priority, M method) {
        Map<ListenerPriority, List<M>> map = methods.computeIfAbsent(cls, k -> new HashMap<>());
        List<M> list = map.computeIfAbsent(priority, k -> new ArrayList<>());
        list.add(method);

        listeners.add(listener);
    }

}
