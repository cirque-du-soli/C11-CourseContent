import java.lang.reflect.Array;

/**
 *
 * @author Soliloquy Yarrow -- Student #2342261 JAC-FSD-08
 * @param <T>
 */
public class PriorityStack<T> {
    
    /////////////////////////////////// SETUP: ///////////////////////////////
    
    private class Container {
        T value;
        boolean hasPriority;
        Container nextBelow;
    }

    private Container top; // top of the stack element

    private int size = 0; // tracks size
    
    private int totalPriorityItems = 0; // tracks if priority items exist

    ////////////////////////////// AUX METHODS: /////////////////////////////
    
    // These methods:
    //// -prevent code duplication
    //// -improve readability
    // Thus according to best practices they're "required" ;)
    
    /**
     * Checks if size is 0, throws custom NoSuchElementException.
     */
    private void checkSizeThrowNSEE() {
        
        if (size == 0) {
            throw new NoSuchElementException("The stack is empty, thus no such element exists!");
        }
        
    }
    
    /**
     * Removes links to itemToRemove
     * Reassigns pointers (prevItem.nextBelow)
     * Assumes not top item, because prevItem is given
     * 
     * @param prevItem
     * @param itemToRemove
     */
    private T removeGivenItem(Container prevItem, Container itemToRemove) {

        // reassign previous item's nB pointer
        prevItem.nextBelow = itemToRemove.nextBelow;

        // decrement size
        size--;    
        
        // if hasPriority, decrement priority
        if (itemToRemove.hasPriority) {
            totalPriorityItems--;
        }
        
        return (T) itemToRemove.value;
        
    }
    
    /**
     * Overloaded version of above, if removing top item
     */
    private T removeGivenItem(Container itemToRemove) {
        
        // reassign top pointer
        top = itemToRemove.nextBelow; // MAY BE NULL

        // decrement size
        size--;    
        
        // if hasPriority, decrement priority
        if (itemToRemove.hasPriority) {
            totalPriorityItems--;
        }
           
        return (T) itemToRemove.value;
    }
    
    /**
     * Used only when currItem is not the top item!
     * Find the item PRECEDING the item at the given index. 
     * 
     * @param index
     * @return prevItem
     */
    private Container getPrevItemByCurrItemIndex(int index) {
        // we only use this method if currItem is not top item (index != 0)
        
        // declare start condition (prevItem index = 0, start at item index = 1)
        Container prevItem = top;
        
        // step to correct item
        for (int i = 1; i < index; i++) {
            
            // move to next item
            prevItem = prevItem.nextBelow;
            
        }
        
        return prevItem;
    }

    /////////////////////////// REQUIRED METHODS: ////////////////////////////
    
    /**
     * Adds item to top of stack.
     * Assumes non-priority as default. 
     * // (calls overloaded push method, with hP=false)
     * @param value 
     */
    public void push(T value) {
        push(value, false);
    }

    /**
     * Adds item to top of stack.
     * @param value
     * @param hasPriority : type bool. "false" is redundant, but available.
     */
    public void push(T value, boolean hasPriority) {
        
        // create new Container
        Container newItem = new Container();
        
        // populate new Container
        newItem.value = value;
        newItem.hasPriority = hasPriority;
        // newItem.nextBelow = null; <- occurs automatically
        
        // check if stack is empty
        if (size == 0) { // Special case: stack is empty -- first item
            
            // set new item as top node
            top = newItem;
            
        } else { // General case: stack newItem on top
            
            // first: link newItem with the current top item
            newItem.nextBelow = top;
            
            // second: replace old top with newItem
            top = newItem;
        }
                        
        // increment size after item has been added
        size++;
        
        // increment totalPriorityItems if newItem has priority
        if (newItem.hasPriority == true) {
            totalPriorityItems++;
        }

    }
    
    /**
     * Remove and return the top item
     * @return : type T, Container.value
     * @throws : NoSuchElementException -- if size == 0;
     */
    public T pop() {
        
        // throw exception if size == 0
        checkSizeThrowNSEE();
        
        // get reference to current top item
        Container itemToReturn = top;
        
        // set top pointer to former second item
        top = top.nextBelow;
        
        // decrement size
        size--;
        
        // returns popped item's value
        return (T) itemToReturn.value; // we can safely cast to T
    }

    /**
     * 1. Finds first item with .hasPriority == true\
     * 2. Removes & returns it.
     * 
     * If no such item exists, it calls pop();
     * 
     * @return value (type T)
     * @throws NoSuchElementException -- if size == 0;
     */
    public T popPriority() {
        
        // declare returnable
        T valToReturn;
        
        // no priority items: pop()
        if (totalPriorityItems < 1) {
            
            valToReturn = pop();
            
        } else  { // priorities exist!

            // throw nsee if size == 0
            checkSizeThrowNSEE(); // TODO: REMOVE... REDUNDANT!! 
            
            // temporarily hold previous item for re-assigning pointers
            Container prevItem = null; 
            
            // find an item with priority, starting from the top
            Container item = top;
            
            //iterate until curr item has priority
            while (item.hasPriority == false) {

                // reassign prevItem first
                prevItem = item;
                
                // move to next item
                item = item.nextBelow;

                // don't need to worry about whether we've found a priority item
                // or not because totalPriorityItems > 0
            }
                
            // get item's value
            valToReturn = (T) item.value; // can safely cast
            
            //remove item
            if (prevItem == null) { // item to remove is top item
                
                removeGivenItem(item);
                
            } else { // item to remove is not top item
                
                removeGivenItem(prevItem, item);
                
            }
            
        }
        
        // return val
        return valToReturn;
        
    }
    
    /**
     * fetches the size of the stack
     * @return int size
     */
    public int getSize() {
        return size;
    }

    /**
     * Finds first occurence of a value. (top down)
     * 
     * @param value
     * @return int index // -1: notFound; >= 0: index (top = 0)
     */
    public int hasValue(T value) {
                
        // Special case: size == 0, throw nsee
        checkSizeThrowNSEE();

// temporarily hold previous item for re-assigning pointers
// Container prevItem = null; // FIXME: REMOVE

        // start from the top
        Container item = top;
        
        // declare index
        int index = 0;
        
            
        // iterate until curr item.value == value
        //// accounts for case: size == 1 (not special, prevItem not read yet)
        //// MUST check equality with value.equals(item.value)
        while (index < size && !value.equals(item.value)) { 
            // checks index not out of bounds first!

// reassign prevItem first
// prevItem = item; // FIXME: REMOVE

            // move to next item
            item = item.nextBelow; // MAY BE NULL

            // increment index
            index++; // MAY BE OutOfBounds if item is now null!!

        }

        // returns
        if (index == size) {
            return -1; // no matching value found
        } else {
            return index; // return index of item
        }
        
        
    }
    
    /**
     * Finds first item from top containing the value
     * Removes the item
     * Returns its value
     * 
     * @param value
     * @return valueToReturn : type T
     * @throws NoSuchElementException : if no item exists with the value
     */
    public T removeValue(T value) {
        
        // call hasValue to find index of first item whose value matches
        int index = hasValue(value);
        
        // val to return
        T removedValue;
        
        // check index
        if (index == -1) { // index is the sentinel value
            
            // throw NSEE
            throw new NoSuchElementException("There is no item with the given value.===Line~312===");
            
        } else { // index valid
            
            if (index == 0) { // special case, first item
                
                // itemToRemove = top;
                
                // call removeGivenItem
                removedValue = removeGivenItem(top);
                
            } else {
                
                // call additional method to get prevItem (and deduce curr item) from index
                Container prevItem = getPrevItemByCurrItemIndex(index);
                
                // call removeGivenItem
                removedValue = removeGivenItem(prevItem, prevItem.nextBelow);
                
            }

        }
        
        // old lazy way
        // return value; // returns given value
        
        // new correct way
        return removedValue;
        
    }


    ///////////////////////////////////////////////////////////// TODO METHODS


    /**
     * Reorder items such that:
     * -- ALL priority items precede non-priority items
     * -- the order is otherwise preserved.
     */
   
    public void reorderByPriority() { 
        
        
                
        // WORK IN PROGRESS
        throw new NotYetImplementedException("reorderByPriority() is not yet implemented.");
        
        
    
        /*
        
        
        // THE PLAN: pop through whole old list, top to bottom
        //// effectively append each item to the bottom of each half of the list

        PriorityStack newStack = new PriorityStack();
        
        // 4 tracking pointers for new Stack
        // Container firstP is the same is top // first item
        Container lastP = new Container(); // last priority item
        Container firstNP = new Container(); // first non-priority item
        Container lastItem = new Container(); // last item (overall), also lastNP
        
        // stepper container
        Container item = top;
        
        // LOOP:
        while (size > 0) {
       
            // pop through whole old list
            if (item.hasPriority == true) { // add to first half

                // first p item?
                if (newStack.totalPriorityItems == 0) {
                    
                    // item to top
                    newStack.push(item.value, item.hasPriority);
                    // it auto increments

                    lastP = item;
 
                } else {
                    
                    lastP
                    
                    
                    
                }
                // decr priority count
                totalPriorityItems--;

            } else { // add to second half
                
                // first np item?

            }

            size--;

        }
        
        
        // check if stack is empty
        if (size == 0) { // Special case: stack is empty -- first item
            
            // set new item as top node
            top = newItem;
            
        } else { // General case: put newItem to bottom
            
            // first: link last item to newItem 
            lastItem.nextBelow = newItem;

        }
                        
        // increment size after item has been added
        size++;
        
        // increment totalPriorityItems if newItem has priority
        if (newItem.hasPriority == true) {
            totalPriorityItems++;
        }

        */
    }


    @Override
    public String toString() {
        
        // start string
        StringBuilder sb = new StringBuilder("[");
        
        // start at top
        Container item = new Container();
        item = top;
        
        for (int i = 0; i < size; i++) {
            

            sb.append(item.value.toString());
            sb.append(":");
            
            // determine if hasPriority
            if (item.hasPriority) {
                sb.append("P");
            } else {
                sb.append("N");
            }
                        
            // add comma if not last
            if (item.nextBelow != null) {
                sb.append(",");
            }
            // move to next item
            item = item.nextBelow;
        }

        // end string
        sb.append("]");
        
        return sb.toString();
        
        // e.g. "[Jerry:N,Terry:N,Martha:P,Tom:P,Jimmy:N]" 
    }
    
    //////////////////////////////// toArrayReversed /////////////////////////
    
    // fields
    private T[] reversed;
    private int newIndex;
    // private int reversedCount;
    /*

    public T[] toArrayReversed() {
        
        newIndex = size-1;

        // reversed = (T[]) new Array[size];
        reversed = (T[]) Array.newInstance(T.getClass().getComponentType(), size);
        
        // call overloaded version, auto-filling with *top*
        toArrayReversed(top);
        
        return reversed;
    }
    
    */
    
    /**
     * Checks if item is last item.
     * --if no, recursively calls itself.
     * --if yes, puts value in the last position of the array
     * @param item of type Container <T>
     * @return
     */
    /*
    private void toArrayReversed(Container item) { // Note: this is "the twist"
        
        if (item.nextBelow != null) { // not last item
            
            // recursion til last item
            toArrayReversed(item.nextBelow);
            
        }
        
        // now on last item
        reversed[newIndex] = (T) item.value;
        
        // decrement newIndex immediately
        newIndex--;
        
        // now the method one level up will continue, 
        // placing its item's value in the correct index
        
        // return reversed; // most returns disappear into the abyss, except the last one
        
    }

    
    
      
    // NOTE: *ONLY* implement this method if you can't implement toArrayReversed.
    // Make sure to add a unit test for it later.
    public T[] toArray() { 
        
        reversed = (T[]) new Array(size);
        
        if (item.nextBelow != null) { // not last item
            
            // recursion til last item
            toArrayReversed(item.nextBelow);
            
        }

        return reversed;
    }
    */

}
