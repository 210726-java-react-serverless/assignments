package com.revature.list_practice;

import java.lang.reflect.Type;
import java.util.*;

/**
 * A simple implementation of a singly linked list.
 *
 * @param <T>
 */
public class MyLinkedList<T> {

    private Node<?> head;

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

       if( head == null || head.data == null )
       {
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

        Node<?> scanner_sperlunkerNode = head;
        while(scanner_sperlunkerNode.nextNode != null)
        {
            if(t.equals(scanner_sperlunkerNode.data))
                return true;

                scanner_sperlunkerNode = scanner_sperlunkerNode.nextNode;
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
        if(head == null || head.nextNode == null)
        {
            return false;
        }
        Node<?> packer_node = new Node<>(t);
        packer_node.nextNode = (Node<?>) head;

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

        Node<?> the_hitman_Node = head;
        while(the_hitman_Node.nextNode != null)
        {
            if(o.equals(the_hitman_Node.data))
            {
                o = null;
                return true;
            }
            the_hitman_Node = the_hitman_Node.nextNode;
        }
        return false;
    }

    /**
     * Retrieves and removes the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public T poll() {
        Node<?> perseus_Node = head;
        if(head == null || perseus_Node.data == null)
        {
            return null;
        }else {
            Node<?> medusa_Node = head;
            head = head.nextNode;
            return (T) medusa_Node.data;
        }

    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public T peek() {

        Node<?> crown_Node = head;
        if( head == null || crown_Node.data == null)
        {
            return null;
        }else {

            return (T) head.data;
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
        //detects loops
        Node<?> the_matrix_node =head;
        //reference
        HashSet<Node> ref = new HashSet<>();
        int frames = 0;
        while (the_matrix_node.nextNode != null)
        {
            // if the set contains current node we know we have encountered this node b4
            if(ref.contains(the_matrix_node))
                return true;
                the_matrix_node = the_matrix_node.nextNode;
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

        // array to store the LL elements
        MyLinkedList<Object> candidates = new MyLinkedList<>();
        int num_of_candidates = 0;

        // Current comparison
        Object memory = head.data;

        //this node serveyys the list
        Node<?> clone_hunter_Node = head;

        // populating list
        while(clone_hunter_Node.nextNode != null)
        {

            candidates.add(clone_hunter_Node);
                num_of_candidates ++;
        }
        // check if list contains loop
        if(candidates.containsLoop())
        {
            return null;
        }

        //resetting clone hunter node
        clone_hunter_Node = head;
        // this node holds the current comparison
        Node<?> wanted_poster_Node = candidates.head;
        int i = 0;
        // walk through list and find duplicate nodes
        while(i != num_of_candidates * num_of_candidates)
        {
            // if one whole loop of the list is completed
            if(num_of_candidates % i == 0)
            {
                // return node to head
                clone_hunter_Node = head;
                // move on to next comparison
                wanted_poster_Node = wanted_poster_Node.nextNode;
            }
            //if comparison is duplicate
            if(clone_hunter_Node.data.equals(wanted_poster_Node.data))
            {
                //remove duplicate from list
                candidates.remove(wanted_poster_Node);
            }
            clone_hunter_Node = clone_hunter_Node.nextNode;
            i++;
        }

        return (MyLinkedList<T>) candidates;
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

        if(k <= 0 || k >= 500)
        {
            return null;
        }
        //thiss node clears the path ahead k units infront of trail
        Node<?> tank_sperlunkerNode = head;
        // stays k units behind tank
        Node<?> trail_sperlunkerNode = head;

        // frames until trail starts
        int units_till_follow = 0;

        while(tank_sperlunkerNode.nextNode != null)
        {
              // trail only moves when k units away from tank
             if(units_till_follow >= k)
             {
                 trail_sperlunkerNode = trail_sperlunkerNode.nextNode;
             }
            // tank moves no matter what
            tank_sperlunkerNode = tank_sperlunkerNode.nextNode;
             units_till_follow++;
        }

        return (T) trail_sperlunkerNode.data;

    }

    /**
     * Determines if the contents of this list form a palindrome.
     *
     * @return true if the contents of this list form a palindrome
     */
    public boolean isPalindromicList() {
        // ig nuthing is identical to nuthing
        if(head == null)
        {
            return true;
        }

        List<Object> goldNodes = new ArrayList<>();
        //this node tunnels into headNode
        Node<?> sperlunkerNode = head;

        // tunnel thruogh list till we hit the end
        while(sperlunkerNode.nextNode != null )
        {
            goldNodes.add(sperlunkerNode.data);
            sperlunkerNode = sperlunkerNode.nextNode;

        }

        //reverse array
        Object[] sedoNdlog = goldNodes.toArray();
        int start = 0;
        int end = sedoNdlog.length;
        Object hold = 0;
        while(start < end)
        {
            hold = sedoNdlog[start];
            sedoNdlog[start] = sedoNdlog[end];
            start++;
            end--;
        }
        //compare
        for (int i = 0 ; i < sedoNdlog.length ; i++)
        {
            if(sedoNdlog[i].equals(goldNodes.get(i)) == false)
            {
                return sedoNdlog[i].equals(goldNodes.get(i)) == false;
            }
        }

        return true;
    }

    static class Node<T> {
        T data;
        Node<?> nextNode;

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
