package Trees;



import Node.Node;

public class AVL<T extends Comparable<T>> extends ABB<T> {
	
	public AVL<T> insertAVL(T data) {
		root = insertAVL(data, root);
		return this;
	}

	protected Node<T> insertAVL(T data, Node<T> node ){
		// if (node == null) {
        //     return new Node<>(data);
        // }
        // if (data.compareTo(node.getData()) < 0) {
        //     node.setLeftChild(insert(data, node.getLeftChild()));
        // } else if (data.compareTo(node.getData()) > 0) {
        //     node.setRightChild(insert(data, node.getRightChild()));
        // } else {
        //     return node;
        // }
        // updateHeight(node);
        // return rotate(node);
		updateHeight(insert(data, node));
		return rotate(insert(data, node));
	}

	public boolean deleteAVL(T data) {
        if (isEmpty()) {
            return false;
        }
        root = delete(data, root);
        return true;
        
    }

	protected Node<T> deleteAVL(T data, Node<T> node) {
		updateHeight(delete(data, node));
        return rotate(delete(data, node));
    }

	protected void inorder(Node<T> node) {
		if (node == null) {
			return;
		}
		inorder(node.getLeftChild());
        System.out.println(node.getData() +"(" + balance(node) + ")");
        inorder(node.getRightChild());

	}

	private Node<T> rotate(Node<T> node) {
		int balance = balance(node);
		if (balance > 1) {
			if (balance(node.getLeftChild()) < 0) {
				node.setLeftChild(leftRotation(node.getLeftChild()));
			}
			return rightRotation(node);
		}
		if (balance < -1) {
			if (balance(node.getRightChild()) > 0) {
				node.setRightChild(rightRotation(node.getRightChild()));
			}
			return leftRotation(node);
		}
		return node;
	}

	private Node<T> leftRotation(Node<T> node) {
		Node<T> rightNode = node.getLeftChild();
		Node<T> centerNode = rightNode.getRightChild();
		rightNode.setLeftChild(node);
		node.setRightChild(centerNode);
		updateHeight(node);
		updateHeight(rightNode);
		return rightNode;
	}
	
	private Node<T> rightRotation(Node<T> node) {
        Node<T> leftNode = node.getLeftChild();
        Node<T> centerNode = leftNode.getRightChild();
        leftNode.setRightChild(node);
        node.setLeftChild(centerNode);
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }



	private void updateHeight(Node<T> node) {
		int maxHeight = Math.max(height(node.getLeftChild()), height(node.getRightChild()));
		node.setHeight(maxHeight + 1);
	}

	private int height(Node<T> node) {
		return node != null ? node.getHeight() : 0;
	}

	
	private int balance(Node<T> node) {
		return node != null ? height(node.getLeftChild()) - height(node.getRightChild()) : 0;
	}
	
}


