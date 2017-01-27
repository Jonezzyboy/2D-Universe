

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class UniverseTest. Will test methods used in the Universe class.
 *
 * @author  Alan Jones
 * @version 2016.03.13
 */
public class UniverseTest
{
    private Universe universe1;
    private Comet7 comet71;
    private Comet3 comet31;

    /**
     * Default constructor for test class UniverseTest
     */
    public UniverseTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        universe1 = new Universe("The Universe", 800, 800);
        comet71 = new Comet7(universe1);
        comet31 = new Comet3(universe1);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void arraySize()
    {
        assertEquals(2, universe1.numberOfObjects());
    }

    @Test
    public void removeObject()
    {
        universe1.removeObject(comet31);
        assertEquals(1, universe1.numberOfObjects());
    }

    @Test
    public void addObject()
    {
        universe1.removeObject(comet31);
        universe1.storeObject(comet31);
        assertEquals(2, universe1.numberOfObjects());
    }

    @Test
    public void draw()
    {
        universe1.draw(comet31);
    }
}




