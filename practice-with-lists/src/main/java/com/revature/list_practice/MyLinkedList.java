package com.revature.list_practice;

import java.util.ArrayList;
import java.util.Collections;
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
        if(head.data.equals(null)){
            return true;
        } else{
            return false;
        }
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
        Node node = new Node(1);
        node = head;
        while(node.nextNode != null){
            if(node.data.equals(t)){
                return true;
            }
            node = node.nextNode;
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
        if(!contains(t)){
            Node node = new Node(t);
            if (!isEmpty()) {
                head.nextNode = node;
            }
            head = node;
            return true;
        } else{
            return false;
        }

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
        Node node = new Node(1);
        node = head;
        while(node.nextNode.nextNode != null){
            if(node.nextNode.data.equals(o)){
                node.data = null;
                node.nextNode = node.nextNode.nextNode;
                return true;
            }
            node = node.nextNode;
        }
        return false;
    }

    /**
     * Retrieves and removes the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public T poll() {
        if(isEmpty()){
            return null;
        } else{
            T result = head.data;
            head.data = null;
            head = head.nextNode;
            return result;
        }
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public T peek() {
        if(isEmpty()){
            return null;
        } else {
            return head.data;
        }
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
        Node node = new Node(1);
        node = head;
        int count = 0;
        while(node.nextNode != null){
            if(count > 1000){
                return true;
            }
            node = node.nextNode;
            count++;
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
        Node node = new Node(1);
        node = head;
        while(node != null){
            Node secondNode = new Node(1);
            secondNode = node.nextNode;
            while(secondNode != null) {
                if (node.data.equals(secondNode.data)){
                    remove(secondNode);
                }
                secondNode = secondNode.nextNode;
            }
            node = node.nextNode;
        }
        return null;
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
        Node node = new Node(1);
        node = head;
        int count = 0;
        while(node.nextNode != null){
            node = node.nextNode;
            count++;
        }
        int index = count - k;
        node = head;
        for(int i = 0; i < index; i++){
            node = node.nextNode;
        }
        return (T) node.data;
    }

    /**
     * Determines if the contents of this list form a palindrome.
     *
     * @return true if the contents of this list form a palindrome
     */
    public boolean isPalindromicList() {
        List list = new ArrayList<Object>();
        Node node = new Node(1);
        node = head;
        while(node.nextNode != null) {
            list.add(node.data);
            node = node.nextNode;
        }

       List backwards = new ArrayList();
        for (int i = 0; i < list.size(); i++){
            backwards.add(list.indexOf(i));
        }
        Collections.reverse(list);

        if(list.equals(backwards)){
            return true;
        }
        else{
            return false;
        }
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
