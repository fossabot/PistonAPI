package org.laxio.piston.piston.event.listener;

public interface ListenerOwner {

    String getName();

    void handle(Exception ex);

}
