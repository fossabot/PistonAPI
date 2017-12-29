package org.laxio.piston.piston.event;

public class CancellableEvent implements Event, Cancellable {

    private boolean cancelled = false;

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

}
