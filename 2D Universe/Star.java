import java.awt.*;
/**
 * This is the star class to simulate the properties of a star
 * 
 * @author Alan Jones 
 * @version 2016.02.19
 */
public class Star extends Space_Object
{
    /**
     * Constructor for objects of class star
     * 
     * @param xPos  The horizontal coordinate of this star
     * @param yPos  The vertical coordinate of this star
     * @param objectDiameter  The diameter (in pixels) of this star
     * @param theUniverse  The universe this star exists within
     * @param lifeSpan  The lifeTime of this star
     */
    public Star(int xPos, int yPos, int objectDiameter, Universe theUniverse, int lifeSpan)
    {
        super(xPos, yPos, 0, 0, objectDiameter, Color.YELLOW, theUniverse, lifeSpan);      
    }
    
    /**
     * Create a default Star with only the universe to be chosen
     * 
     * @param theUniverse  The universe this comet exists within
     */
    public Star(Universe theUniverse)
    {
        super(300, 300, 0, 0, 40, Color.YELLOW, theUniverse, 10000);
    }
}
