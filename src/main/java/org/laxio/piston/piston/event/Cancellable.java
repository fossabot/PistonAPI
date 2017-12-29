package org.laxio.piston.piston.event;

public interface Cancellable {

    boolean isCancelled();

    void setCancelled(boolean cancelled);

}
