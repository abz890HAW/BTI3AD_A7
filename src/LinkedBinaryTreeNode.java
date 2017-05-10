package aufgabe7.src;

/**
 * Created by Niels Gandraß on 10.05.2017.
 */
public class LinkedBinaryTreeNode<T extends Comparable> {

    /**
     * Actual node-value
     */
    private T _value;

    /**
     * Left child of node
     */
    private LinkedBinaryTreeNode<T> _leftChild;

    /**
     * Right child of node
     */
    private LinkedBinaryTreeNode<T> _rightChild;

    public LinkedBinaryTreeNode(T value) {
        this(value, null, null);
    }

    public LinkedBinaryTreeNode(T value, LinkedBinaryTreeNode<T> leftChild, LinkedBinaryTreeNode<T> rightChild) {
        this._value = value;
        this._leftChild = leftChild;
        this._rightChild = rightChild;
    }

    public T getValue() {
        return _value;
    }

    public void setValue(T value) {
        _value = value;
    }

    public LinkedBinaryTreeNode<T> getLeftChild() {
        return _leftChild;
    }

    public void setLeftChild(LinkedBinaryTreeNode<T> leftChild) {
        _leftChild = leftChild;
    }

    public LinkedBinaryTreeNode<T> getRightChild() {
        return _rightChild;
    }

    public void setRightChild(LinkedBinaryTreeNode<T> rightChild) {
        _rightChild = rightChild;
    }
}
