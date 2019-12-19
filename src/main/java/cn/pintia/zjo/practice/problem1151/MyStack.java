package cn.pintia.zjo.practice.problem1151;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyStack<Item> implements Iterable<Item> {
    private Node<Item> first; // Top of stack
    private int n; // Current size of stack
    private int capacity;  // Size of stack

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public MyStack(int capacity) {
        first = null;
        n = 0;
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public boolean isFull() {
        return n == capacity;
    }

    public int size() {
        return capacity;
    }

    public void push(Item item) {
        if (isFull()) {
            throw new NoSuchElementException("Full Stack");
        }
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        Item item = first.item; // Save item to return
        first = first.next; // Delete first node
        n--;
        return item;
    }

    /**
     * Returns (but does not remove) the item most recently added to this stack.
     *
     * @return the item most recently added to this stack
     * @throws NoSuchElementException if this stack is empty
     */
    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        return first.item;
    }

    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     *
     * @return an iterator to this stack that iterates through the items in LIFO order
     */
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator(first);
    }

    private class ListIterator implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
