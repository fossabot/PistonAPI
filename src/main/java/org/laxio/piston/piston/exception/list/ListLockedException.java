package org.laxio.piston.piston.exception.list;

import org.laxio.piston.piston.exception.PistonRuntimeException;
import org.laxio.piston.piston.list.LockableLinkedList;

/**
 * Thrown by
 * @see LockableLinkedList
 * when an add/remove action is called on a locked List
 */
public class ListLockedException extends PistonRuntimeException {

    // empty

}
