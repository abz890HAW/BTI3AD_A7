package BinTree.BinLinkedTree;

/**
 * Created by marble on 5/10/17.
 */
public class Vertex {
    private Vertex left, right;
    private Comparable value;

    public Vertex getLeft() {
        return left;
    }

    public Vertex getRight() {
        return right;
    }

    public Comparable getValue() {
        return value;
    }

    public void setLeft(Vertex left) {
        this.left = left;
    }

    public void setRight(Vertex right) {
        this.right = right;
    }

    public void setValue(Comparable value) {
        this.value = value;
    }
}
