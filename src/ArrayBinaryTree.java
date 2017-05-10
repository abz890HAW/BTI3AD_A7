package aufgabe7.src;

import java.util.Arrays;

/**
 * Implemenation of a binary searchtree based on an internal array of T
 * @param <T> Datatype to be stored
 */
public class ArrayBinaryTree<T extends Comparable> implements BinaryTree<T> {

    /**
     * Internal data array
     */
    private T[] _data;

    /**
     * Index of first element in array
     */
    private static final int FIRST_NODE_INDEX = 1;

    /**
     * Initial array-size (Tree with 3 nodes)
     */
    private static final int INITIAL_SIZE = FIRST_NODE_INDEX + 3;

    @SuppressWarnings("unchecked")
    public ArrayBinaryTree() {
        _data = (T[]) new Comparable[INITIAL_SIZE];
    }

    public static void main(String[] args) {
        ArrayBinaryTree<Integer> tree = new ArrayBinaryTree<>();
        for (int i = 0; i < 6; i++) {
            tree.insert((int) (Math.random() * 100));
        }
        System.out.println(tree.toString(ORDER_TYPE.BREADTH_FIRST));
        System.out.println(tree.toString(ORDER_TYPE.INORDER));
        System.out.println(tree.toString(ORDER_TYPE.PREORDER));
        System.out.println(tree.toString(ORDER_TYPE.POSTORDER));
    }

    @Override
    public void insert(T newValue) {
        // Check input
        if(newValue == null) {
            throw new NullPointerException();
        }

        // Check if new element is first element in Tree
        if (_data[FIRST_NODE_INDEX] == null) {
            _data[FIRST_NODE_INDEX] = newValue;
            return;
        }

        // Insert value
        int curNode = FIRST_NODE_INDEX;
        while (true) {
            try {
                // Check for duplicates
                if (_data[curNode].compareTo(newValue) == 0) {
                    return;
                }

                // Proceed to children
                if (_data[curNode].compareTo(newValue) < 0) {
                    // newValue > curNodes-Value => Go right
                    if (_data[getRightNodeIndex(curNode)] == null) {
                        _data[getRightNodeIndex(curNode)] = newValue;
                        return;
                    }

                    curNode = getRightNodeIndex(curNode);
                } else {
                    // newValue < curNodes-Value => Go left
                    if (_data[getLeftNodeIndex(curNode)] == null) {
                        _data[getLeftNodeIndex(curNode)] = newValue;
                        return;
                    }

                    curNode = getLeftNodeIndex(curNode);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                // Index out of array reached. Increment length by one level of the tree (n = length + 2^log2(length)
                _data = Arrays.copyOf(_data, _data.length + (int) Math.pow(2, (int) (Math.log(_data.length) / Math.log(2))));
            }
        }
    }

    /**
     * Determines the index of the left node of the given index
     * @param i Index of father node
     * @return Index of left child of father
     */
    private int getLeftNodeIndex(int i) {
        return 2 * i;
    }

    /**
     * Determines the index of the right node of the given index
     * @param i Index of father node
     * @return Index of right child of father
     */
    private int getRightNodeIndex(int i) {
        return 2 * i + 1;
    }

    @Override
    public String toString(ORDER_TYPE sortType) {
        switch (sortType) {
            case BREADTH_FIRST:
                return "BREADTH_FIRST: " + Arrays.toString(_data).replace(", null", "").replace("null, ", "");
            case INORDER:
                return "INORDER: [" + toStringInorder(FIRST_NODE_INDEX) + "]";
            case PREORDER:
                return "PREORDER: [" + toStringPreorder(FIRST_NODE_INDEX) + "]";
            case POSTORDER:
                return "POSTORDER: [" + toStringPostorder(FIRST_NODE_INDEX) + "]";
        }

        return null;
    }

    /**
     * Generates String inorder-represenataion of tree starting at node with index of nodeIndex
     * @param nodeIndex Node index to start at. Usually FIRST_NODE_INDEX is desired here.
     * @return Inorder-representation of tree
     */
    private String toStringInorder(int nodeIndex) {
        if (nodeIndex >= _data.length || _data[nodeIndex] == null)
            return "";

        return appendSep(toStringInorder(getLeftNodeIndex(nodeIndex))) + _data[nodeIndex] + prependSep(toStringInorder(getRightNodeIndex(nodeIndex)));
    }

    /**
     * Generates String preorder-represenataion of tree starting at node with index of nodeIndex
     * @param nodeIndex Node index to start at. Usually FIRST_NODE_INDEX is desired here.
     * @return Preorder-representation of tree
     */
    private String toStringPreorder(int nodeIndex) {
        if (nodeIndex >= _data.length || _data[nodeIndex] == null)
            return "";

        return _data[nodeIndex] + prependSep(toStringPreorder(getLeftNodeIndex(nodeIndex))) + prependSep(toStringPreorder(getRightNodeIndex(nodeIndex)));
    }

    /**
     * Generates String postorder-represenataion of tree starting at node with index of nodeIndex
     * @param nodeIndex Node index to start at. Usually FIRST_NODE_INDEX is desired here.
     * @return Postorder-representation of tree
     */
    private String toStringPostorder(int nodeIndex) {
        if (nodeIndex >= _data.length || _data[nodeIndex] == null)
            return "";

        return appendSep(toStringPostorder(getLeftNodeIndex(nodeIndex))) + appendSep(toStringPostorder(getRightNodeIndex(nodeIndex))) + _data[nodeIndex];
    }

    /**
     * Appends a seperator to input if input is not empty
     * @param input String to append a seperator to
     * @return String with seperator or empty string
     */
    private String appendSep(String input) {
        if (!input.isEmpty()) {
            return input + ",";
        }

        return "";
    }

    /**
     * Prepends a seperator to input if input is not empty
     * @param input String to prepend a seperator to
     * @return String with seperator or empty string
     */
    private String prependSep(String input) {
        if (!input.isEmpty()) {
            return "," + input;
        }

        return "";
    }

}
