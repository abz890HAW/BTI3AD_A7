package BinTree.BinListTree;

import BinTree.IBinTree;

/**
 * Created by marble on 5/10/17.
 */
public class BinListTree implements IBinTree {

    private Comparable[] comparables;
    private final int depth;
    private int maxEntryLen = 0;

    public BinListTree(int depth) {
        this.depth = depth;
        comparables = new Comparable[(int)Math.pow(2, depth+1)-1];
    }

    private int leftOf(int idx) {
        return 2*idx+1;
    }

    private int rightOf(int idx) {
        return 2*idx+2;
    }

    public boolean insert(Comparable comparable) {
        int idx = 0;
        int entryLen = comparable.toString().length();
        while(null != comparables[idx]) {
            int comparison = comparables[idx].compareTo(comparable);
            /* check if element is already in tree */
            if(0 == comparison) {
                return false;
            }
            idx = (comparison > 0) ? leftOf(idx) : rightOf(idx);
        }
        maxEntryLen = (entryLen > maxEntryLen) ? entryLen : maxEntryLen;
        /* make number even */
        maxEntryLen += maxEntryLen%2;
        comparables[idx] = comparable;
        return true;
    }

    public Comparable[] getInOrder() {
        return getOrderReku(0, Order.IN);
    }

    public Comparable[] getPreOrder() {
        return getOrderReku(0, Order.PRE);
    }

    public Comparable[] getPostOrder() {
        return getOrderReku(0, Order.POST);
    }

    private Comparable[] getOrderReku(int idx, Order order) {
        Comparable[] result = {};
        if(null != comparables[idx]) {
            switch (order) {
                case IN:
                    result = concat(result, getOrderReku(leftOf(idx), order));
                    result = concat(result, new Comparable[]{comparables[idx]});
                    result = concat(result, getOrderReku(rightOf(idx), order));
                    break;
                case PRE:
                    result = concat(result, new Comparable[]{comparables[idx]});
                    result = concat(result, getOrderReku(leftOf(idx), order));
                    result = concat(result, getOrderReku(rightOf(idx), order));
                    break;
                case POST:
                    result = concat(result, getOrderReku(leftOf(idx), order));
                    result = concat(result, getOrderReku(rightOf(idx), order));
                    result = concat(result, new Comparable[]{comparables[idx]});
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

    @Override
    public String toString() {
        String result = "";
        int idx = 0;
        for(int height = 0; height < depth; height++) {
            String seperator = "";
            for(int i = 0; i < Math.pow(2, height); i++) {
                idx = (int)Math.pow(2, height)-1+i;
                if(null != comparables[idx]) {
                    result += comparables[idx] + " ";
                }
            }
            result += "\n";
        }

        return result;
    }
}
