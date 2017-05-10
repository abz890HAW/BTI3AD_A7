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

    public boolean insert(Comparable comparable) {
        return true;
    }

    @Override
    public String getInOrder() {
        return null;
    }

    @Override
    public String getPreOrder() {
        return null;
    }

    @Override
    public String getPostOrder() {
        return null;
    }
}
