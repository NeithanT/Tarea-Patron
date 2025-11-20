package iterador;

public class Iterador {

    public static void main(String[] args) {
        
        
        testArrayIterator();
        testBTreeIterator();
        testMatrixIterator();

        System.out.println("Works!");
    }

    private static void testArrayIterator() {
        System.out.println("---Array Iterator---");

        String[] stringArray = {"Hello", "World", "Test"};
        ArrayIterator<String> stringIterator = new ArrayIterator<>(stringArray);

        while (stringIterator.hasNext()) {
            System.out.println("  " + stringIterator.next());
        }

        Integer[] intArray = {1, 2, 3, 4, 5};
        ArrayIterator<Integer> intIterator = new ArrayIterator<>(intArray);

        while (intIterator.hasNext()) {
            System.out.println("  " + intIterator.next());
        }

        String[] emptyArray = {};
        ArrayIterator<String> emptyIterator = new ArrayIterator<>(emptyArray);

        System.out.println("Empty Array:");
        while (emptyIterator.hasNext()) {
            System.out.println("  " + emptyIterator.next());
        }
        System.out.println();
    }

    private static void testBTreeIterator() {
        System.out.println("---Binary Tree Iterator---");

        BinaryTree tree = new BinaryTree();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(1);
        tree.add(4);
        tree.add(6);
        tree.add(8);

        BTreeIterator iterator = new BTreeIterator(tree.root);

        System.out.println("Binary tree 5 3 7 1 4 6 8:");
        while (iterator.hasNext()) {
            System.out.println("  " + iterator.next());
        }

        BinaryTree singleTree = new BinaryTree();
        singleTree.add(10);

        BTreeIterator singleIterator = new BTreeIterator(singleTree.root);
        
        System.out.println("Single node:");
        while (singleIterator.hasNext()) {
            System.out.println("  " + singleIterator.next());
        }
        
        System.out.println();
    }

    private static void testMatrixIterator() {
        System.out.println("T---Matrix Iterator---.");

        Integer[][] intMatrix = {
            {1, 2, 3},
            {4, 5, 6}
        };
        MatrixIterator<Integer> intIterator = new MatrixIterator<>(intMatrix);

        System.out.println("2x3 Integer matrix:");
        while (intIterator.hasNext()) {
            System.out.println("  " + intIterator.next());
        }

        String[][] stringMatrix = {
            {"A", "B"},
            {"C", "D"},
            {"E", "F"}
        };
        MatrixIterator<String> stringIterator = new MatrixIterator<>(stringMatrix);

        System.out.println("3x2 String matrix:");
        while (stringIterator.hasNext()) {
            System.out.println("  " + stringIterator.next());
        }

        Integer[][] singleMatrix = {{42}};
        MatrixIterator<Integer> singleIterator = new MatrixIterator<>(singleMatrix);

        System.out.println("1x1 matrix:");
        while (singleIterator.hasNext()) {
            System.out.println("  " + singleIterator.next());
        }
        
        System.out.println();
    }
}
