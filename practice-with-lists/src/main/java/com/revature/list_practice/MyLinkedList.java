package com.revature.list_practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        // Null comparison on head element.
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
        // Define nodes.
        Node<T> current = head;
        Node <T> testnode = new Node<>(t);

        // Check for null head. It's possible.
        if(head == null) { return false; }

        // Iterator, locate existing object and return if that object is matched. Otherwise, continue.
        while(current != null) {
            if (current.data.equals(testnode.data)) return true;
            current = current.nextNode;
        }

        // Loop has ended, with no success.
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
        // nullcheck t
        if (t == null) return false;

        // Define nodes.
        Node<T> current = head;
        Node<T> testnode = new Node<>(t);

        // nullcheck current
        if (current == null) {
            head = testnode;
        } else {
            // iterate. Test current.data against testnode.data.
            // return false if they match since they should not be the same. proceed if not.
            while (current.nextNode != null) {
                if (current.data.equals(testnode.data)) return false;
                current.nextNode = testnode;
            }
        }
        // added successfully.
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
        // Define. work one node ahead so that it can step back if needed.
        Node<T> current = head.nextNode;
        Node<T> previous = head;

        // nullcheck
        if (current == null) return false;
        // iterate. If the data matches, remove the reference by linking the previous node to the next node, skipping present node.
        while (current.nextNode != null) {
            if (current.data.equals(o))  {
                previous.nextNode = current.nextNode;
                return true;
            }
            if (containsLoop()) return false;
        }
        return false;
    }

    /**
     * Retrieves and removes the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public T poll() {
        // nullcheck
        if (head == null) return null;

        // save the current head for return purposes.
        final Node<T> returnHead = head;

        // set the node of head to the node past head. This erases the head node.
        head = head.nextNode;

        // return the data of returnHead. for purposes.
        return returnHead.data;
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public T peek() { if(head!=null) return head.data; else return null; }

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

        // nullcheck
        if (current == null) return false;

        // Create a history queue. Perform a contains operation to look into the list and locate an object.
        List<Node<T>> nodeSet = new ArrayList<>();
        while (current.nextNode != null) {
            nodeSet.add(current);
            if (nodeSet.contains(current)) return true;
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

        // Create a history queue. Perform a contains operation to look into the list and locate an object.
        // Put that object in a linked list. return the linked list.
        List<Node<T>> nodeSet = new ArrayList<>();
        MyLinkedList<T> returnList = new MyLinkedList<>();
        while (current.nextNode != null) {
            if (!nodeSet.contains(current))  {
                nodeSet.add(current);
                returnList.add(current.data);
            } else if (containsLoop()) {
                return new MyLinkedList<T>();
            }
        }
        return returnList;
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
        throw new ImplementationMissingException(); // TODO: REPLACE THIS
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
