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

        if( isEmpty() || t == null )
            return false;

        if (t.equals(head.data))
            return true;

        while (head.nextNode != null) {
            head = head.nextNode;
            if (t.equals(head.data))
                return true;
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

        Node<T> start = head;
        // Invalid value provided
        if (t == null) return false;

        // No duplicates allowed.
        if (contains(t))
            return false;

        // No values found, can add new element.
        if (head == null) {
            head = new Node<>(t);
            return true;
        }
        // Get to the end of the list and add new node
        while (head.nextNode != null) {
            head = head.nextNode;
        }
        head.nextNode = new Node<T>(t);
        head = start;
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

        if(contains((T)o)){
            if(head.data.equals(o)){
                if(head.nextNode == null)
                    head = null;
                else{
                    while(head.nextNode != null) {
                        head.data = head.nextNode.data;
                        head = head.nextNode;
                    }
                    head = null;
                }
            }
            return true;
        }

        return false;
    }

    /**
     * Retrieves and removes the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public T poll() {
        if(head == null){
            return null;
        }
        T pollData = head.data;
        remove(head.data);
        return pollData;
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public T peek() {
        if(head == null){
            return null;
        }
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
        // Return false if list is empty
        if(head==null) return false;

        // Create set to hold elements.
        HashSet<Node<T>> nodeSet = new HashSet<>();

        nodeSet.add(head);

        while(head.nextNode!=null){
            head = head.nextNode;
            if(nodeSet.contains(head)){
                return true;
            }
            nodeSet.add(head);
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
        MyLinkedList<T> noDupes = new MyLinkedList<>();

        if(head == null) return noDupes;

        Set<T> dupeSet = new HashSet<>();

        dupeSet.add(head.data);
        while(head.nextNode!=null){
            head = head.nextNode;
            dupeSet.add(head.data);
        }

        dupeSet.forEach(noDupes::add);
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
        // List has no values or invalid value provided.
        if(k < 0 || head == null) return null;

        int size = 0;
        Node<T> start = head;
        while(head.nextNode!=null){
            size++;
            head = head.nextNode;
        }

        // Overflow.
        if(k > size) return null;

        // Already on final index.
        if(k == 0){
            T kthToLast = head.data;
            head = start;
            return kthToLast;
        }


        head = start;
        int indexOfK = size-k;
        for(int i = 0; i < size ; i++){
            if(i == indexOfK){
                T kthToLast = head.data;
                head = start;
                return kthToLast;
            }
            head = head.nextNode;
        }

        return null;
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
