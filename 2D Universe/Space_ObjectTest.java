
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Space_ObjectTest. Will test methods used in the Space_Object class.
 *
 * @author  Alan Jones
 * @version 2016.03.13
 */
public class Space_ObjectTest
{
    private Universe universe1;
    private Space_Object space_Ob1;

    /**
     * Default constructor for test class Space_ObjectTest
     */
    public Space_ObjectTest()
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
        space_Ob1 = new Space_Object(400, 400, 12, 7, 40, java.awt.Color.CYAN, universe1, 10000);
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
        space_Ob1.setXPosition(300);
        assertEquals(300, space_Ob1.getXPosition());
    }

    @Test
    public void yPosition()
    {
        space_Ob1.setYPosition(300);
        assertEquals(300, space_Ob1.getYPosition());
    }

    @Test
    public void color()
    {
        space_Ob1.setColor(java.awt.Color.GREEN);
        assertEquals(java.awt.Color.GREEN, space_Ob1.getColor());
    }
    
    @Test
    public void diameter()
    {
        space_Ob1.setDiameter(10);
        assertEquals(10, space_Ob1.getDiameter());
    }

    @Test
    public void increaseLifetime()
    {
        space_Ob1.increaseLife(100);
        assertEquals(10100, space_Ob1.getLifeSpan());
    }
}

