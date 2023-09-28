package com.soli.finalroundqueue;

import java.util.Iterator;

public class FinalRoundQueue {

    public static void main(String[] args) {
        System.out.println("Hello World! FRQ");
        
        RoundFIFOQueueString instance = new RoundFIFOQueueString(5);

        //instance.printQueue();
        
        Iterator it = instance.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        
    }
    
    
}














