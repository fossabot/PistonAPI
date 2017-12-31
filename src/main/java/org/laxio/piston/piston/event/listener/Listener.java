package org.laxio.piston.piston.event.listener;

/**
 * Handlers in classes implementing this class will be listened to by the event manager
 */
public interface Listener {

    ListenerOwner getOwner();

}
