package dictionary;

/**
 * this class represents node of BST(Binary Search Tree).
 *
 */
public class Node {
    private int key;
    private String value;
    private Node leftChild;
    private Node rightChild;
    
    public Node(int key,String value)
    {
        this.key=key;
        this.value=value;
        leftChild=null;
        rightChild=null;
    }
    
    public int getKey() {
        return key;
    }
    public void setKey(int key) {
        this.key = key;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public Node getLeftChild() {
        return leftChild;
    }
    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }
    public Node getRightChild() {
        return rightChild;
    }
    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

}
