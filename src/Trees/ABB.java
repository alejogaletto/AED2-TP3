package Trees;

import Node.Node;

public class ABB<T extends Comparable<T>> {
    public Node<T> root;
    

    public ABB<T> insert(T data) {
        root = insert(data, root);

        return this;
    }

    protected Node<T> insert(T data, Node<T> node) {
        if (node == null) {
            return new Node<>(data);
        }
        if (data.compareTo(node.getData()) < 0) {

            node.setLeftChild(insert(data, node.getLeftChild()));
            
        }else if(data.compareTo(node.getData())> 0){
            
            node.setRightChild(insert(data, node.getRightChild()));


        }   

        return node;
    }

    public boolean delete(T data) {
        if (isEmpty()) {
            return false;
        }
        root = delete(data, root);
        return true;   
    }

    protected Node<T> delete(T data, Node<T> node) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.getData()) < 0) {
            
            node.setLeftChild(delete(data, node.getLeftChild()));
        } else if (data.compareTo(node.getData()) > 0) {
            
            node.setRightChild(delete(data, node.getRightChild()));
        } else {

            if (node.getLeftChild() == null) {
                return node.getRightChild();
            } else if (node.getRightChild() == null) {
                return node.getLeftChild();
            }


            node.setData(getMax(node.getLeftChild()));
            node.setLeftChild(delete(node.getData(), node.getLeftChild()));
        }
        return node;
    }

    
    public T getMax() {
        if (isEmpty()) {
            return null;
        }
        return getMax(root);
    }

    protected T getMax(Node<T> node) {
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }
        return node.getData();
    }

    public T getMin() {
        if (isEmpty()) {
            return null;
        }
        return getMin(root);
    }   

    protected T getMin(Node<T> node) {
        if (node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        }
        return node.getData();
    }


    public boolean isEmpty() {
        return root == null;
    }

    public void traversal() {
        inorder(root);
    }

    protected void inorder(Node<T> node) {
        if (node == null) {
            return;
        }
        inorder(node.getLeftChild());
        System.out.println(node.getData());
        inorder(node.getRightChild());
    } 
   
}
