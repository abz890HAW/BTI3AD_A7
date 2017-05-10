package aufgabe7.src;

/**
 * Interface for comparable binary search trees.
 * @param <T> Datatype to store (must extend Comparable)
 */
public interface BinaryTree<T extends Comparable> {

    /**
     * Enumeration for supported order types
     */
    enum ORDER_TYPE {INORDER, PREORDER, POSTORDER, BREADTH_FIRST}

    /**
     * Inserts a new node into the tree
     * @param node Node to be inserted
     * @throws NullPointerException - if node == null
     */
    void insert(T node);

    /**
     * Returns a string representation of the tree accorting to sortType
     * @param sortType Desired sorting method
     * @return String repsentation of the tree
     */
    String toString(ORDER_TYPE sortType);

}
