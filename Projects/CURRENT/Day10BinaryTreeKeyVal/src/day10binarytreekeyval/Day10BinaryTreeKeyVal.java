package day10binarytreekeyval;

// import day10binarytreekeyval.BinaryTreeStringIntObservable.Node;

public class Day10BinaryTreeKeyVal {

    public static void main(String[] args) {
        BinaryTreeStringIntObservable tree = new BinaryTreeStringIntObservable();
        tree.setObserver(new ObserverInt<BinaryTreeStringIntObservable.Node>() {
            @Override
            public void added(BinaryTreeStringIntObservable.Node node) {
                System.out.printf("Added: %s -> %d\n", node.key, node.value);
            }

            @Override
            public void modified(BinaryTreeStringIntObservable.Node nodeOld, BinaryTreeStringIntObservable.Node nodeNew) {
                System.out.printf("Modified: %s -> (%d became %d)\n", nodeNew.key, nodeOld.value, nodeNew.value);
            }

            @Override
            public void deleted(BinaryTreeStringIntObservable.Node node) {
                System.out.printf("Deleted: %s -> %d\n", node.key, node.value);
            }
        });
        
        tree.put("Jerry", 183);
        tree.put("Terry", 177);
        tree.put("Barry", 190);
        tree.put("Larry", 167);
        tree.put("Barry", 187);

        /*
        BinaryTreeGen<String,String> tree = new BinaryTreeGen<>(new String[0]);
        tree.put("Jerry", "Montreal");
        tree.put("Terry", "Vancouver");
        tree.put("Barry", "Toronto");
        tree.put("Larry", "Ottawa");
        //for (Pair<String,String> pair : tree.getPairsInOrder()) {
        for (Pair<String,String> pair : tree) {
            System.out.printf("%s : %s\n", pair.key, pair.value);
        } */
    }
    
}
