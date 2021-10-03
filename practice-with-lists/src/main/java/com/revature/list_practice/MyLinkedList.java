package com.revature.list_practice;


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

        if(this.head == null){
            return true;
        }
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
        Node<T> check;
        check = head;
        while(!isEmpty()) {
            if (check.data.equals(t)) {
                return true;
            }
            if(check.nextNode != null){
                check = check.nextNode;
            } else break;
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
        if(t == null || contains(t)){return false;}
        Node<T> check = head;
        Node<T> newNode = new Node(t);

        if(isEmpty()){
            head = new Node(t);
        } else {
           while(check.nextNode != null) {
               check = check.nextNode;
           }
           check.nextNode = newNode;
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
       if(!contains((T)o) || o == null){return false;}
       Node<T> checkOne = new Node(head);
       Node<T> checkTwo = new Node(head.nextNode);
        while (checkOne != null){
            if(checkTwo == null){break;}
            if(checkTwo.data.equals(o)){
                checkOne.nextNode = checkTwo.nextNode;
                break;
            }
            checkOne = checkTwo;
            checkTwo = checkTwo.nextNode;
        }
        return true;
    }

    /**
     * Retrieves and removes the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public T poll() {
        if(isEmpty()){return null;}
        Node<T> removed;
        removed = head;
        head = head.nextNode;
        return removed.data;
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public T peek() {
        if(isEmpty()){return null;}
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
        if(isEmpty()){return false;}
        MyLinkedList<T> newList = new MyLinkedList<>();
        Node<T> check;
        check = this.head;
        int flag = 0;
        //loop through each node
        while (check != null){
            //if a duplicate appears return true
            if(newList.contains(check.data)){flag = 1; break;}
            //Otherwise add to the newList
            newList.add(check.data);
            check = check.nextNode;
        }
        if(flag == 1) {return true;}
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
        if(isEmpty()){return null;}
        MyLinkedList<T> newList = new MyLinkedList<>();
        Node<T> check;
        check = head;
        //loop through each node
        while (check != null){
            //if a duplicate appears skip it//
            if(newList.contains(check.data)){
                check = check.nextNode;
                continue;
            }
            //Otherwise add to the newList
                newList.add(check.data);
                check = check.nextNode;

        }
        System.out.println(newList);
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
        if(k < 0) {return null;}
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

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", nextNode=" + nextNode +
                    '}';
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

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                '}';
    }
}
