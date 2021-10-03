package com.revature.list_practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        return head == null;
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
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(t)) return true;
            current = current.nextNode;
        }
        return false;
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
        if (t == null || contains(t)) return false;
        if (head == null) {
            head = new Node<>(t);
            return true;
        }
        MyLinkedList.Node<T> newNode = new MyLinkedList.Node<>(t);
        newNode.nextNode = head;
        head = newNode;
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
        Node<T> current = head;
        while (current != null) {
            if (current.data == o) {
                current.data = null;
                return true;
            }
            current = current.nextNode;
        }
        return false;
    }

    /**
     * Retrieves and removes the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public T poll() {
        if (head == null) return null;
        T data = head.data;
        head = head.nextNode;
        return data;
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public T peek() {
        if (head == null) return null;
        return head.data;
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
        if (head == null) return false;

        Node<T> current = head;
        Set<Node<T>> nodes = new HashSet<>();

        while (current != null) {
            if (nodes.contains(current)) return true;
            nodes.add(current);
            current = current.nextNode;
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
        if (head == null) return null;
        MyLinkedList<T> newList = new MyLinkedList<>();
        Set<T> nodes = new HashSet<>();
        Node<T> current = head;
        while (current != null) {
            if (!nodes.contains(current.data)) {
                Node<T> temp = new Node<>(current.data);
                newList.add(temp.data);
                nodes.add(temp.data);
            }
            current = current.nextNode;
        }
        return newList;
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
        if (k < 0) return null;
        Node<T> current = head;
        Node<T> node = head;
        int gap = -1;

        while (node != null) {
            if (gap == k) current = current.nextNode;
            else gap++;
            node = node.nextNode;
        }

        if (gap < k) return null;
        return current.data;
    }

    /**
     * Determines if the contents of this list form a palindrome.
     *
     * @return true if the contents of this list form a palindrome
     */
    public boolean isPalindromicList() {
        List<T> list = new ArrayList<>();
        while (head != null) {
            list.add(head.data);
            head = head.nextNode;
        }

        int length = list.size() - 1;
        int j = length;
        for (int i = 0; i < length / 2; i++) {
            if (!list.get(i).equals(list.get(j--))) return false;
        }
        return true;
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

        do {
            if (!thisCurrent.data.equals(thatCurrent.data)) {
                return false;
            }
            thisCurrent = thisCurrent.nextNode;
            thatCurrent = thatCurrent.nextNode;
        }
        while (thisCurrent != null && thatCurrent != null);

        return true;
    }

}
