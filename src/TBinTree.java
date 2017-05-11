import BinTree.BinLinkedTree.BinLinkedTree;
import BinTree.BinListTree.BinListTree;
import BinTree.IBinTree;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by marble on 5/10/17.
 */
public class TBinTree {
    private static final int DEPTH = 8;
    /* unique random numbers !! */
    private static final int[] VAL_ARR = {28,  4, 82, 20, 93,
                                          21, 49, 86,  0, 42,
                                          22, 14, 39, 77, 37,
                                          87, 24, 19, 27, 25,
                                          47, 30, 81, 89,  5};
    private static IBinTree binTree;

    @Before
    public void init() {
        binTree = new BinLinkedTree();
        //binTree = new BinListTree(DEPTH);
    }

    @Test
    public void test() {
        /* clone array and sort for comparison */
        Comparable[] sorted = new Comparable[VAL_ARR.length];
        for(int i = 0; i < VAL_ARR.length; i++) {
            sorted[i] = VAL_ARR[i];
        }
        Arrays.sort(sorted);
        /* fill array with unique random numbers */
        for(int val: VAL_ARR) {
            assertTrue(binTree.insert(val));
        }
        /* try to insert one number again */
        assertFalse(binTree.insert(VAL_ARR[0]));
        /* get InOrder output and compare to sorted clone */
        assertArrayEquals(binTree.getInOrder(), sorted);
        System.out.println(binTree);
    }

}
