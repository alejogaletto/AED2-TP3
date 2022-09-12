package Trees;

import Node.Node;

public class ABB {
    public Node root;
    

    public ABB insert(int data) {
        // if (contains()) {
        //     return null;
        // }
        root = insert(data, root);
        return this;
    }

    public Node insert(int data, Node node) {
        if (node == null) {
            return new Node(data);
        }
        if (node.compareTo(data) < 0) {
            //izquierda
            node.setLeftChild(insert(data, node.getLeftChild()));
        }else if(node.compareTo(data) > 0){
            //derecha
            node.setRigthChild(insert(data, node.getRigthChild()));
        }   

        return node;
    }

    // public boolean contains() {
        
    // }

   
}
