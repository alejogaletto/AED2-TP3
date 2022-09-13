package Node;

public class Node {
    private int data;
    private int bf;
    private int height;
    private Node leftChild;
    private Node rightChild;

    public Node(int data){
        this.data = data;
    }

    public void setData(int data) {
        this.data = data;
    }
    public int getData() {
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

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }
    public Node getLeftChild() {
        return leftChild;
    }

    public void setRightChild(Node rigthChild) {
        this.rightChild = rigthChild;
    }
    public Node getRightChild() {
        return rightChild;
    }

   
    public int compareTo(int o) {
        if (this.getData()>o) {
            return 1;
        } else if (this.getData()<o) {
            return -1;
        } else {
            return 0;
        }
    }

}
