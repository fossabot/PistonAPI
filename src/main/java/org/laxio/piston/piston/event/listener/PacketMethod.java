package org.laxio.piston.piston.event.listener;

import org.laxio.piston.piston.protocol.Packet;

import java.lang.reflect.Method;

public class PacketMethod extends ListenerMethod<Packet> {

    public PacketMethod(Listener listener, Method method) {
        super(listener, method);
    }

}
