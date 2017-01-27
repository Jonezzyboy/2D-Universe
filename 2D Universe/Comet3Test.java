

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Comet3Test. Will test methods used in the Comet3 class.
 *
 * @author  Alan Jones
 * @version 2016.03.13
 */
public class Comet3Test
{
    private Universe universe1;
    private Comet3 comet31;

    /**
     * Default constructor for test class Comet3Test
     */
    public Comet3Test()
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
    public void xPosition()
    {
        comet31.setXPosition(760);
        assertEquals(760, comet31.getXPosition());
    }
    
    @Test
    public void yPosition()
    {
        comet31.setYPosition(760);
        assertEquals(760, comet31.getYPosition());
    }
    
    @Test
    public void color()
    {
        comet31.setColor(java.awt.Color.BLUE);
        assertEquals(java.awt.Color.BLUE, comet31.getColor());
    }
    
    @Test
    public void diameter()
    {
        comet31.setDiameter(10);
        assertEquals(10, comet31.getDiameter());
    }
    
    @Test
    public void increaseLifetime()
    {
        comet31.increaseLife(100);
        assertEquals(10100, comet31.getLifeSpan());
    }
    
}

