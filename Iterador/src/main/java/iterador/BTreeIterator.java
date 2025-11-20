package iterador;

import java.util.ArrayList;

public class BTreeIterator implements Iterator<Integer> {

    ArrayList<BinaryTree.Node> elements;
    
    public BTreeIterator(BinaryTree.Node node) {
        elements = new ArrayList<>();
        
        elements.add(node);
    }
    
    @Override
    public boolean hasNext() {
    
        return !elements.isEmpty();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return 0;
        }
        
        BinaryTree.Node node = elements.getFirst();
        
        if (node.left != null) {
            elements.add(node.left);
        }
        if (node.right != null) {
            elements.add(node.right);
        }
        
        elements.remove(0);
        return node.value;
        
    }

}
