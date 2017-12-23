package org.laxio.piston.piston.list;

import org.laxio.piston.piston.exception.list.ListLockedException;

import java.util.Collection;
import java.util.LinkedList;
import java.util.function.Predicate;

/**
 * Implementation of
 * @see java.util.LinkedList
 *
 * Using a locking system to prevent adding/removing of new items
 *
 * @param <E>
 */
public class LockedLinkedList<E extends Object> extends LinkedList<E> {

    private boolean locked = false;

    /**
     * Constructs an empty List
     */
    public LockedLinkedList() {
        // empty
    }

    /**
     * Constructs the LinkedList using an existing collection
     * @param collection The collection to use
     */
    public LockedLinkedList(Collection<? extends E> collection) {
        super(collection);
    }

    /**
     * Constructs the LinkedList using an existing collection, setting if the List should start locked or unlocked
     * @param collection The collection to use
     * @param locked The state of the lock after constructing
     */
    public LockedLinkedList(Collection<? extends E> collection, boolean locked) {
        super(collection);
        this.locked = locked;
    }

    /**
     * Returns if the List is currently in a locked state
     * @return The lock state of the List, true being locked, false being unlocked
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * Sets if the List should currently be locked (true) or unlocked (false)
     * @param locked The lock state to set the list as
     */
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    /**
     * {@inheritDoc}
     * @throws ListLockedException If the List is currently locked
     */
    @Override
    public boolean add(E e) {
        if (isLocked())
            throw new ListLockedException();

        return super.add(e);
    }

    /**
     * {@inheritDoc}
     * @throws ListLockedException If the List is currently locked
     */
    @Override
    public boolean remove(Object o) {
        if (isLocked())
            throw new ListLockedException();

        return super.remove(o);
    }

    /**
     * {@inheritDoc}
     * @throws ListLockedException If the List is currently locked
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (isLocked())
            throw new ListLockedException();

        return super.addAll(c);
    }

    /**
     * {@inheritDoc}
     * @throws ListLockedException If the List is currently locked
     */
    @Override
    public void addFirst(E e) {
        if (isLocked())
            throw new ListLockedException();

        super.addFirst(e);
    }

    /**
     * {@inheritDoc}
     * @throws ListLockedException If the List is currently locked
     */
    @Override
    public void addLast(E e) {
        if (isLocked())
            throw new ListLockedException();

        super.addLast(e);
    }

    /**
     * {@inheritDoc}
     * @throws ListLockedException If the List is currently locked
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (isLocked())
            throw new ListLockedException();

        return super.addAll(index, c);
    }

    /**
     * {@inheritDoc}
     * @throws ListLockedException If the List is currently locked
     */
    @Override
    public void add(int index, E element) {
        if (isLocked())
            throw new ListLockedException();

        super.add(index, element);
    }

    /**
     * {@inheritDoc}
     * @throws ListLockedException If the List is currently locked
     */
    @Override
    public E removeFirst() {
        if (isLocked())
            throw new ListLockedException();

        return super.removeFirst();
    }

    /**
     * {@inheritDoc}
     * @throws ListLockedException If the List is currently locked
     */
    @Override
    public E removeLast() {
        if (isLocked())
            throw new ListLockedException();

        return super.removeLast();
    }

    /**
     * {@inheritDoc}
     * @throws ListLockedException If the List is currently locked
     */
    @Override
    public boolean removeLastOccurrence(Object o) {
        if (isLocked())
            throw new ListLockedException();

        return super.removeLastOccurrence(o);
    }

    /**
     * {@inheritDoc}
     * @throws ListLockedException If the List is currently locked
     */
    @Override
    public boolean removeFirstOccurrence(Object o) {
        if (isLocked())
            throw new ListLockedException();

        return super.removeFirstOccurrence(o);
    }

    /**
     * {@inheritDoc}
     * @throws ListLockedException If the List is currently locked
     */
    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        if (isLocked())
            throw new ListLockedException();

        return super.removeIf(filter);
    }

    /**
     * {@inheritDoc}
     * @throws ListLockedException If the List is currently locked
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        if (isLocked())
            throw new ListLockedException();

        return super.removeAll(c);
    }

    /**
     * {@inheritDoc}
     * @throws ListLockedException If the List is currently locked
     */
    @Override
    public E remove(int index) {
        if (isLocked())
            throw new ListLockedException();

        return super.remove(index);
    }

    /**
     * {@inheritDoc}
     * @throws ListLockedException If the List is currently locked
     */
    @Override
    public E remove() {
        if (isLocked())
            throw new ListLockedException();

        return super.remove();
    }

}
