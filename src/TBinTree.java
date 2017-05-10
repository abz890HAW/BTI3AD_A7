import BinTree.BinListTree.BinListTree;
import BinTree.IBinTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by marble on 5/10/17.
 */
public class TBinTree {
    private static final int DEPTH = 10;
    /* unique random numbers !! */
    private static final int[] VAL_ARR = {28,  4, 82, 20, 93,
                                          21, 49, 86,  0, 42,
                                          22, 14, 39, 77, 37,
                                          87, 24, 19, 27, 25,
                                          47, 30, 81, 89,  5};
    private static IBinTree binTree;

    @Before
    public void init() {
        binTree = new BinListTree(DEPTH);
    }

    @Test
    public void test() {
        /* fill array with unique random numbers */
        for(int val: VAL_ARR) {
            assertTrue(binTree.insert(val));
        }
        /* insert one number again */
        assertFalse(binTree.insert(VAL_ARR[0]));
        System.out.println(binTree.getInOrder());
    }

}
