package com.soli.finalexamprepdatastructure1;

import java.util.Iterator;
import java.util.Objects;

/**
 * This is a hackjob of a binary search tree. EXPERIMENT!
 * @author solil
 */
public class TheStructure1IterableInt implements Iterable<Integer> {
    
    ////////////////////// MAKE IT ITERABLE: ////////////////////////////
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            
            int [] data = getValuesInOrder();
            int nextItemIndex = 0;
            
            @Override
            public boolean hasNext() {
                return (nextItemIndex < data.length);
            }

            @Override
            public Integer next() {
                return data[nextItemIndex++];
            }
        };
    }
    
    ////////////////////// DEFINE AN ITEM: ////////////////////////////
    
    private class Node {
        
        // Container next;
        Node left;
        Node right;
        
        // String key;
        int value;
        
    }
    
    /////////// KEEP TRACK of important properties (of whole structure) /////
    
    // size
    private int totalNodes = 0; // totalItems, size, etc.
    
    // initial item, top of tree, first item, etc.
    private Node topNode;
    // private Container start, end;
    
    // aux data structures
    private int[] collectedValues; // for collectValuesInOrder() & getValuesInOrder()
    private int collectedValuesIndex; // for collectValuesInOrder() & getValuesInOrder()
    
    ///////////////////////// METHODS ///////////////////////////
    
    /**
     * Adds a node to the tree.
     * 
     * 1. Creates new Node object.
     * 2. Determines if tree is empty or not.
     * 3. Runs recursive method to find newNode's new home.
     * 4. LATER: Check if tree is balanced.
     * 5. LATER: Re-balance tree, from unbalanced node.
     * @param value 
     */
    public void addNode(Integer value) {
        
        //// Create the new item:
        Node newNode = new Node();
        newNode.value = value;
        // newNode.left = null; //happens by default!
        // newNode.right = null; //happens by default!
        
        // Special case: first item DNE
        if (totalNodes == 0) {
            topNode = newNode;
            totalNodes++;
            
            
            // TESTING:
            System.out.println("Added first item!");
            
            return;
        }
        
        // Typical case: first item exists
        findHomeForNode(newNode, topNode);
        
        // LATER: calculate whether tree is balanced, re-balance

    }
    
    /**
    * Fetches and displays all nodes in the tree, based on level.                      
    */
    public void getAllNodes() {
        
    }
    
    ////////////////////////// HELPER METHODS ////////////////
    
    /**
     * A bit superfluous, I know...
     * 
     * Standardized node comparison.
     * @param newNode
     * @param oldNode : the preexisting node in the tree.
     * @return (true means traverse rightward; false means traverse leftward)
     */
    private boolean compareNodes(Node newNode, Node oldNode) throws IllegalArgumentException {
        
        // throw exception if value is a duplicate
        if (newNode.value == oldNode.value) {
            throw new IllegalArgumentException("SOLI SAYS: No duplicates are allowed!! >:(");
        }
        
        if (newNode.value > oldNode.value) {
            return true;
        } else { // newNode.value < oldNode.value
            return false;
        }
    }
    
    /**
     * 1: Compares the orphan node with potential-parent node (go left or right).
     * 2: Checks if appropriate child node exists.
     * 3a: If no, places newNode there.
     * 3b: If yes, recursively calls to itself with existing child as new potential parent.
     * LATER: Double link? set newNode's parent field to parentNode? Useful? Useless? TBD!
     * @param newNode
     * @param parentNode 
     */
    // aka put()
    public void findHomeForNode(Node newNode, Node parentNode) { 
        
        // TESTING:
        System.out.println("*****checking new node: " + newNode.value + " *****");
            
        if (compareNodes(newNode, parentNode)) { // new is greater
            //// newNode traverses to the right
            
            // TESTING:
            System.out.println("***node " + newNode.value + " moves rightward***");
            
            
            // check if right child exists
            if (parentNode.right == null) {
                
                // refer parent.right to new node
                parentNode.right = newNode;
                totalNodes++;
                
            } else { // right exists, must continue search
                
                findHomeForNode(newNode, parentNode.right);
            }
            
        } else { // new node val is less than old
            //// newNode traverses to the left
            
            // TESTING:
            System.out.println("***node " + newNode.value + " moves leftward***");
            
            // check if left child exists
            if (parentNode.left == null) {
                
                // refer parent.left to new node
                parentNode.left = newNode;
                totalNodes++;
                
            } else { // left exists, must continue search
                
                findHomeForNode(newNode, parentNode.left);
            }
        }
        
        // TESTING:
        System.out.println("*Node placed.*");
    }
    
    

    ////////////////////////////////////////////////////// FROM BinaryTreeOfInts
    public int[] getValuesInOrder() {
        
        collectedValues = new int[totalNodes];
        collectedValuesIndex = 0;
        collectValuesInOrder(topNode);
        assert (collectedValuesIndex == totalNodes ); // ??? -1 ?
        return collectedValues;
    }
    private void collectValuesInOrder(Node currNode) {
        
        // WHEN TO STOP RECURSION:
        if (currNode == null) {
            return;
        }
        
        // node is not empty, start collecting values
        // collect higher values first
        
        // call recursively to right
        collectValuesInOrder(currNode.right);
        
        // increment index & add this value
        collectedValues[collectedValuesIndex] = currNode.value;
        collectedValuesIndex++;
        
        // call recursively to the left
        collectValuesInOrder(currNode.left);
        
    }

    
    
    
    
    
}
