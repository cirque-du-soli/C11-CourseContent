package com.solifsd08.day04customhashmap;

public class CustomHashMapStringString {

    private class Container {

        Container next;
        String key;
        String value;
    }

    // size must always be a prime number!
    private Container[] hashTable = new Container[5];

    private int totalItems;

    //////////////////////////////// METHODS /////////////////////////////////
    /*
     * Hashing Function
     *
     * @param key
     * @return
     */
    private int computeHashValue(String key) {

        return 1;
    }

    //must first see if the item exists already
    void putValue(String key, String value) {
        // LATER: expand hashTable by ~ *2 when totalItems > 3*hashTable.length
        int hash = computeHashValue(key);
        int index = hash % hashTable.length;
    }

    void printDebug() {
        throw new UnsupportedOperationException("Not supported yet.");
    
}
