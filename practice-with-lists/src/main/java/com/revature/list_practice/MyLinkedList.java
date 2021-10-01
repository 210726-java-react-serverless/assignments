package com.revature.list_practice;

import java.util.HashSet;
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
        head = null;
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
        Node<T> tNode = new Node<>(t);

        if(head == null) {
            return false;
        }

        while(current != null) {
            if(current.data.equals(tNode.data)) return true;
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

        if(t == null) return false;

        Node<T> current = head;
        Node<T> tNode = new Node<>(t);

        if(head == null) {
            head = tNode;
        } else {

            while(current.nextNode != null) {
//                if(current.data.equals(tNode.data)) return false; // Not allowing duplication
                current = current.nextNode;
            }

            current.nextNode = tNode;
        }

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

        if(head == null) return false;

        Node<T> previous = head;
        Node<T> current = head.nextNode;

        if(head.data.equals(o)) {
            head = head.nextNode;
            return true;
        }

        while(current != null) {

            if(current.data.equals(o)) {
                previous.nextNode = current.nextNode;
                return true;
            }

            previous = current;
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

        if(head == null) return null;

        Node<T> pollNode = head;
        head = head.nextNode;

        return pollNode.data;

    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public T peek() {

        if(head == null) return null;

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

        Node<T> current = head;
        Set<Node<T>> nodeSet = new HashSet<>();

        while(current.nextNode != null) {
            if(nodeSet.contains(current)) return true;
            nodeSet.add(current);
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

        Node<T> current = head;
        Set<T> dataSet = new HashSet<>();
        MyLinkedList<T> result = new MyLinkedList<>();

        while(current != null) {

            if(!dataSet.contains(current.data)) {
                dataSet.add(current.data);
                result.add(current.data);
            }

            current = current.nextNode;
        }

        return result;

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

        int size = getSize();

        if(k > size || k < 0) return null; // Input out of bounds

        Node<T> current = head;

        for(int i = 0; i < ((size-k)-1); i++) {
            current = current.nextNode;
        }

        return current.data;

    }

    public int getSize() {

        if(head == null) return 0;
        if(containsLoop()) return -1;

        Node<T> current = head;

        int i = 1;

        while(current.nextNode != null) {
            i++;
            current = current.nextNode;
        }

        return i;

    }

    /**
     * Determines if the contents of this list form a palindrome.
     *
     * @return true if the contents of this list form a palindrome
     */
    public boolean isPalindromicList() {

        System.out.println(this);

        if(getSize() >= 0 && getSize() < 2) return true;

        Node<T> current = head;
        Node<T> next = head.nextNode;

        Node<T> reverseHead = new Node<>(current.data);

        while(next != null) {

            Node<T> reverseCurrent = new Node<>(next.data);
            reverseCurrent.nextNode = reverseHead;

            reverseHead = reverseCurrent;

            current = current.nextNode;
            next = next.nextNode;
        }

        MyLinkedList<T> reversedList = new MyLinkedList<>(reverseHead);
        return this.equals(reversedList);
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

    @Override
    public String toString() {

        Node<T> current = head;
        String result = "[";

        while(current != null) {
            result += current.data;
            if(current.nextNode != null) result += ", ";
            current = current.nextNode;
        }

        result += "]";
        return result;

    }

}
