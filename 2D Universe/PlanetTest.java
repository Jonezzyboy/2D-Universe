

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PlanetTest. Will test methods used in the Planet class.
 *
 * @author  Alan Jones
 * @version 2016.03.13
 */
public class PlanetTest
{
    private Universe universe1;
    private Star star1;

    /**
     * Default constructor for test class PlanetTest
     */
    public PlanetTest()
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
        star1 = new Star(300, 300, 40, universe1, 100000);
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
    public void orbitRadius()
    {
        Planet planet1 = new Planet(star1, 0.1, 30, 40, java.awt.Color.blue, universe1, 10000);
        planet1.setOrbitRadius(30);
        assertEquals(30, planet1.getOrbitRadius());
    }
}

