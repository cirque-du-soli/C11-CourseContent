package com.soli.finalexamprepdatastructure1;

import java.util.Iterator;

/**
 *
 * @author solil
 */
public class FinalExamPrepDataStructure1 {

    public static void main(String[] args) {
        
        
        System.out.println("Hello World! #1");
        
        TheStructure1IterableInt dataTree = new TheStructure1IterableInt();
        
        dataTree.addNode(55);
        dataTree.addNode(44);
        dataTree.addNode(66);
        dataTree.addNode(33);
        dataTree.addNode(77);
        dataTree.addNode(22);
        dataTree.addNode(11);
        
        Iterator dti = dataTree.iterator();
        
        while (dti.hasNext()) {
            
            System.out.println("val: " + dti.next());
            
        }
        
        for (int n : dataTree) {
            
            System.out.println("value: " + n);
            
        }
        
        /*
        System.out.println("Hello World! #2");
        
        TheStructure2IterableKV dataTree = new TheStructure2IterableKV();
        
        dataTree.addNode(55);
        dataTree.addNode(44);
        dataTree.addNode(66);
        dataTree.addNode(33);
        dataTree.addNode(77);
        dataTree.addNode(22);
        dataTree.addNode(11);
        
        Iterator dti = dataTree.iterator();
        
        while (dti.hasNext()) {
            
            System.out.println("val: " + dti.next());
            
        }
*/
    }
}
