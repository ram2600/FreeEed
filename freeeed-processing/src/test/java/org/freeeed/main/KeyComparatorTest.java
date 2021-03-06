package org.freeeed.main;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mark
 */
public class KeyComparatorTest {    

    /**
     * Test of compare method, of class KeyComparator.
     */
    @Test
    public void testCompare() {
        KeyComparator instance = new KeyComparator();
        WritableComparable t1 = new Text("abc\t#");
        WritableComparable t2 = new Text("abc\t#");
        assertEquals(instance.compare(t1, t2), 0);
        t1 = new Text("abc\t#");
        t2 = new Text("abc\ta");
        assertTrue(instance.compare(t1, t2) < 0);        
    }
}