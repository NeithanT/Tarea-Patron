package iterador;

// Arbol binario chiva
public class BinaryTree {

    public Node getRoot() {
        return root;
    }

    
    public class Node{
        
        Node left;
        Node right;
        int value;

        public Node(int val) {
            value = val;
        }
        
        public Node() {}
        
    }
    
    Node root;
    
    public BinaryTree() {
        
        
    }
    
    public void add(int val) {
    
        Node node = new Node(val);
        
        if (root == null) {
            root = node;
        } else {    
            addRecursive(root, node);
        }
    }
    
    public void addRecursive(Node base, Node node) {
    
        if (base == null) {
            return;
        }
        
        if (node.value > base.value) {
            if (base.right == null) {
                base.right = node;
            } else {
                addRecursive(base.right, node);
            }
        } else {
            if (base.left == null) {
                base.left = node;
            } else {
                addRecursive(base.left, node);
            }
        }
    }
    
}
