package Node;

public class Node<T extends Comparable<T>> {
    private T data;
    private int bf;
    private int height = 1;
    public Node<T> leftChild;
    private Node<T> rightChild;

    public Node(T data){
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public T getData() {
        return data;
    }

    public void setBf(int bf) {
        this.bf = bf;
    }
    public int getBf() {
        return bf;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public int getHeight() {
        return height;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }
    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setRightChild(Node<T> rigthChild) {
        this.rightChild = rigthChild;
    }
    public Node<T> getRightChild() {
        return rightChild;
    }

   

}
