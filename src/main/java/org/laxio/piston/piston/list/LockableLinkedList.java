package org.laxio.piston.piston.list;

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

import org.laxio.piston.piston.exception.list.ListLockedException;

import java.util.Collection;
import java.util.LinkedList;
import java.util.function.Predicate;

/**
 * Implementation of
 *
 * @param <E>
 *
 * @see java.util.LinkedList
 * <p>
 * Using a locking system to prevent adding/removing of new items
 */
public class LockableLinkedList<E extends Object> extends LinkedList<E> {

    private final Object lock = new Object();
    private boolean locked = false;

    /**
     * Constructs an empty List
     */
    public LockableLinkedList() {
        // empty
    }

    /**
     * Constructs the LinkedList using an existing collection
     *
     * @param collection The collection to use
     */
    public LockableLinkedList(Collection<? extends E> collection) {
        super(collection);
    }

    /**
     * Constructs the LinkedList using an existing collection, setting if the List should start locked or unlocked
     *
     * @param collection The collection to use
     * @param locked     The state of the lock after constructing
     */
    public LockableLinkedList(Collection<? extends E> collection, boolean locked) {
        super(collection);
        this.locked = locked;
    }

    /**
     * Returns if the List is currently in a locked state
     *
     * @return The lock state of the List, true being locked, false being unlocked
     */
    public boolean isLocked() {
        synchronized (lock) {
            return this.locked;
        }
    }

    /**
     * Sets if the List should currently be locked (true) or unlocked (false)
     *
     * @param locked The lock state to set the list as
     */
    public LockableLinkedList<E> setLocked(boolean locked) {
        synchronized (lock) {
            this.locked = locked;
        }

        return this;
    }

    /**
     * {@inheritDoc}
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
     * @throws ListLockedException If the List is currently locked
     */
    @Override
    public E remove() {
        if (isLocked())
            throw new ListLockedException();

        return super.remove();
    }

}
