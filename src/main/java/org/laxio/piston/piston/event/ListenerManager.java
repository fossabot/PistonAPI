package org.laxio.piston.piston.event;

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

import org.laxio.piston.piston.event.listener.EventMethod;
import org.laxio.piston.piston.event.listener.Listener;
import org.laxio.piston.piston.event.listener.MethodList;
import org.laxio.piston.piston.event.listener.PacketMethod;
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
     *
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
