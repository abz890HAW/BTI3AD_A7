package aufgabe7.src;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Implemenation of a binary searchtree based on an internal linked structure of nodes of T
 * @param <T> Datatype to be stored
 */
public class LinkedBinaryTree<T extends Comparable> implements BinaryTree<T> {

    /**
     * Root node of the LinkedBinaryTree
     */
    private LinkedBinaryTreeNode _rootNode;

    @Override
    public void insert(T newValue) {
        // Check if root node is present
        if(_rootNode == null) {
            _rootNode = new LinkedBinaryTreeNode(newValue);
            return;
        }

        // Insert element at correct position
        LinkedBinaryTreeNode curNode = _rootNode;
        while(true) {
            // Filter out duplicates
            if(curNode.getValue().compareTo(newValue) == 0)
                return;

            // Check where to insert
            if(curNode.getValue().compareTo(newValue) < 0) {
                // newValue > curNodes-Value => Go right
                if (curNode.getRightChild() == null) {
                    curNode.setRightChild(new LinkedBinaryTreeNode<>(newValue));
                    return;
                }

                curNode = curNode.getRightChild();
            } else {
                // newValue < curNodes-Value => Go left
                if(curNode.getLeftChild() == null) {
                    curNode.setLeftChild(new LinkedBinaryTreeNode<>(newValue));
                    return;
                }

                curNode = curNode.getLeftChild();
            }
        }

    }

    @Override
    public String toString(ORDER_TYPE sortType) {
        switch (sortType) {
            case BREADTH_FIRST:
                throw new NotImplementedException();
            case INORDER:
                return "INORDER: [" + toStringInorder(_rootNode) + "]";
            case PREORDER:
                return "PREORDER: [" + toStringPreorder(_rootNode) + "]";
            case POSTORDER:
                return "POSTORDER: [" + toStringPostorder(_rootNode) + "]";
        }

        return null;
    }

    /**
     * Generates String inorder-represenataion of tree starting at given node
     * @param curNode Node to start from
     * @return Inorder-representation of tree
     */
    private String toStringInorder(LinkedBinaryTreeNode curNode) {
        if (curNode == null)
            return "";

        return appendSep(toStringInorder(curNode.getLeftChild())) + curNode.getValue() + prependSep(toStringInorder(curNode.getRightChild()));
    }

    /**
     * Generates String preorder-represenataion of tree starting at given node
     * @param curNode Node to start from
     * @return Preorder-representation of tree
     */
    private String toStringPreorder(LinkedBinaryTreeNode curNode) {
        if (curNode == null)
            return "";

        return curNode.getValue() + prependSep(toStringInorder(curNode.getLeftChild())) + prependSep(toStringInorder(curNode.getRightChild()));
    }

    /**
     * Generates String postorder-represenataion of tree starting at given node
     * @param curNode Node to start from
     * @return Postorder-representation of tree
     */
    private String toStringPostorder(LinkedBinaryTreeNode curNode) {
        if (curNode == null)
            return "";

        return appendSep(toStringInorder(curNode.getLeftChild())) + appendSep(toStringInorder(curNode.getRightChild())) + curNode.getValue();
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
