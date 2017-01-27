

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Comet7Test. Will test methods used in the Comet7 class.
 *
 * @author  Alan Jones
 * @version 2016.03.13
 */
public class Comet7Test
{
    private Universe universe1;
    private Comet7 comet71;
    
    /**
     * Default constructor for test class Comet7Test
     */
    public Comet7Test()
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
        comet71.setXPosition(760);
        assertEquals(760, comet71.getXPosition());
    }
    
    @Test
    public void yPosition()
    {
        comet71.setYPosition(760);
        assertEquals(760, comet71.getYPosition());
    }
    
    @Test
    public void color()
    {
        comet71.setColor(java.awt.Color.BLUE);
        assertEquals(java.awt.Color.BLUE, comet71.getColor());
    }
    
    @Test
    public void diameter()
    {
        comet71.setDiameter(10);
        assertEquals(10, comet71.getDiameter());
    }
    
    @Test
    public void increaseLifetime()
    {
        comet71.increaseLife(100);
        assertEquals(10100, comet71.getLifeSpan());
    }
}
