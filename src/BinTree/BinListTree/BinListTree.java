package BinTree.BinListTree;

import BinTree.IBinTree;

/**
 * Created by marble on 5/10/17.
 */
public class BinListTree implements IBinTree {
    private Comparable[] comparables;

    public BinListTree(int depth) {
        comparables = new Comparable[(int)Math.pow(2, depth)];
    }

    private int leftOf(int idx) {
        return 2*idx+1;
    }

    private int rightOf(int idx) {
        return 2*idx+2;
    }

    public boolean insert(Comparable comparable) {
        int idx = 0;
        while(null != comparables[idx]) {
            int comparison = comparables[idx].compareTo(comparable);
            /* check if element is already in tree */
            if(0 == comparison) {
                return false;
            }
            idx = (comparison > 0) ? leftOf(idx) : rightOf(idx);
        }
        comparables[idx] = comparable;
        return true;
    }

    @Override
    public Comparable[] getInOrder() {
        return getInOrderReku(0);
    }

    private Comparable[] getInOrderReku(int idx) {
        Comparable[] result = {};
        if(null != comparables[idx]) {
            result = concat(result, getInOrderReku(leftOf(idx)));
            result = concat(result, new Comparable[]{comparables[idx]});
            result = concat(result, getInOrderReku(rightOf(idx)));
        }
        return result;
    }

    @Override
    public Comparable[] getPreOrder() {
        return null;
    }

    @Override
    public Comparable[] getPostOrder() {
        return null;
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
