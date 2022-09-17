package Trees;




import Node.Node;

public class AVL<T extends Comparable<T>> extends ABB<T>{



    
    public AVL<T> insert(T data) {
        root = insertAVL(data, root);
        return this;
    }

    private Node<T> insertAVL(T data, Node<T> node) {
        if (node == null) {
            return new Node<>(data);
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(insertAVL(data, node.getLeftChild()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(insertAVL(data, node.getRightChild()));
        } else {
            return node;
        }
        updateHeight(node);
        return rotate(node);
    }

	public boolean delete(T data) {
        if (isEmpty()) {
            return false;
        }
        root = deleteAVL(data, root);
        return true;   
    }

    private Node<T> deleteAVL(T data, Node<T> node) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(deleteAVL(data, node.getLeftChild()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(deleteAVL(data, node.getRightChild()));
        } else {
            
            if (node.getLeftChild() == null) {
                return node.getRightChild();
            } else if (node.getRightChild() == null) {
                return node.getLeftChild();
            }
            node.setData(getMax(node.getLeftChild()));
            node.setLeftChild(deleteAVL(node.getData(), node.getLeftChild()));
        }
        updateHeight(node);
        return rotate(node);
    }

    
    public void traversalAVL() {
        traverse(root);
    }

    private void traverse(Node<T> node) {
        if (node != null) {
            traverse(node.getLeftChild());
            System.out.println(node.getData() + "(" + balance(node) + ")");
            traverse(node.getRightChild());
        }
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

    private Node<T> rotate(Node<T> node) {
        int balance = balance(node);
        if (balance > 1) {
            if (balance(node.getLeftChild()) < 0) {
                node.setLeftChild(rotateLeft(node.getLeftChild()));
            }
            return rotateRight(node);
        }
        if (balance < -1) {
            if (balance(node.getRightChild()) > 0) {
                node.setRightChild(rotateRight(node.getRightChild()));
            }
            return rotateLeft(node);
        }
        return node;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> leftNode = node.getLeftChild();
        Node<T> centerNode = leftNode.getRightChild();
        leftNode.setRightChild(node);
        node.setLeftChild(centerNode);
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> rightNode = node.getRightChild();
        Node<T> centerNode = rightNode.getLeftChild();
        rightNode.setLeftChild(node);
        node.setRightChild(centerNode);
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }

    private void updateHeight(Node<T> node) {
        int maxHeight = Math.max(
                height(node.getLeftChild()),
                height(node.getRightChild())
        );
        node.setHeight(maxHeight + 1);
    }

    private int balance(Node<T> node) {
        return node != null ? height(node.getLeftChild()) - height(node.getRightChild()) : 0;
    }

    private int height(Node<T> node) {
        return node != null ? node.getHeight() : 0;
    }

}

