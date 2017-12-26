package org.laxio.piston.piston.event.listener;

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
