package BinTree;

/**
 * Created by marble on 5/10/17.
 */
public interface IBinTree {
    enum Order{
        IN,
        PRE,
        POST
    }

    boolean insert(Comparable comparable);
    Comparable[] getInOrder();
    Comparable[] getPreOrder();
    Comparable[] getPostOrder();
}
