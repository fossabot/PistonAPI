package org.laxio.piston.piston.event.listener;

import org.laxio.piston.piston.exception.event.ListenerConfigurationException;

import java.lang.reflect.Method;

public class ListenerMethod<T> {

    private final Listener listener;
    private final Method method;

    public ListenerMethod(Listener listener, Method method) {
        this.listener = listener;
        this.method = method;
    }

    public Listener getListener() {
        return listener;
    }

    public Method getMethod() {
        return method;
    }

    /**
     * Invokes the method using the supplied object
     * @param object The object to invoke as an argument
     */
    public void call(T object) {
        try {
            method.invoke(listener, object);
        } catch (Exception ex) {
            throw new ListenerConfigurationException("Listener method not configured correctly", ex, listener);
        }
    }

}
