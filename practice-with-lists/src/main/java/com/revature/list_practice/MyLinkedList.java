package com.revature.list_practice;

import java.util.*;

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
        Node<T> ptr = head;
        while(ptr != null) {
            if(ptr.data.equals(t)) {
                return true;
            }

            ptr = ptr.nextNode;
            if(ptr == null || ptr.equals(head)) {
                //We've returned to the head node or to the end
                return false;
            }
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
        if(t == null) {
            return false;
        }

        Node<T> newNode = new Node<>(t);

        //Insert at the beginning
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
        if(o.equals(null)) {
            return false;
        }

        Node<T> prev = null;
        Node<T> ptr = head;
        while(ptr != null) {
            if(ptr.data.equals(o)) {
                if(prev != null) {
                    prev.nextNode = ptr.nextNode;
                }
                if(ptr.equals(head)) {
                    head = head.nextNode;
                }

                return true;
            }

            prev = ptr;
            ptr = ptr.nextNode;
            if(ptr == null || ptr.equals(head)) {
                //We've returned to the head node or to the end
                return false;
            }

        }

        return true;
    }

    /**
     * Retrieves and removes the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public T poll() {
        if(head == null) {
            return null;
        }

        Node<T> ptr = head;
        remove(head.data);
        return ptr.data;
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public T peek() {
        if(head == null) {
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
        int index = 0;
        //Given a node returns its index if already encountered
        Map<Node<T>, Integer> encountered = new HashMap<>();
        Node<T> ptr = head;

        while(ptr != null) {
            encountered.put(ptr, index);
            if(encountered.containsKey(ptr.nextNode)) {
                return true;
            }

            ptr = ptr.nextNode;
            index += 0;
            if(ptr == null ) {
                //We've reached the end
                return false;
            }
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
        Set<T> newSet = new HashSet<>();
        Map<T, Integer> instances = new HashMap<>();

        Node<T> ptr = head;
        while(ptr != null) {
            System.out.println(ptr.data);
            newSet.add(ptr.data);

            ptr = ptr.nextNode;
            if(ptr == null || ptr.equals(head)) {
                //We've returned to the head node or the end
                break;
            }
        }


        //Insert in reverse order
        T[] arr = (T[]) newSet.toArray();
        MyLinkedList<T> newList = new MyLinkedList<>();
        for(int i = arr.length - 1; i >= 0; i--) {
            System.out.println("VAL: " + arr[i]);
            newList.add(arr[i]);
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
        int size = 0;
        Node<T> ptr = head;
        while(ptr != null) {
            size++;

            ptr = ptr.nextNode;
            if(ptr == null || ptr.equals(head)) {
                //We've returned to the head node or the end
                break;
            }
        }

        int index = 0;
        int goal = size - k - 1;
        ptr = head;
        while(ptr != null) {
            System.out.println(ptr.data);
            if(index == goal) {
                return ptr.data;
            }

            ptr = ptr.nextNode;
            index++;
            if(ptr == null || ptr.equals(head)) {
                //We've returned to the head node or the end
                break;
            }
        }
        return null;
    }

    /**
     * Determines if the contents of this list form a palindrome.
     *
     * @return true if the contents of this list form a palindrome
     */
    public boolean isPalindromicList() {
        Deque<T> stack = new ArrayDeque<>();
        Node<T> ptr = head;
        while(ptr != null) {
            stack.add(ptr.data);

            ptr = ptr.nextNode;
            if(ptr == null || ptr.equals(head)) {
                //We've returned to the head node or to the end
                break;
            }
        }

        ptr = head;
        while(ptr != null) {
            if(!ptr.data.equals(stack.pollLast())) {
                return false;
            }

            ptr = ptr.nextNode;
            if(ptr == null || ptr.equals(head)) {
                break;
            }
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
