package day10binarytreekeyval;

public class BinaryTreeStringInt {

    private class Node {
        String key;
        int value;
        Node left, right;
    }

    private Node root;
    private int nodesCount;
    
    // if put attempts to insert a key that already exists then value is updated (no exception is thrown)
    // values may be duplicates but keys may not
    void put(String key, int value) { 
        if (root == null) { // special case if tree is empty
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            root = newNode;
            nodesCount++;
            return;
        }
        Node currNode = root;
        while (true) {
            if (currNode.key.compareTo(key) == 0) {
                // override with new value
                currNode.value = value;
                return;
            }
            if (key.compareTo(currNode.key) < 0) { // go left
               if (currNode.left == null) {
                    // found the spot to put the new node in
                    Node newNode = new Node();
                    newNode.key = key;
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
                    Node newNode = new Node();
                    newNode.key = key;
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
    
    // throws exception if key is not found, otherwise returns the value
    public int getValByKey(String key) throws RuntimeException {
        Node currNode = root;
        while (true) {
            if (currNode == null) {
                throw new RuntimeException("Key not found");
            }
            if (currNode.key.compareTo(key) == 0) {
                return currNode.value; // found it!
            }
            if (currNode.key.compareTo(key) < 0) { // go left
                currNode = currNode.left;
            } else { // go right
                currNode = currNode.right;
            }
            
        }
    }

    // print out all key-value pairs (one per line) from the smallest key to the largest
    public void printAllKeyValPairs() {
        printNodeAndAllBelow(root);
    }

    private void printNodeAndAllBelow(Node node) {
        if (node == null) {
            return; // recursion must end
        }
        printNodeAndAllBelow(node.left);
        System.out.printf("%s => %d\n", node.key, node.value);
        printNodeAndAllBelow(node.right);
    }
    
}
