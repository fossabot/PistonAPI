package org.laxio.piston.piston.list;

import org.junit.jupiter.api.Test;
import org.laxio.piston.piston.exception.list.ListLockedException;

import static org.junit.jupiter.api.Assertions.fail;

class LockableLinkedListTest {

    @Test
    void setLocked() {
        LockableLinkedList<TestItem> list = new LockableLinkedList<>();
        list.add(new TestItem(1));

        list.setLocked(true);

        try {
            list.add(new TestItem(2));
            fail("No exception thrown when adding item to locked list");
        } catch (ListLockedException ex) {
            // list locked, no error
        }

        list.setLocked(false);

        try {
            list.add(new TestItem(3));
        } catch (ListLockedException ex) {
            fail("Exception thrown when adding item to unlocked list");
        }
    }

}