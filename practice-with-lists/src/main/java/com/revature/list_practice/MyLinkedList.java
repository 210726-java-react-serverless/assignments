package com.revature.list_practice;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple implementation of a singly linked list.
 *
 * @param <T>
 */
public class MyLinkedList<T> {

    private Node<T> head;

    public MyLinkedList() {
        super();
    }

    public MyLinkedList(Node<T> startingNode) {
        this.head = startingNode;
    }

    /**
     * Returns true if this collection contains no elements.
     *
     * @return true if this collection contains no elements
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Returns true if this collection contains the specified element. More formally,
     * returns true if and only if this collection contains at least one element e
     * such that {@code (o==null ? e==null : o.equals(e))}.
     *
     * @param t element whose presence in this collection is to be tested
     * @return true if this collection contains the specified element
     */
    public boolean contains(T t) {
        Node currentNode = this.head;
        if (this == null || this.head == null) { return false; }
        if (this.head.data.equals(t)) { return true; }
        if (!this.isEmpty()) {
            while(currentNode.nextNode != null) {
                if (currentNode.data.equals(t)) { return true; }
                currentNode = currentNode.nextNode;
            }
            return false;
        } else {
            return false;
        }
    }

    /**
     * Ensures that this collection contains the specified element (optional operation).
     * Returns true if this collection changed as a result of the call. (Returns false
     * if this collection does not permit duplicates and already contains the specified
     * element.)
     *
     * @param t element whose presence in this collection is to be ensured
     * @return true if this collection changed as a result of the call
     */
    public boolean add(T t) {
        if (t == null) { return false; }
        Node<T> addNode = new Node(t);
        Node<T> currentNode = this.head;
        if (currentNode == null) {
            this.head = addNode;
            return true;
        }
        do {
            if (currentNode.nextNode == null) {
                currentNode.nextNode = addNode;
            }
            currentNode = currentNode.nextNode;
        } while (!currentNode.equals(addNode));
        return true;
    }

    /**
     * Removes a single instance of the specified element from this collection, if
     * it is present (optional operation). More formally, removes an element e such
     * that {@code (o==null ? e==null : o.equals(e))}, if this collection contains one or more
     * such elements. Returns true if this collection contained the specified element
     * (or equivalently, if this collection changed as a result of the call).
     *
     * @param o element to be removed from this list
     * @return true if this list contained the specified element
     */
    public boolean remove(Object o) {
        Node previousNode = null;
        Node currentNode = this.head;
        if (this == null || this.head == null) { return false; }
        if (this.head.data.equals(o) && this.head.nextNode == null) {
            this.head = null;
            return true;
        }
        while (currentNode.nextNode != null) {
            if (currentNode.data.equals(o)) {
                if (previousNode != null) { previousNode.nextNode = currentNode.nextNode; }
                if (currentNode.equals(this.head)) { this.head = currentNode.nextNode; }
                currentNode = null;
                return true;
            }
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        return false;
    }

    /**
     * Retrieves and removes the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public T poll() {
        if (this == null || this.head == null) { return null; }
        Node<T> pollNode = this.head;
        this.head = pollNode.nextNode;
        return pollNode.data;
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public T peek() {
        if (this == null || this.head == null) { return null; }
        return this.head.data;
    }

    /**
     * Iterates through this list and determines whether a loop exists. A loop is
     * defined a scenario where a node within the list points to some previous node
     * in the loop.
     *
     *      list = nodeA -> nodeB -> nodeC -> nodeD -> nodeE -> nodeC
     *      containsLoop() = true
     *
     * @return true if this list contains a loop
     */
    public boolean containsLoop() {
        if (this == null || this.head == null) { return false; }
        if (this.head.nextNode == null) { return false; }
        MyLinkedList<T> copy = new MyLinkedList<>();
        Node<T> currentNode = this.head;
        while (currentNode.nextNode != null) {
            if (copy.contains(currentNode.data)) { return true; }
            copy.add(currentNode.data);
            currentNode = currentNode.nextNode;
        }
        return false;
    }

    /**
     * Iterates through this list and removes any duplicate values, leaving only one element.
     * The returned list should not be the same instance as the provided list.
     *
     *      list = [4, 4, 7, -1, -4, 4, -1, 0, 0]
     *      removeDuplicates() = [4, 7, -1, -4, 0]
     *
     */
    public MyLinkedList<T> removeDuplicates() {
        if (this == null) { return null; }
        if (this.head == null) { return new MyLinkedList<T>(); }
        MyLinkedList<T> noDupes = new MyLinkedList<T>();
        if (this.head.nextNode == null) {
            noDupes.add(this.head.data);
            return noDupes;
        }
        Node<T> currentNode = this.head;
        while (currentNode.nextNode != null) {
            if (!noDupes.contains(currentNode.data)) {
                noDupes.add(currentNode.data);
            }
            currentNode = currentNode.nextNode;
        }
        return noDupes;
    }

    /**
     * Returns the k-th to last element of this list. Think of it as reversed zero-based indexing.
     *
     *      list = ['a', 'b', 'c', 'd', 'e', 'f']
     *      k = 2
     *      getKthToLast(k) = 'd'
     *
     * @param k the k-th to last index value
     * @return the k-th to last element of this list
     */
    public T getKthToLast(int k) {
        if (this == null || this.head == null || k < 0) { return null; }
        int size = 0;
        Map<Integer, T> index = new HashMap<>();
        Node<T> currentNode = this.head;
        while (currentNode != null) {
            if (currentNode != null) {
                index.put(size, currentNode.data);
                currentNode = currentNode.nextNode;
                size++;
            }
        }
        if (k > size) { return null; }
        return index.get(size - k - 1);
    }

    /**
     * Determines if the contents of this list form a palindrome.
     *
     * @return true if the contents of this list form a palindrome
     */
    public boolean isPalindromicList() {
        throw new ImplementationMissingException(); // TODO: REPLACE THIS
    }

    static class Node<T> {
        T data;
        Node<T> nextNode;

        Node(T data) {
            this.data = data;
        }
    }

    /**
     * Determines if two lists are value equivalent to one another. No need to change this implementation.
     *
     * @param o list for comparison
     * @return true if the two lists are value equivalent to one another
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyLinkedList<?> that = (MyLinkedList<?>) o;

        Node<?> thisCurrent = this.head;
        Node<?> thatCurrent = that.head;

        while (thisCurrent != null && thatCurrent != null) {
            if (!thisCurrent.data.equals(thatCurrent.data)) {
                return false;
            }
            thisCurrent = thisCurrent.nextNode;
            thatCurrent = thatCurrent.nextNode;
        }

        return true;
    }

}
