import java.awt.*;

/**
 * Class to simulate a comet 3, calls upon the Space_Object class. This object will change direction once colliding with the edge of the universe, it also has a random chance to change lifeTime.
 * 
 * @author Alan Jones
 * @version 2016.03.08
 */
public class Comet3 extends Space_Object
{
    private int xSpeed;   // current horizontal speed   (+  moving left to right, - right to left
    private int ySpeed;  // current vertical speed ( + moving down, - moving up)
    private boolean alreadyErased = false;  // Checks if the comet should be erased once removed from arrayList

    /**
     * Constructor for objects of class Comet 3
     * 
     * @param xPos  The horizontal coordinate of this comet
     * @param yPos  The vertical coordinate of this comet
     * @param xVel  The x speed of this comet
     * @param yVel  The y speed of this comet
     * @param objectDiameter  The diameter (in pixels) of this comet
     * @param objectColor  The color of this comet
     * @param theUniverse  The universe this comet exists within
     * @param lifeSpan  The lifeTime of this comet
     */
    public Comet3(int xPos, int yPos, int xVel, int yVel, int objectDiameter, Color objectColor, Universe theUniverse, int lifeSpan)
    {
        super(xPos, yPos, xVel, yVel, objectDiameter, objectColor, theUniverse, lifeSpan);
        xSpeed = xVel;
        ySpeed = yVel;
    }

    /**
     * Create a default Comet3 with only the universe to be chosen
     * 
     * @param theUniverse  The universe this comet exists within
     */
    public Comet3(Universe theUniverse)
    {
        super(300, 450, 7, 12, 10, Color.RED, theUniverse, 10000);
        xSpeed = xVel;
        ySpeed = yVel;
    }

    /**
     * Move this object according to its position and speed and redraw.
     **/
    public void move()
    {
        if (universe.isPresent(this) == true){
            // Delete a Space_Object when its life has come to an end
            if(lifeTime <= 0){
                // Remove from universe at the current position
                universe.erase(this);

                // Then remove from ArrayList (permanent deletion)
                universe.removeObject(this);
            }
            else{
                // Remove from universe at the current position
                universe.erase(this);
                ySpeed = this.getYSpeed();
                xSpeed = this.getXSpeed();

                // Check for collisions
                universe.colisionDetect(this);

                // Compute new position
                yPosition += ySpeed;
                xPosition += xSpeed;

                // Random chance to decrease lifeTime
                if(randomInt(0, 10) == 1){
                    decreaseLife(5);
                }

                // Check if it has hit the ground or top
                if(yPosition >= (groundPosition - diameter) && ySpeed > 0 || yPosition <= 0 && ySpeed < 0) {
                    // Makes the comets bounce in a different than normal angle
                    this.setYSpeed(-ySpeed);
                    this.setXSpeed(-xSpeed);
                }

                // Checks if it has hit the left or right side
                if(xPosition >= (rightPosition - diameter) && xSpeed > 0 || xPosition <= 0 && xSpeed < 0) {
                    // Makes the comets bounce in a different than normal angle
                    this.setXSpeed(-xSpeed);
                    this.setYSpeed(-ySpeed);
                }

                // Decrease the objects lifeTime
                decreaseLife(1);

                // Draw again at new position
                universe.draw(this);
            }    
        }
        else{
            if(!alreadyErased){
                universe.erase(this);
                alreadyErased = true;
            }
            else{
                // No need to erase object twice
            }
        }
    }
}

