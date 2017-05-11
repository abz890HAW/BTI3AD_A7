package BinTree.BinLinkedTree;

import BinTree.IBinTree;

/**
 * Created by marble on 5/10/17.
 */
public class BinLinkedTree implements IBinTree {
    private Vertex root = null;

    @Override
    public boolean insert(Comparable value) {
        if(null == root) {
            root = new Vertex(value);
            return true;
        }
        return root.insert(value);
    }

    public Comparable[] getInOrder() {
        return getOrderReku(root, Order.IN);
    }

    public Comparable[] getPreOrder() {
        return getOrderReku(root, Order.PRE);
    }

    public Comparable[] getPostOrder() {
        return getOrderReku(root, Order.POST);
    }

    private Comparable[] getOrderReku(Vertex root, Order order) {
        Comparable[] result = {};
        if(null != root) {
            switch (order) {
                case IN:
                    result = concat(result, getOrderReku(root.getLeft(), order));
                    result = concat(result, new Comparable[]{root.getValue()});
                    result = concat(result, getOrderReku(root.getRight(), order));
                    break;
                case PRE:
                    result = concat(result, new Comparable[]{root.getValue()});
                    result = concat(result, getOrderReku(root.getLeft(), order));
                    result = concat(result, getOrderReku(root.getRight(), order));
                    break;
                case POST:
                    result = concat(result, getOrderReku(root.getLeft(), order));
                    result = concat(result, getOrderReku(root.getRight(), order));
                    result = concat(result, new Comparable[]{root.getValue()});
                    break;
            }
        }
        return result;
    }

    private Comparable[] concat(Comparable[] A, Comparable[] B) {
        Comparable[] result = new Comparable[A.length + B.length];
        for(int i = 0; i < A.length; i++) {
            result[i] = A[i];
        }
        for(int i = 0; i < B.length; i++) {
            result[A.length+i] = B[i];
        }
        return result;
    }
}
