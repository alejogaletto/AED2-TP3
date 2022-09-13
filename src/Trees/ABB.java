package Trees;

import Node.Node;

public class ABB {
    public Node root;
    

    public ABB insert(int data) {
        root = insert(data, root);

        return this;
    }

    private Node insert(int data, Node node) {
        if (node == null) {
            return new Node(data);
        }
        if (node.compareTo(data) > 0) {
            //izquierda
            node.setLeftChild(insert(data, node.getLeftChild()));
            
        }else if(node.compareTo(data) < 0){
            //derecha
            node.setRightChild(insert(data, node.getRightChild()));


        }   

        return node;
    }

    public boolean delete(int data) {
        if (isEmpty()) {
            return false;
        }
        root = delete(data, root);
        return true;
        
    }

    private Node delete(int data, Node node) {
        if (node == null) {
            return null;
        }
        if (node.compareTo(data) > 0) {
            //izquierda
            node.setLeftChild(delete(data, node.getLeftChild()));
        } else if (node.compareTo(data) < 0) {
            //derecha
            node.setRightChild(delete(data, node.getRightChild()));
        } else {
            // un hijo
            if (node.getLeftChild() == null) {
                return node.getRightChild();
            } else if (node.getRightChild() == null) {
                return node.getLeftChild();
            }
            //dos hijos

            node.setData(getMax(node.getLeftChild()));
            node.setLeftChild(delete(node.getData(), node.getLeftChild()));
        }
        return node;
    }

    
    public int getMax() {
        if (isEmpty()) {
            return 0;
        }
        return getMax(root);
    }

    private int getMax(Node node) {
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }
        return node.getData();
    }


    public boolean isEmpty() {
        return root == null;
    }

    public void traversal() {
        InOrder(root);
    }

    private void InOrder(Node node) {
        if (node == null) {
            return;
        }
        InOrder(node.getLeftChild());
        System.out.println(node.getData());
        InOrder(node.getRightChild());
    }
   
}
