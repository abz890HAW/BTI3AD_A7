package BinTree.BinLinkedTree;

/**
 * Created by marble on 5/10/17.
 */
public class Vertex {
    private Vertex left, right;
    private Comparable value;

    Vertex(Comparable value) {
        this.value = value;
    }

    boolean insert(Comparable value) {
        int comparison = value.compareTo(this.value);
        if(0 == comparison) {
            return false;
        }
        if(comparison < 0) {
            if(null == left) {
                left = new Vertex(value);
                return true;
            }
            else {
                return left.insert(value);
            }
        }
        else {
            if(null == right) {
                right = new Vertex(value);
                return true;
            }
            else {
                return right.insert(value);
            }
        }
    }

    public Vertex getLeft() {
        return left;
    }

    public Vertex getRight() {
        return right;
    }

    public Comparable getValue() {
        return value;
    }
}
