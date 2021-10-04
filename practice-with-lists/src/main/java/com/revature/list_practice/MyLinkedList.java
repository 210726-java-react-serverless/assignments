package com.revature.list_practice;


import java.awt.*;
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
        return this.head == null? true: false;
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
        if (this.isEmpty())
            return false;
        if (this.head.data.equals(t))
            return true;
        else {
            MyLinkedList<T> nextList = new MyLinkedList<>(this.head.nextNode);
            return nextList.contains(t);
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
        if (t == null)
            return false;
        if (this.contains(t))
            return false;
        if (this.head == null){
            this.head = new MyLinkedList.Node<>(t);
            this.head.nextNode = null;
            return true;
        }
        MyLinkedList.Node<T> node = this.head;
        while (node.nextNode != null){
            node = node.nextNode;
        }
        node.nextNode = new MyLinkedList.Node<>(t);
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
        if (this.isEmpty())
            return false;
        if (this.head.nextNode == null)
            return false;
        if (this.head.nextNode.data.equals(o)) {
            this.head.nextNode = this.head.nextNode.nextNode;
            return true;
        }
        if (this.head.data.equals(o)) {
            this.head = this.head.nextNode;
            return true;
        }else {
            this.head = this.head.nextNode;
            this.remove(o);
        } return false;
    }

    /**
     * Retrieves and removes the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public T poll() {
        if(this.isEmpty())
            return null;
        MyLinkedList.Node<T> firstNode = new MyLinkedList.Node<T>(this.head.data);
        this.remove(this.head.data);
        return firstNode.data;
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public T peek() {
        if (this.isEmpty())
            return null;
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
        MyLinkedList<T> nodeList = new MyLinkedList<>();
        MyLinkedList<T> listCopy = new MyLinkedList<>(this.head);
        if (this.isEmpty())
            return false;
        while (!nodeList.contains(listCopy.head.data)){
            if(listCopy.head.nextNode == null)
                return false;
            nodeList.add(listCopy.head.data);
            listCopy.head = listCopy.head.nextNode;
        } return true;
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
        MyLinkedList<T> noDuplicatesList = new MyLinkedList<>();
        MyLinkedList.Node<T> node = this.head;
        while (!(noDuplicatesList.contains(node.data)) && node.nextNode != null) {
            noDuplicatesList.add(node.data);
            node = node.nextNode;
        } return noDuplicatesList;
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
        MyLinkedList.Node<T> lastNode = this.head;
        MyLinkedList.Node<T> lastIter = null;
        MyLinkedList<T> reversed = new MyLinkedList<>();
        int size = 0;
        while (lastNode != null) {
            lastNode = lastNode.nextNode;
            size += 1;
        }
        if (k>size || k<0){
            return null;
        }
        for (int i=0; i<size; i++){
            MyLinkedList.Node<T> iterator = this.head;
            while (iterator.nextNode != lastIter){
                iterator = iterator.nextNode;
            }
            reversed.add(iterator.data);
            lastIter = iterator;
        }
        for (int j=0; j<k; j++){
            reversed.head= reversed.head.nextNode;
        }
        return reversed.head.data;
    }

    /**
     * Determines if the contents of this list form a palindrome.
     *
     * @return true if the contents of this list form a palindrome
     */
    public boolean isPalindromicList() {
        MyLinkedList<T> copy = new MyLinkedList<>(this.head);
        int i = 0;
        while (copy.peek() != null) {
            try {
                if (!(copy.poll().equals(this.getKthToLast(i))))
                    return false;
                i++;
            } catch (NullPointerException npe) {
                return true;
            }
        } return true;
    }

    public static class Node<T> {
        public T data;
        public Node<T> nextNode;

        public Node(T data) {
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
