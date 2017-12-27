package org.laxio.piston.piston.event;

import org.laxio.piston.piston.event.listener.ListenerPriority;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventHandler {

    /**
     * Used to define the priority which this method should be fired on
     *
     * @return the priority
     */
    ListenerPriority priority() default ListenerPriority.NORMAL;

    /**
     * Used to define if this method should listen to all events, including those which have been cancelled
     *
     * @return true if this method ignores cancelled events, false otherwise
     */
    boolean ignoreCancelled() default true;

}
