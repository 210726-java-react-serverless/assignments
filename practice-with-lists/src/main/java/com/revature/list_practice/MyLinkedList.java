package com.revature.list_practice;


import java.util.ArrayList;
import java.util.HashSet;

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
        return(head == null);
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
        boolean ret = false;
        //If head is null, return false.
        //Otherwise iterate through
        if (head != null) {
            Node<T> temp = head;
            while (temp != null) {
                if (temp.data == t) {
                    ret = true;
                    break;
                }
                temp = temp.nextNode;
            }
        }
        return ret;
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
        boolean ret = false;
        //Exit early if it already exists in the collection
        if(!this.contains(t)){
            //Append the item to the front of the list
            if (t != null) {
                MyLinkedList.Node<T> nodeA = new MyLinkedList.Node<T>(t);
                nodeA.nextNode = head;
                head = nodeA;
                ret = true;
            }
        }
        return ret;
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
    public boolean remove(T o) {
        boolean ret = false;
        //Exit early if it already exists in the collection
        if(this.contains(o)){
            ret = true;
            Node<T> temp = head;
            if (head.data == o) {
                head = null;
            }
            else {
                while (head.nextNode != null) {
                    if (head.nextNode.data == o) {
                        if (head.nextNode.nextNode != null) {
                            head.nextNode = head.nextNode.nextNode;
                        }
                        else
                            head.nextNode = null;
                    }
                    head = head.nextNode;
                }
            }
            head = temp;
        }
        return ret;
    }

    /**
     * Retrieves and removes the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public T poll() {
        T ret;
        if (head != null) {
            ret = head.data;
            head = head.nextNode;
        }
        else ret = null;
        return ret;
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public T peek() {
        return head == null ? null : head.data;
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
        //Let's do it correctly, tortoise and hare algorithm.
        //https://en.wikipedia.org/wiki/Cycle_detection#Tortoise_and_hare
        Node<T> tortoise = head;
        Node<T> hare = head;
        boolean ret = false;
        while (head != null)
        {
            tortoise = tortoise.nextNode;
            if (hare.nextNode != null)
                hare = hare.nextNode.nextNode;
            else break;
            if (tortoise == null || hare == null)
                break;
            if (tortoise.data == hare.data) {
                ret = true;
                break;
            }
        }
        return ret;
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
        HashSet<T> removeDupes = new HashSet<T>();
        Node<T> temp = head;
        //Iterate over the list and add everything to a set
        while (temp != null)
        {
            removeDupes.add(temp.data);
            temp = temp.nextNode;
        }
        //Create a new linked list from the set
        MyLinkedList.Node<T> tempNode = null;
        MyLinkedList.Node<T> headNode = null;
        for (T element : removeDupes) {
            MyLinkedList.Node<T> newNode = new MyLinkedList.Node<T>(element);
            if (tempNode != null)
            {
                tempNode.nextNode = newNode;
                tempNode = newNode;
            }
            else
            {
                tempNode = newNode;
                headNode = newNode;
            }
        }
        MyLinkedList ret = new MyLinkedList(headNode);
        return ret;
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
        T ret;
        int size=0;
        Node<T> temp = head;

        //Get the size of the linked list
        while (temp != null)
        {
            size++;
            temp = temp.nextNode;
        }
        temp = head;

        //Go to the kth-last link
        if (k < size && k >= 0) {
            for (int i = 0; i < size - k - 1; i++) {
                temp = temp.nextNode;
            }
            ret = temp.data;
        }
        //Unless k is too big or negative in which case it's null
        else
            ret = null;

        return ret;
    }

    /**
     * Determines if the contents of this list form a palindrome.
     *
     * @return true if the contents of this list form a palindrome
     */
    public boolean isPalindromicList() {
        ArrayList<T> palindromicList = new ArrayList<T>();
        int count = 0;
        Node<T> temp = head;
        //Iterate over the list and add everything to an ArrayList
        while (temp != null)
        {
            palindromicList.add(temp.data);
            temp = temp.nextNode;
            count++;
        }
        //Iterate over the ArrayList and compare both sides
        //If the count is odd it won't compare the middle but that's okay
        for(int i=0; i<count/2; i++)
        {
            if (palindromicList.get(i) != palindromicList.get(count-1-i))
                return false;
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
