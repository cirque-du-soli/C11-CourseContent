package day10binarytree;

class PrintingVisitor implements VisitorInt<BinaryTreeOfIntsVisitable.NodeOfInt>{
    @Override
    public void visit(BinaryTreeOfIntsVisitable.NodeOfInt node) {
        System.out.printf("Visited node %s with value %d\n", node, node.value);
    }
}

public class Day10BinaryTree {

    public static void main(String[] args) {
         
        BinaryTreeOfIntsVisitable tree = new BinaryTreeOfIntsVisitable();
        int [] vals = { 3, 9, 1, 5, 11, 2};
        for (int n : vals ) {
            tree.put(n);
        }
        for (int i : tree) {
            System.out.println("Val " + i);
        }

        tree.setVisitor(new PrintingVisitor());
        tree.traverseAllVisiting();
        
        tree.setVisitor(new VisitorInt<BinaryTreeOfIntsVisitable.NodeOfInt>() {
            int sum = 0;
            @Override
            public void visit(BinaryTreeOfIntsVisitable.NodeOfInt node) {
                sum += node.value;
                System.out.println("sum so far is " + sum);
            }
        });
        tree.traverseAllVisiting();

        tree.setVisitor((node) -> node.value++);
        tree.traverseAllVisiting();

        for (int i : tree) {
            System.out.println("Val " + i);
        }
        
        /*
        BinaryTreeOfInts tree = new BinaryTreeOfInts();
        int [] vals = { 3, 9, 1, 5, 11, 2};
        for (int n : vals ) {
            tree.put(n);
        }
        for (int i : tree) {
            System.out.println("Val " + i);
        } 
        
        */
    }
    
}
