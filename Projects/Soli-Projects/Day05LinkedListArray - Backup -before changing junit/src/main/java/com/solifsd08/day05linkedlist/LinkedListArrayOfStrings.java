package com.solifsd08.day05linkedlist;

public class LinkedListArrayOfStrings {

    private class Container {
        Container next;
        String value;
    }

    // start and end are null if the size is zero.
    private Container start, end;
    
    private int size = 0;
    
    /////////////////// HELPER METHODS ////////////////////
    
    /////////////////// STOCK METHODS //////////////////////
    
    public int getSize() {
        return size;
    }    
    
    public void add(String value) {
        
        // create & populate new container
        Container newItem = new Container();
        newItem.next = null;
        newItem.value = value;
        
        // set the container into place
        if (size == 0) {
                // no items, thus it's the start and end
//                start = newItem;
//                end = newItem;
                start = end = newItem;
        } else {
            // former last/end item now points to new item
            end.next = newItem;
            
            // end pointer now points to new item
            end = newItem;
        }
            
        // increase size
        size++;        
              
    }
    
    /* OLD ATTEMPT AT ADD
        public void add(String value) {
        
        // create & populate new container
        Container newItem = new Container();
        newItem.next = null;
        newItem.value = value;
        
        // set the container into place
        switch (size) {
            case 0:
                // no items, thus it's the start and end
//                start = newItem;
//                end = newItem;
                start = end = newItem;
                break;
            case 1:
                // one item, thus it's the end. start stays
                end = newItem;
                
                //set link for start
                start.next = end;
                break;
            default:
                // >= 2 items, thus must use algorithm:
                
                Container oldEnd = end;
                end = newItem;
                oldEnd.next = end;
                break;
        }
            
        // increase size
        size++;        
              
    }
    */
    
    public String get(int index) throws IndexOutOfBoundsException {
        
        // check index
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index < 0 !!!");
        } else if (index >= size) {
            throw new IndexOutOfBoundsException("Index too high!!!");
        } else {
        
            int count = 0;
            Container curr = start;

            while (count < index) {
                curr = curr.next;
                count++;
            }

            return curr.value;
        }
    }
    
    // TODO
    public void insertValueAtIndex(String value, int index) {
        
        //
        
        
        
    }
    
    // TODO
    public void replaceValueAtIndex(String value, int index) { // put
        
    } 
    

    // TODO
    public void deleteByIndex(int index) {
        
    }
    
    // TODO
    public boolean deleteByValue(String value) { // delete first value found
        
        return true; // TODO
    }
    


    @Override
    public String toString() { // comma-separated values list similar to: [5,8,11]
        
        // note: if I remember correctly...
        //// abc += ""; // creates much garbage to be collected
        //// abc = abc + ""; // similarly creates garbage
        //// must use StringBuilder
       
        /* ATTEMPT #1
        String returnString = "[";
        
        for (int i = 1; i <= size; i++) {
            returnString = returnString + get(i);
            if (i != size) {
                returnString = returnString + ",";
            }
        }
        returnString = returnString + "]";
        
        */
        
        StringBuilder sb = new StringBuilder("[");
        
        for (int i = 1; i <= size; i++) {
            sb.append(get(i));
            if (i != size) {
                sb.append(",");
            }
        }
        sb.append("]");
        
        return sb.toString();
    } 

    // TODO 
    /*
    public String[] toArray() { // could be used for Unit testing
        
    } 
*/



/////////////////////// Additional Subtasks: ///////////////////////
// UNIT TESTS
//// 10+ JUnit tests
//// test implementation in all possible ways

// AFTER implementation works
//// make a copy of your code and modify it into a generic class:
//// class class LinkedListArray<T> { ... }
////
//// public T[] toArray(T[] template) { } // could be used for Unit testing
    
    
    
    
    public static void main(String[] args) {
        System.out.println("Hi from the Main Method!");
    }
}
