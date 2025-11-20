package iterador;

public class Iterador {

    public static void main(String[] args) {
        System.out.println("=== Iterator Pattern Tests ===\n");

        // Test ArrayIterator
        testArrayIterator();

        // Test BTreeIterator
        testBTreeIterator();

        // Test MatrixIterator
        testMatrixIterator();

        System.out.println("All iterator tests completed!");
    }

    private static void testArrayIterator() {
        System.out.println("Testing ArrayIterator...");

        // Test with String array
        String[] stringArray = {"Hello", "World", "Test"};
        ArrayIterator<String> stringIterator = new ArrayIterator<>(stringArray);

        System.out.println("String array iteration:");
        while (stringIterator.hasNext()) {
            System.out.println("  " + stringIterator.next());
        }

        // Test with Integer array
        Integer[] intArray = {1, 2, 3, 4, 5};
        ArrayIterator<Integer> intIterator = new ArrayIterator<>(intArray);

        System.out.println("Integer array iteration:");
        while (intIterator.hasNext()) {
            System.out.println("  " + intIterator.next());
        }

        // Test with empty array
        String[] emptyArray = {};
        ArrayIterator<String> emptyIterator = new ArrayIterator<>(emptyArray);

        System.out.println("Empty array iteration (should print nothing):");
        while (emptyIterator.hasNext()) {
            System.out.println("  " + emptyIterator.next());
        }
        System.out.println();
    }

    private static void testBTreeIterator() {
        System.out.println("Testing BTreeIterator...");

        // Create a binary tree and add values
        BinaryTree tree = new BinaryTree();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(1);
        tree.add(4);
        tree.add(6);
        tree.add(8);

        // Create iterator starting from root
        BTreeIterator iterator = new BTreeIterator(tree.root);

        System.out.println("Binary tree level-order iteration:");
        while (iterator.hasNext()) {
            System.out.println("  " + iterator.next());
        }

        // Test with single node tree
        BinaryTree singleTree = new BinaryTree();
        singleTree.add(10);

        BTreeIterator singleIterator = new BTreeIterator(singleTree.root);
        System.out.println("Single node tree iteration:");
        while (singleIterator.hasNext()) {
            System.out.println("  " + singleIterator.next());
        }
        System.out.println();
    }

    private static void testMatrixIterator() {
        System.out.println("Testing MatrixIterator...");

        // Test with 2x3 integer matrix
        Integer[][] intMatrix = {
            {1, 2, 3},
            {4, 5, 6}
        };
        MatrixIterator<Integer> intIterator = new MatrixIterator<>(intMatrix);

        System.out.println("2x3 Integer matrix iteration:");
        while (intIterator.hasNext()) {
            System.out.println("  " + intIterator.next());
        }

        // Test with 3x2 string matrix
        String[][] stringMatrix = {
            {"A", "B"},
            {"C", "D"},
            {"E", "F"}
        };
        MatrixIterator<String> stringIterator = new MatrixIterator<>(stringMatrix);

        System.out.println("3x2 String matrix iteration:");
        while (stringIterator.hasNext()) {
            System.out.println("  " + stringIterator.next());
        }

        // Test with 1x1 matrix
        Integer[][] singleMatrix = {{42}};
        MatrixIterator<Integer> singleIterator = new MatrixIterator<>(singleMatrix);

        System.out.println("1x1 matrix iteration:");
        while (singleIterator.hasNext()) {
            System.out.println("  " + singleIterator.next());
        }
        System.out.println();
    }
}
