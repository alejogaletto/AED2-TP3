package Node;

public class Node {
    private int data;
    private Node leftChild;
    private Node rigthChild;

    public Node(int data){
        this.data = data;
    }

    public void setData(int data) {
        this.data = data;
    }
    public int getData() {
        return data;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }
    public Node getLeftChild() {
        return leftChild;
    }

    public void setRigthChild(Node rigthChild) {
        this.rigthChild = rigthChild;
    }
    public Node getRigthChild() {
        return rigthChild;
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
