package com.revature.list_practice;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

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
        if(head == null)
            return true;
        return false;
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
        Node<T> placeHolder = head;
        while( placeHolder!=null){
            if(placeHolder.data.equals(t))
                return true;
            placeHolder = placeHolder.nextNode;
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
        if(t == null)
            return false;

        Node<T> placeHolder = head;
        if(placeHolder==null){
            head = new Node<>(t);
            return true;
        }

        while(placeHolder.nextNode!=null){
            if(placeHolder.data.equals(t))
                return false;
            placeHolder = placeHolder.nextNode;
        }

        placeHolder.nextNode = new Node<>(t);

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
        Node<T> prev;
        Node<T> placeHolder = head;
        while(placeHolder!=null){
            prev = placeHolder;
            if(placeHolder.data.equals(o)){
                prev.nextNode = placeHolder.nextNode;
                return true;
            }
            placeHolder = placeHolder.nextNode;
        }
        return false;
    }

    /**
     * Retrieves and removes the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public T poll() {
        if(head == null)
            return null;
        T headsData = head.data;
        head = head.nextNode;
        return headsData;
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public T peek() {
        if(head == null)
            return null;
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
        Set<Node<T>> listsNodes = new HashSet<>();
        Node<T> placeHolder = head;
        if(head == null)
            return false;
        while(placeHolder != null){
            if(listsNodes.contains(placeHolder))
                return true;

            listsNodes.add(placeHolder);
            placeHolder = placeHolder.nextNode;
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
        MyLinkedList<T> newList = new MyLinkedList<>();

        if(head==null)
            return null;

        Node<T> oldNode = head;

        while(oldNode!=null){
            if(!newList.contains(oldNode.data))
                newList.add(oldNode.data);
            oldNode = oldNode.nextNode;
        }

        Node<T> arg = newList.head;

        while(arg!=null){
            System.out.print(arg.data);
            arg = arg.nextNode;
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
        if(k<0) return null;
        Node<T> placeHolder = head;
        boolean found;

        while(placeHolder != null){
            Node<T> iterateNode = placeHolder;
            int i = 0;
            found = false;
            while(iterateNode != null){
                if(iterateNode.nextNode==null&&i==k){
                    found = true;
                    break;
                }
                i++;
                iterateNode = iterateNode.nextNode;
            }
            if(found)
                return placeHolder.data;

            placeHolder = placeHolder.nextNode;
        }
        return null;
    }

    /**
     * Determines if the contents of this list form a palindrome.
     *
     * @return true if the contents of this list form a palindrome
     */
    public boolean isPalindromicList() {
        Stack<T> stack = new Stack<>();
        Node<T> placeHolder = head;
        while(placeHolder != null){
            stack.push(placeHolder.data);
            placeHolder = placeHolder.nextNode;
        }
        placeHolder = head;
        while(placeHolder!=null){
            if(placeHolder.data != stack.pop())
                return false;
            placeHolder = placeHolder.nextNode;
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
