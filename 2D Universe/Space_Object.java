import java.awt.*;
import java.util.Random;

/**
 * Class Space_Object - an object that exists in a finite Universe. The object bounces off
 * the bottom edge of the universe.
 * 
 * Movement can be initiated by repeated calls to the "move" method.
 * 
 * 
 * @author  Robert Topp & Alan Jones
 *
 * @version 2016.02.16
 */

public class Space_Object
{
    protected Color color;                  // color of the object
    protected int diameter;                 // diameter of the object
    protected int xPosition;                // x position of the object
    protected int yPosition;                // y position of the object
    protected int xVel;                     // x speed of the object
    protected int yVel;                     // y speed of the object
    protected final int groundPosition;     // y position of the bottom of the Universe
    protected final int rightPosition;     // x position of the right of the Universe
    protected Universe universe;           // universe object exists within
    protected int lifeTime;                // lifetime of the object

    /**
     * Constructor for objects of class Space_Object
     *
     * @param xPos  The horizontal coordinate of the object
     * @param yPos  The vertical coordinate of the object
     * @param objectDiameter  The diameter (in pixels) of the object
     * @param objectColor  The color of the object
     * @param theUniverse  The universe this object exists within
     */
    public Space_Object(int xPos, int yPos, int xSpeed, int ySpeed, int objectDiameter, Color objectColor, Universe theUniverse, int lifeTime)
    {
        xPosition = xPos;
        yPosition = yPos;
        xVel = xSpeed;
        yVel = ySpeed;
        color = objectColor;
        diameter = objectDiameter;
        universe = theUniverse;
        groundPosition = universe.getGround();
        rightPosition = universe.getEdge();
        this.lifeTime = lifeTime;
        universe.storeObject(this);
    }

    /**
     * Create a default Space_Object with only the universe to be chosen
     * 
     * @param theUniverse  The universe this object exists within
     */
    public Space_Object(Universe theUniverse)
    {
        xPosition = 100;
        yPosition = 100;
        xVel = 13;
        yVel = 6;
        color = Color.RED;
        diameter = 27;
        universe = theUniverse;
        groundPosition = universe.getGround();
        rightPosition = universe.getEdge();
        lifeTime = 100000;
        universe.storeObject(this);
    }

    /**
     * Move this object according to its position and speed and redraw.
     */
    public void move()
    {

        // Remove an object if lifetime reaches 0
        if(this.getLifeSpan() <= 0){
            // Remove from universe at current position
            universe.erase(this);

            // Then remove from ArrayList (permanent deletion)
            universe.removeObject(this);
        }
        else{
            // Decrease the objects lifeTime
            decreaseLife(1);

            // Draw ths objec t at its current position
            universe.draw(this);
        }
    }    

    /**
     * @return xPosition  The horizontal position of this object
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * @return yPosition  The vertical position of this object
     */
    public int getYPosition()
    {
        return yPosition;
    }

    /**
     * @return xSpeed  The horizontal speed of this object
     */
    public int getXSpeed()
    {
        return xVel;
    }

    /**
     * @return ySpeed  The vertical speed of this object
     */
    public int getYSpeed()
    {
        return yVel;
    }

    /**
     * @return color  The colour of this object
     */
    public Color getColor()
    {
        return color;
    }

    /**
     * @return diameter  The diameter of this object
     */
    public int getDiameter()
    {
        return diameter;
    }

    /**
     * @return universe  The universe the planet exists in
     */
    public Universe getUniverse()
    {
        return universe;
    }

    /**
     * @return lifeTime  The life span of this object
     */
    public int getLifeSpan()
    {
        return lifeTime; 
    }

    /**
     * @return xCenter  The x centre of this object
     */
    public int getXCenter()
    {
        int xCenter = xPosition + (diameter / 2);
        return xCenter;
    }

    /**
     * @return yCenter  The y centre of this object
     */
    public int getYCenter()
    {
        int yCenter = yPosition + (diameter / 2);
        return yCenter;
    }

    /**
     * @return area  The area of the object
     */
    public int area()
    {
        int radiusSqre = (diameter / 2) * (diameter / 2);
        int area = (int)(Math.PI * radiusSqre);
        return area;
    }

    /**
     * Sets the x position of this object
     * 
     * @param xPos  The horizontal coordinate of the object
     */
    public void setXPosition(int xPos)
    {
        xPosition = xPos;
    }

    /**
     * Sets the y position of this object
     * 
     * @param yPos  The vertical coordinate of the object
     */
    public void setYPosition(int yPos)
    {
        yPosition = yPos;
    }

    /**
     * Increases the x position of this object
     * 
     * @param xSpeed  The horizontal speed of the object
     */
    public void incrXPosition(int xSpeed)
    {
        xPosition += xSpeed;
    }

    /**
     * Increases the y position of this object
     * 
     * @param ySpeed  The vertical speed of the object
     */
    public void incrYPosition(int ySpeed)
    {
        yPosition += ySpeed;
    }

    /**
     * Sets the x speed of this object
     * 
     * @param xSpeed  The horizontal speed of the object
     */
    public void setXSpeed(int xSpeed)
    {
        xVel = xSpeed;
    }

    /**
     * Sets the y position of this object
     * 
     * @param ySpeed  The vertical speed of the object
     */
    public void setYSpeed(int ySpeed)
    {
        yVel = ySpeed;
    }

    /**
     * Sets the color of this object
     * 
     * @param color  The colour of this object
     */
    public void setColor(Color color)
    {
        this.color = color;
    }

    /**
     * Sets the diameter of this object
     * 
     * @param diameter  The diameter of this object
     */
    public void setDiameter(int diameter)
    {
        this.diameter = diameter;
    }

    /**
     * Decrease the objects lifeTime
     * 
     * @param decr  The value the lifeTime is decreased by
     */
    public void decreaseLife(int decr)
    {
        lifeTime -= decr;
    }

    /**
     * Increase objects lifeTime
     * 
     * @param incr  The value the lifeTime is increased by
     */
    public void increaseLife(int incr){
        lifeTime += incr;
    }

    /**
     * Increase objects mass
     * 
     * @param area1  The area of the object gaining mass
     * @param area2  The area of the object giving mass
     */
    public void increaseMass(int area1, int area2)
    {
        area1 += area2;
        double radiusSqre = area1 / Math.PI;
        diameter = ((int)Math.sqrt(radiusSqre)) * 2;
    }

    /**
     * Sets the orbit radius
     * 
     * @param radius  The radius the orbitRadius will change to
     */
    public void incrOrbitRadius(int radius)
    {
        incrOrbitRadius(radius);
    }

    /**
     * Generates a random number between a minimum and maximum value
     * 
     * @param max  The upper boundry of the random integer
     * @param min  The lower boundry of the random integer
     * @return randNum  A randomly generated number
     */
    public int randomInt(int min, int max)
    {
        Random rand = new Random();
        int randNum = rand.nextInt(max - min + 1) + min;
        return randNum;
    }
}
