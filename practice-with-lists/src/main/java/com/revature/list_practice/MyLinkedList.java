package com.revature.list_practice;

import java.util.HashMap;

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
        while(!isEmpty()){
            if(head.data.equals(t)) return true;
            head = head.nextNode;
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
        if(contains(t) || t == null) return false;
        if(isEmpty()){
            head = new Node(t);
        }
        while(head.nextNode != null){
            head = head.nextNode;
        }
        head.nextNode = new Node(t);
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
        if(!contains((T) o)) return false;
        return true;
    }

    /**
     * Retrieves and removes the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public T poll() {
        if(isEmpty()) return null;

        Node<T> temp = head;

        if(head.nextNode != null){
            head = head.nextNode;
        } else {
            head = null;
        }

        return temp.data;
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public T peek() {
        if (isEmpty()) return null;
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
        HashMap<Node, Integer> map = new HashMap<>();

        if(!isEmpty()){
            map.put(head, 1);
        } else {
            return false;
        }

        while(!map.containsValue(2)){
            if(head.nextNode == null) return false;
            head = head.nextNode;
            map.computeIfPresent(head, (node, integer) -> 2);
            map.putIfAbsent(head, 1);
        }

        return true;
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
        MyLinkedList<T> newList = new MyLinkedList<>();

        HashMap<Node, Integer> map = new HashMap<>();

        if(!isEmpty()){
            map.put(head, 1);
        } else {
            return newList;
        }

        while(head.nextNode != null){
            head = head.nextNode;
            map.computeIfPresent(head, (node, integer) -> integer + 1);
            map.putIfAbsent(head, 1);
        }

        map.forEach((node, integer) -> {
            if(integer == 1){
                newList.add((T) node.data);
            }
        });
        newList.poll();
        newList.poll();

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
        if(k < 1) return null;

        Node<T> temp = head;
        int size = 1;
        while(head.nextNode != null){
            head = head.nextNode;
            size++;
        }
        head = temp;
        if(k > size) return null;

        Node<T>[] arr = new Node[size];
        for(int i = 0; i < arr.length; i++){
            arr[i] = head;
            head = head.nextNode;
        }

        return arr[arr.length-k-1].data;
    }

    /**
     * Determines if the contents of this list form a palindrome.
     *
     * @return true if the contents of this list form a palindrome
     */
    public boolean isPalindromicList() {
        Node<T> temp = head;
        int size = 1;
        while (head.nextNode != null) {
            head = head.nextNode;
            size++;
        }
        head = temp;

        Node<T>[] arr = new Node[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = head;
            head = head.nextNode;
        }
        head = temp;

        System.out.println("HELLO WORLD!");
        for (int i = 0; i < arr.length / 2; i++) {
            if (!arr[i].data.equals(arr[arr.length - i - 1].data)) return false;
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
