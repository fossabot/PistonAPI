package org.laxio.piston.piston.event.listener;

import org.laxio.piston.piston.event.Event;

import java.lang.reflect.Method;

public class EventMethod extends ListenerMethod<Event> {

    private final boolean ignoreCancelled;

    public EventMethod(Listener listener, Method method, boolean ignoreCancelled) {
        super(listener, method);
        this.ignoreCancelled = ignoreCancelled;
    }

    public boolean isIgnoreCancelled() {
        return ignoreCancelled;
    }

    @Override
    public void call(Event object) {
        if (object.isCancelled() && !ignoreCancelled) {
            return;
        }

        super.call(object);
    }

}
