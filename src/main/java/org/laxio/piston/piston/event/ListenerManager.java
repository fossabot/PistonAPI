package org.laxio.piston.piston.event;

import org.laxio.piston.piston.event.listener.*;
import org.laxio.piston.piston.exception.event.ListenerConfigurationException;
import org.laxio.piston.piston.protocol.Packet;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ListenerManager {

    private MethodList<Packet, PacketMethod> packet;
    private MethodList<Event, EventMethod> event;

    public ListenerManager() {
        this.packet = new MethodList<>();
        this.event = new MethodList<>();
    }

    public void call(Packet packet) {
        this.packet.call(packet);
    }

    public void call(Event event) {
        this.event.call(event);
    }

    /**
     * Registers the supplied listener, checking for any packet or event methods with handlers
     * @param listener The listener to add
     */
    public void register(Listener listener) {
        try {
            Method[] methods = listener.getClass().getMethods();

            for (Method ref : methods) {
                Class<?>[] args = ref.getParameterTypes();
                if (args.length == 1) {
                    Annotation anno = ref.getAnnotation(EventHandler.class);
                    if (anno == null) {
                        anno = ref.getAnnotation(PacketHandler.class);
                    }

                    if (anno == null) {
                        continue;
                    }

                    Class<?> cls = args[0];
                    if (anno instanceof EventHandler) {
                        EventHandler handler = (EventHandler) anno;

                        if (Event.class.isAssignableFrom(cls)) {
                            EventMethod method = new EventMethod(listener, ref, handler.ignoreCancelled());
                            event.register(listener, cls, handler.priority(), method);
                        }
                    } else {
                        PacketHandler handler = (PacketHandler) anno;

                        if (Packet.class.isAssignableFrom(cls)) {
                            PacketMethod method = new PacketMethod(listener, ref);
                            packet.register(listener, cls, handler.priority(), method);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            throw new ListenerConfigurationException(ex, listener);
        }
    }

}
