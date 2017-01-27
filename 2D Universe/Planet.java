import java.awt.*;
/**
 * This is the planet class to simulate the properties of a planet, and which star they orbit around
 * 
 * @author Alan Jones
 * @version 2016.02.19
 */
public class Planet extends Space_Object
{
    private Star star;          // star the planet will orbit around
    private double angle;       // angle of orbit
    private double velocity;    // velocity of orbit
    private int orbitRadius;    // raidus of orbit
    
    /**
     * Constructor for objects of class planet
     * 
     * @param star  The star this planet orbits
     * @param objectDiameter  The diameter (in pixels) of this planet
     * @param orbitRadius  The radius (in pixels) of the circular orbit
     * @param objectColor  The color of this planet
     * @param theUniverse  The universe this planet exists within
     * @param lifeSpan  The lifeTime of this planet
     */
    public Planet(Star star, double velocity, int objectDiameter, int orbitRadius, Color objectColor, Universe theUniverse, int lifeSpan)
    {
        super(star.getXPosition(), (star.getYPosition() - orbitRadius), (int)velocity, (int)velocity, objectDiameter, objectColor, theUniverse, lifeSpan);
        this.star = star;
        this.velocity = velocity / 100;
        this.orbitRadius = orbitRadius;
    }

    /**
     * Create a default Planet with only the universe and star to be chosen
     * 
     * @param star  The star this planet orbits
     * @param theUniverse  The universe this comet exists within
     */
    public Planet(Star star, Universe theUniverse)
    {
        super(star.getXPosition(), (star.getYPosition() - 40), 10, 10, 20, Color.BLUE, theUniverse, 10000);
        this.star = star;
        velocity = 0.1;
        orbitRadius = 40;
    }

    /**
     * Returns which star the planet is orbiting around
     * 
     * @return star  The star the planet orbits around
     */
    public Space_Object getOrbit()
    {
        return star;
    } 

    /**
     * Returns the orbit radius
     * 
     * @return orbitRadius  The radius of the plaents orbit
     */
    public int getOrbitRadius()
    {
        return orbitRadius;
    }

    /**
     * Sets the orbit radius
     * 
     * @param radius  The radius the orbitRadius will change to
     */
    public void setOrbitRadius(int radius)
    {
        orbitRadius = radius;
    }

    /**
     * Increases the orbit radius
     * 
     * @param radius  The radius the orbitRadius will increase by
     */
    public void incrOrbitRadius(int radius)
    {
        orbitRadius += radius;
    }

    /**
     * Move this object according to its position and speed and redraw.
     **/
    public void move()
    {
        // Remove from universe at the current position
        universe.erase(this);

        angle += velocity;
        int posX = star.getXCenter() + (int)((orbitRadius) * Math.cos(angle));
        int posY = star.getYCenter() + (int)((orbitRadius) * Math.sin(angle));
        this.setXPosition(posX);
        this.setYPosition(posY);

        // draw again at new position
        universe.draw(this);
    }   
}
