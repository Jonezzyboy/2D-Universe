

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StarTest. Will test methods used in the Planet class.
 *
 * @author  Alan Jones
 * @version 2016.03.13
 */
public class StarTest
{
    private Universe universe1;
    private Star star1;

    /**
     * Default constructor for test class StarTest
     */
    public StarTest()
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
        star1 = new Star(universe1);
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
    public void xPosition()
    {
        star1.setXPosition(100);
        assertEquals(100, star1.getXPosition());
    }

    @Test
    public void yPosition()
    {
        star1.setYPosition(100);
        assertEquals(100, star1.getYPosition());
    }

    @Test
    public void diameter()
    {
        star1.setDiameter(10);
        assertEquals(10, star1.getDiameter());
    }

    @Test
    public void increaseLifetime()
    {
        star1.increaseLife(100);
        assertEquals(10100, star1.getLifeSpan());
    }
}
