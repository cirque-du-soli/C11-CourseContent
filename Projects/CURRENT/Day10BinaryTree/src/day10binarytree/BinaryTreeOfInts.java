package day10binarytree;

import java.util.Iterator;

public class BinaryTreeOfInts implements Iterable<Integer> {
    
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
  
    private class NodeOfInt {
        int value; // could also be key, value pair
        NodeOfInt left, right;
    }

    private NodeOfInt root;
    private int nodesCount;

    // throws exception if put attempts to insert value that already exists (a duplicate)
    public void put(int value) throws IllegalArgumentException {
        if (root == null) { // special case if tree is empty
            NodeOfInt newNode = new NodeOfInt();
            newNode.value = value;
            root = newNode;
            nodesCount++;
            return;
        }
        NodeOfInt currNode = root;
        while (true) {
            if (currNode.value == value) {
                throw new IllegalArgumentException("Duplicates not allowed");
            }
            if (value < currNode.value) { // go left
               if (currNode.left == null) {
                    // found the spot to put the new node in
                    NodeOfInt newNode = new NodeOfInt();
                    newNode.value = value;
                    currNode.left = newNode;
                    nodesCount++;
                    return;
                } else {
                    // follow to the left on the next iteration
                    currNode = currNode.left;
                    // continue;
                }
            } else { // go right
                if (currNode.right == null) {
                    // found the spot to put the new node in
                    NodeOfInt newNode = new NodeOfInt();
                    newNode.value = value;
                    currNode.right = newNode;
                    nodesCount++;
                    return;
                } else {
                    // follow to the right on the next iteration
                    currNode = currNode.right;
                    // continue;
                }
            }
        }
    }

    public int getSize() {
        return nodesCount;
    }

    public boolean hasValue(int val) {
        NodeOfInt current = root;
        while (current != null) {
            if (val == current.value) {
                return true;
            }
            if (val < current.value) {
                current = current.left;
            } else if(val > current.value) {
                current = current.right;
            }
        }
        return false;   // if while loop exist and val not found
    }

    // uses recursion to compute the sum of all values in the entire tree
    public int getSumOfAllValues() {
        return getSumOfThisAndSubNodes(root);
    }

    // private helper recursive method to implement the above method
    private int getSumOfThisAndSubNodes(NodeOfInt node) {
        // base case - recursion must stop at some point
        if (node == null) return 0;
        int sumOfSubtree = node.value;
        sumOfSubtree += getSumOfThisAndSubNodes(node.left);
        sumOfSubtree += getSumOfThisAndSubNodes(node.right);
        return sumOfSubtree;
    }

    // uses recursion to collect all values from largest to smallest
    public int[] getValuesInOrder() { // from largest to smallest
        resultArray = new int[nodesCount];
        resultIndex = 0;
        collectValuesInOrder(root);
        assert (resultIndex == nodesCount ); // ??? -1 ?
        return resultArray;
    }
    // private helper recursive method to implement the above method

    private void collectValuesInOrder(NodeOfInt node) {
        // recursion must end at some point
        if (node == null) return;
        //
        collectValuesInOrder(node.right);
        resultArray[resultIndex++] = node.value;
        collectValuesInOrder(node.left);
    }
    
    // data structures used to make collecting values in order easier
    private int[] resultArray;
    private int resultIndex;

}
