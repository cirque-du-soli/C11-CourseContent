package com.soli.finalroundqueue;

import java.util.Iterator;

class RoundFIFOQueueString implements Iterable<String> {

    @Override
    public Iterator<String> iterator() {
        
        return new Iterator<String>() {
            
            String[] template = new String[maxSize];
            String [] data = toArray(template);
            
            int nextItemIndex = 0;
            
            @Override
            public boolean hasNext() {
                return (nextItemIndex < data.length);
            }

            @Override
            public String next() {
                return data[nextItemIndex++];
            }
        };
    }

    
    private class Node {
        String value;
        Node next;
        int debugId; // optional, for debugging only
        // Node prev; not allowed :(
    }

    private Node enqueue;
    private Node dequeue;
    private Node prequeue;
    private int size;
    private int maxSize; // maxSize is assigned in the constructor
    
    // GROWABLE?
    private boolean growable = false;
    public void setGrowable(boolean growable) {
        this.growable = growable;
    }
    
    // CONSTRUCTOR
    public RoundFIFOQueueString(int maxSize) {
        
        this.maxSize = maxSize; 
        
        // initial case
        Node firstNode = new Node(); 
        firstNode.debugId = 0;
        Node prevNode = firstNode;

        // continue setting up structure
        for (int i = 1; i < maxSize; i++) {
            
            // create new node
            Node newNode =  new Node();
            
            // set .next pointer
            prevNode.next = newNode;
            
            // set debugId
            newNode.debugId = i;
            
            // value remains pointing to null
            
            // set as prevNode for next
            prevNode = newNode;
        }
        
        // connect the chain: set last node's .next to first node
        prevNode.next = firstNode;
        
        // set enqueue, dequeue, and prequeue
        enqueue = firstNode;
        dequeue = firstNode;
        prequeue = prevNode; // must be the position BEFORE dequeue

        //TODO: use debugger to verify that you have linked up all nodes in a circle

    }
    
    // print out each Node's content on a separate line
    public void printQueue() {
        
        Node currNode = enqueue;
        
        for (int i = 0; i < maxSize; i++) {
            
            // for testing!
//                System.out.printf(
//                    "|| Printing Current Node: debugId = %d, value = %s, next(id) = %d "
//                            + "|| Extra Info: eId = %d, dId = %d, pId = %d ||\n",
//                    currNode.debugId, 
//                    (currNode.value != null ? currNode.value : " it's null!!"), 
//                    currNode.next.debugId, 
//                    enqueue.debugId,
//                    dequeue.debugId,
//                    prequeue.debugId
//                );
                
            System.out.printf(
                "Node #%d: %s\n", 
                i, 
                (currNode.value != null ? currNode.value : "null!")
            );
            
            currNode = currNode.next;
            
        } //END: for i<maxSize

        // check that we are at enqueue
        if (currNode != enqueue) {
            throw new RuntimeException("Internal error: queue may not be circular");
        }
        
        // TODO UNIT TEST(not req?)^^ see test output

        // example output: "Node #0: Joe"
    }
    
    // puts value into the queue
    public void enqueue(String value, boolean grow) { 

        // throw exception if queue full
        if (enqueue.value != null) {
            if (!growable) {
                throw new RuntimeException("No space in the queue");
            }
            
            // else:
            
            throw new RuntimeException("Growing queue is not yet implemented!");
            // TODO: Grow queue
            // create new Node so we can insert more than current maxSize
            // MUST update maxSize
            
        } 
        
        // then regardless (either exception thrown, queue grows, or there is room)
        
        // add to queue
        enqueue.value = value;
        
        // update enqueue pointer
        enqueue = enqueue.next;
        
        // update size
        size++;

    }

    // removes and returns value from the queue (in FIFO order)
    public String dequeue() { 
        
        // throw exception if empty 
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }
        
        // otherwise, get value then nullify
        String toReturn = dequeue.value;
        
        dequeue.value = null;
        
        // update prequeue pointer
        prequeue = dequeue;
        
        // update dequeue pointer
        dequeue = dequeue.next;
        
        // decrement size
        size--;
        
        return toReturn; 
    }

    public int size() { 
        return size; 
    }

    // returns array of "size" number of elements with most recently enqueued elements first (following "next" references)
    public String[] toArray(String[] template) { 

        //max size: get all
        String[] resultArray = (String[]) java.lang.reflect.Array.newInstance(template.getClass().getComponentType(), maxSize);
        
        // size: curated
        String[] resultArrayReversed = (String[]) java.lang.reflect.Array.newInstance(template.getClass().getComponentType(), size);

        // must start this array at node AFTER most recently enqueued, so when we reverse, it will be from most recently enqueued, to least.
        Node currNode = enqueue;

        // go through whole structure
        for (int i = 0; i < maxSize; i++) {

            resultArray[i] = currNode.value;

            //TEST
            System.out.println("currNode.value: " + currNode.value);

            currNode = currNode.next;

        }
        //TODO:  UNIT TEST: prequeue MUST = first item in array

        // reverse the array
        for (int i = 0; i < resultArray.length; i++) {
            
            // only add to reversed if it's not null
            if (resultArray[resultArray.length-1-i] != null) {
                resultArrayReversed[i] = resultArray[resultArray.length-1-i];
            }
            
        }

        return resultArrayReversed;
    }

    // checks if value is present in Queue and returns the number of occurrences of that value (0 if not found)
    public int countValues(String value) { 
        
        int toReturn = 0;
        
        Node currNode = enqueue;
        
        for (int i = 0; i < size; i++) {
            
            if (currNode.value != null) {
                
                if (currNode.value.compareTo(value) == 0) {
                    toReturn++;
                    System.out.println("TESTING");
                }
                currNode = currNode.next;
            }

        }
        return toReturn; 
    }

}


    

