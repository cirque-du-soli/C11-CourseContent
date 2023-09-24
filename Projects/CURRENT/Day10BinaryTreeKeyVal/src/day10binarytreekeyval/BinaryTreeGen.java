package day10binarytreekeyval;

import java.util.Iterator;

public class BinaryTreeGen<K extends Comparable, V> implements Iterable<Pair<K,V>> {

    @Override
    public Iterator<Pair<K, V>> iterator() {
        return new Iterator<Pair<K, V>>() {
            
            Pair<K,V> [] data = getPairsInOrder();
            int nextIndex;
            
            @Override
            public boolean hasNext() {
                return nextIndex < data.length;
            }

            @Override
            public Pair<K, V> next() {
                return data[nextIndex++];
            }
        };
    }

    private class Node {
        K key;
        V value;
        Node left, right;
    }

    private Node root;
    private int nodesCount;

    private K[] template;
    
    public BinaryTreeGen(K[] template) {
        this.template = template;
    }
    
    // if put attempts to insert a key that already exists then value is updated (no exception is thrown)
    // values may be duplicates but keys may not
    void put(K key, V value) {
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
    public V getValByKey(K key) { // throws RuntimeException {
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
        System.out.printf("%s => %s\n", node.key.toString(), node.value.toString());
        printNodeAndAllBelow(node.right);
    }

    // return all keys from smallest to largest (alphabetically)
    K[] getKeysInOrder() {
        // resultKeysArray = new K[nodesCount];
        resultKeysArray = (K[]) java.lang.reflect.Array.newInstance(template.getClass().getComponentType(), nodesCount);
        resultKeysIndex = 0;
        collectKeysInOrder(root);
        return resultKeysArray;
    }

    // private helper recursive method to implement the above method
    private void collectKeysInOrder(Node node) {
        // recursion must end at some point
        if (node == null) {
            return;
        }
        // handle recursion
        collectKeysInOrder(node.left);
        resultKeysArray[resultKeysIndex++] = node.key;
        collectKeysInOrder(node.right);
    }

    private K[] resultKeysArray;
    private int resultKeysIndex;
    
    // return pairs of keys and values from smallest to largest (alphabetically)
    Pair<K,V>[] getPairsInOrder() {
        Pair<K,V> []pairArrayTemplate = new Pair[0]; // ???
        // resultKeysValuesArray = new Pair<K,V>[nodesCount];
        resultKeysValuesArray = (Pair<K,V>[])java.lang.reflect.Array.newInstance(pairArrayTemplate.getClass().getComponentType(), nodesCount);
        resultKeysIndex = 0;
        collectKeysValuesInOrder(root);
        return resultKeysValuesArray;
    }

    // private helper recursive method to implement the above method
    private void collectKeysValuesInOrder(Node node) {
        // recursion must end at some point
        if (node == null) {
            return;
        }
        // handle recursion
        collectKeysValuesInOrder(node.left);
        resultKeysValuesArray[resultKeysValuesIndex++] = new Pair<K,V>(node.key, node.value);
        collectKeysValuesInOrder(node.right);
    }

    private Pair<K,V>[] resultKeysValuesArray;
    private int resultKeysValuesIndex;

}
