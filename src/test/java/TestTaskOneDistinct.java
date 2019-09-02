import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import taskone.TaskOneDistinct;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TestTaskOneDistinct extends Assert {

    private String strForTest;
    private String strForTestEmpty;
    private String strForTestNull;

    private TaskOneDistinct taskOneDistinct;

    @Before
    public void prepareData() {
        strForTest = new String("/Lorem ipsum dolor sit amet, consectetur - adipiscing elit. " );
        strForTestEmpty = "";
        strForTestNull = null;
        taskOneDistinct = new TaskOneDistinct();
    }

    @Test
    public void testCleanString() {
        String acctual = taskOneDistinct.cleanStrings(strForTest).trim();
        String expected = "lorem ipsum dolor sit amet consectetur adipiscing elit";
        assertEquals("Clean string from symbols", expected, acctual);

    }

    @Test
    public void testCleanStringEmpty() {
        String acctual = taskOneDistinct.cleanStrings(strForTestEmpty).trim();
        String expected = "";
        assertEquals("Clean empty string from symbols", expected, acctual);
    }

    @Test(expected = NullPointerException.class)
    public void testCleanStringNull() {
        String acctual = taskOneDistinct.cleanStrings(strForTestNull).trim();
        String expected = "";
        assertEquals("Clean null string from symbols", expected, acctual);
    }

    @Test
    public void testgetDistinct() {
        strForTest = taskOneDistinct.cleanStrings(strForTest);
        Set<String> acctual = taskOneDistinct.getDistinct(strForTest);
        Set<String> expected = new HashSet<>(Arrays.asList(
                "lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipiscing", "elit"));

        assertEquals(expected, acctual);

    }

    @Test
    public void testgetDistinctForEmtyString() {
        strForTestEmpty = taskOneDistinct.cleanStrings(strForTestEmpty);
        Set<String> acctual = taskOneDistinct.getDistinct(strForTestEmpty);
        Set<String> expected = new HashSet<>(Arrays.asList(""));

        /*assertTrue( acctual.isEmpty());
        assertTrue( expected.isEmpty());*/
        assertEquals(expected, acctual);
    }

    @Test(expected = NullPointerException.class)
    public void testgetDistinctforNullString() {

        taskOneDistinct.getDistinct(strForTestNull);

    }

}

