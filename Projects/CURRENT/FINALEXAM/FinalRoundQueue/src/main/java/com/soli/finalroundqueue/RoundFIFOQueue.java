//////////////////// !!! SEE OTHER CLASS !!!



package com.soli.finalroundqueue;

import java.util.Iterator;
/*
class RoundFIFOQueue<T extends Comparable> implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private class Node {
        T value;
        Node next;
        int debugId; // optional, for debugging only
    }

    private Node enqueue;
    private Node dequeue;
    private Node prequeue;
    private int size;
    private int maxSize; // maxSize is assigned in the constructor
    private boolean growable = false;
    
    // CONSTRUCTOR
    public RoundFIFOQueue(int maxSize) {
        
        this.maxSize = maxSize; 
        // * allocate maxSize of Nodes and as you're doing it
        // * link them up with next references
        // * point enqueue & dequeue to one of these nodes
        // 
        // Suggestion: for debugging purposes give each Node a debugId (0, 1, 2...)
        // so that when you're looking at data in memory or printing them out
        // you can tell which Node is which
        //
        // Suggestion: use debugger to verify that you ineed have linked up all nodes in a circle
        // before continuing with this task. If you did not then the rest of your code won't work.
    
    }

    public void printQueue() {
        // for debugging only but required as a part of your solution
        // print out each Node's content on a separate line
        // starting with eneuque reference, following next reference maxSize (or probably maxSize-1) times.
        // after the loop is done you should be back at eneuque - check that and if you're not
        // throw new RuntimeException("Internal error: queue may not be circular");
        // example line of output for node with debugId=2, value="Joe" (String type):
        // Node #0: Joe
    }
    
    // puts value into the queue
	// throws RuntimeException("No space in the queue") if queue is full
	// unless "grow" is set to true, in which case you can create a new Node so you can insert more than current maxSize
	// if you do - you need to update maxSize as well.
//	public void enque(T value, boolean grow) { ... }
	
	// removes and returns value from the queue (in FIFO order)
	// throws RuntimeException("Queue is empty") if queue is empty
	// sets value reference to null of the Node whose value will be returned
//	public T deque() { ... }
	
	public int size() { return size; }
	
	// returns array of "size" number of elements with most recently enqueued elements first (following "next" references)
//	public T[] toArray(T[] template) { ... }

	// checks if value is present in Queue and returns the number of occurrences of that value (0 if not found)
	// must use n.compareTo(v) == 0, not equals()
//	public int countValues(T value) { ... }

	// also implement methods required by Iterable interface (and test it in Unit tests)

}

/*
	25% of the value of this task will be for JUnit tests.
	
	You must write unit tests that *prove* that your implementation works correctly.
	
	Remember to test your iterator, two behaviours of equeue, exception throwing, and
	have many cases where you enqueu/deque more items than max Queue (e.g. max queue is 5, you enque 4 items, deque 3, agaqin enque 4)

	Your grade will depend mostly on the coverage of tests, that is, how well they
	exercise different cases and paths through the code, different combination of method call sequences.
	Remember to also test for exceptions.
	
	You DO NOT need to test printQueue() method.


 */   

