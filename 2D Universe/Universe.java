import java.awt.Color;
import java.util.ArrayList;

/**
 * Class Universe - a universe which can contain multiple objects  
 *
 * @author  Robert Topp & Alan Jones
 * @version 2016.02.16
 */

public class Universe  
{
    private Canvas universe;      // Canvas used to draw the graphics window and graphics
    private int leftEdge = 0;     // coordinates of the edges of the universe
    private int topEdge = 0;
    private int rightEdge;
    private int bottomEdge;
    private ArrayList<Space_Object> spaceArray;     // ArrayList to store all objects within universe

    /**
     * Create a universe with default name and size. Creates a fresh canvas to display the universe
     */
    public Universe()
    {
        universe = new Canvas("Universe Demo", 800, 800);
        rightEdge = 800;
        bottomEdge = 800;
        spaceArray = new ArrayList<Space_Object>();
    }

    /**
     *  Create a universe with given name and size
     *  
     *  @param name  The name to give the universe
     *  @param rightEdge  The maximum x coordinate
     *  @param bottomEdge  The maximum y coordinate
     */
    public Universe(String name, int rightEdge, int bottomEdge)
    {
        universe = new Canvas(name, rightEdge, bottomEdge);
        this.rightEdge = rightEdge;
        this.bottomEdge = bottomEdge;
        spaceArray = new ArrayList<Space_Object>();
    }

    /**
     * @return  sapceArray.size() The number of objects in the Space_Object ArrayList
     */
    public int numberOfObjects()
    {
        return spaceArray.size();
    }

    /**
     * @return  bottomEdge The y cordinate of the bottom of the universe
     */
    public int getGround()
    {
        return bottomEdge;
    }

    /**
     * @return  rightEdge The x cordinate of the right of the universe
     */
    public int getEdge()
    {
        return rightEdge;
    }

    /**
     * Store a Space_Object into the object ArrayList
     * 
     * @param obj  The Space_Object to be stored
     */
    public void storeObject(Space_Object obj)
    {
        spaceArray.add(obj);
    }

    /**
     * Remove a Space_Object into the object ArrayList
     * 
     * @param obj  The Space_Object to be removed
     */
    public void removeObject(Space_Object obj)
    {
        spaceArray.remove(obj);
    }

    /**
     * Removes all objects from ArrayList and clears the screen
     */
    public void clearScreen()
    {
        universe.erase();
        spaceArray.clear();
    }

    /**
     * Erase an object from the view of the universe
     * 
     * @param spaceObj  The object to be erased
     */
    public void erase(Space_Object spaceObj)
    {
        universe.eraseCircle(spaceObj.getXPosition(), spaceObj.getYPosition(), spaceObj.getDiameter());
    }

    /**
     * Draw an object at its current position onto the view of the universe
     * 
     * @param spaceObj  The object to be drawn
     */
    public void draw(Space_Object spaceObj)
    {
        universe.setForegroundColor(spaceObj.getColor());
        universe.fillCircle(spaceObj.getXPosition(), spaceObj.getYPosition(), spaceObj.getDiameter());
    }

    /**
     * Checks if an object is present in spaceArray
     * 
     * @param obj  The object being compared agains't the ArrayList
     */
    public boolean isPresent(Space_Object obj)
    {
        if(spaceArray.contains(obj)){
            return true;
        }
        else{
            return false;
        }
    }

    /** 
     * Check if an object has collided
     * 
     * @param obj  The object being compared
     * @param secondObject  The second object being compared
     * @return boolean  A true or false value of collision
     */
    public boolean colision(Space_Object obj, Space_Object secondObj)
    {
        int x1 = obj.getXPosition();
        int x2 = secondObj.getXPosition();
        int y1 = obj.getYPosition();
        int y2 = secondObj.getYPosition();
        int xDifference = x2 - x1;
        int yDifference = y2 - y1;
        int radius1 = obj.getDiameter() / 2;
        int radius2 = secondObj.getDiameter() / 2;
        int radiusCheck = (radius1 + radius2) * (radius1 + radius2);
        double distance = (xDifference * xDifference) + (yDifference * yDifference);
        if(distance < radiusCheck){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Checks if an object collides then responds with an action
     * 
     * @param obj  The object to check all colisions with
     */
    public void colisionDetect(Space_Object obj)
    {
        for(Space_Object secondObj: spaceArray){
            boolean collided = colision(obj, secondObj);

            if(collided){

                if(obj.equals (secondObj)){
                    break;
                }

                // Check if Comets collide of the same type
                else if(obj.getClass().equals (secondObj.getClass())){
                    // Erase objects in order to be cleared and redrawn
                    erase(obj);
                    erase(secondObj);

                    // Bounce Comets off of each other
                    int xSpeed = obj.getXSpeed();
                    int ySpeed = obj.getYSpeed();
                    int xSpeed2 = secondObj.getXSpeed();
                    int ySpeed2 = secondObj.getYSpeed();
                    obj.setXSpeed(-xSpeed);
                    obj.setYSpeed(-ySpeed);
                    secondObj.setXSpeed(-xSpeed2);
                    secondObj.setYSpeed(-ySpeed2);
                    obj.incrXPosition(-xSpeed - obj.getDiameter());
                    obj.incrYPosition(-ySpeed - obj.getDiameter());
                    secondObj.incrXPosition(-xSpeed2 + secondObj.getDiameter());
                    secondObj.incrYPosition(-ySpeed2 + secondObj.getDiameter());

                    collided = false;
                }

                // Check if Comet collised with a star
                else if(secondObj.getClass().equals(Star.class)){
                    // Remove Comet from universe at the current position
                    erase(obj);

                    // Remove Star so it can be redrawn bigger
                    erase(secondObj);

                    // Calculate area of Comet
                    int cometArea = obj.area();

                    // Increase Star lifeTime
                    secondObj.increaseLife(cometArea);

                    //Redraw Star
                    draw(secondObj);

                    // Then remove Comet from ArrayList (permanent deletion)
                    removeObject(obj);

                    // FOR DEMONSTRATION Shows the new lifetime of the star
                    System.out.println("The lifetime of " + secondObj + "is: " + secondObj.getLifeSpan());
                    break;
                }

                // Check if Comet collides with a planet
                else if(secondObj.getClass().equals(Planet.class)){
                    // Remove Comet from universe at the current position
                    erase(obj);

                    //Remove Planet so it can be redrawn bigger
                    erase(secondObj);

                    // Calculate area of Comet and Planet
                    int cometArea = obj.area();
                    int planetArea = secondObj.area();

                    // Increase Planet mass
                    secondObj.increaseMass(planetArea, cometArea);

                    // Change the Planets orbit radius
                    int diameter = secondObj.getDiameter();
                    int radius = diameter / 2;
                    secondObj.incrOrbitRadius(radius);

                    // Then remove Comet from ArrayList (permanent deletion)
                    removeObject(obj);
                    break;
                }

                // Comets have collided of different types
                else{
                    // Calculate area of Comets
                    int comet1Area = obj.area();
                    int comet2Area = secondObj.area();

                    // Calculate speed of Comets
                    int comet1Speed = Math.abs(obj.getXSpeed()) + Math.abs(obj.getYSpeed());
                    int comet2Speed = Math.abs(secondObj.getXSpeed()) + Math.abs(secondObj.getYSpeed());

                    // Comet 2 is larger so destory comet 1
                    if(comet1Area < comet2Area){
                        erase(obj);
                        removeObject(obj);
                    }
                    // Comet 1 is larger so destory comet 2
                    else if(comet1Area > comet2Area){
                        erase(secondObj);
                        removeObject(secondObj);
                    }
                    // Comet 2 is faster so destory comet 1
                    else if(comet1Speed < comet2Speed){
                        erase(obj);
                        removeObject(obj);
                    }
                    // Comet 1 is faster so destory comet 2
                    else if(comet1Speed > comet2Speed){
                        erase(secondObj);
                        removeObject(secondObj);
                    }
                    //Both comets are the same speed and size
                    else{
                        // Remove both Comets from universe at the current position
                        erase(obj);
                        erase(secondObj);
                        removeObject(obj);
                        removeObject(secondObj);
                    }
                    break;
                }
            }
        }
    }

    /**
     * Add 4 comets and make them move. Used to demo the attributes of different comets
     */
    public void demoAllComets()
    {
        Comet7 comet1 = new Comet7(300, 100, 5, 5, 25, Color.BLUE, this, 10000);
        Comet7 comet2 = new Comet7(100, 700, 5, 12, 15, Color.PINK, this, 10000);
        Comet3 comet3 = new Comet3(200, 200, 12, 10, 20, Color.RED, this, 10000);
        Comet3 comet4 = new Comet3(100, 400, 15, 9, 24, Color.GREEN, this, 10000);

        boolean finished =  false;
        for(int i = 0; i < 200; i++) {
            universe.wait(50);           // small delay
            comet1.move();
            comet2.move();
            comet3.move();
            comet4.move();
        }
    }

    /**
     * Add 2 comets and make them move. Used to demo comet collisions of the same type
     */
    public void demoCometCollision()
    {
        Comet3 comet1 = new Comet3(200, 200, 12, 10, 20, Color.RED, this, 10000);
        Comet3 comet2 = new Comet3(440, 400, -12, -10, 24, Color.GREEN, this, 10000);

        for(int i = 0; i < 200; i++) {
            universe.wait(50);           // small delay
            comet1.move();
            comet2.move();
        }
    }

    /**
     * Add a one star and one comet and make them move. Used to demo the collision between a star and comet
     */
    public void demoStarCollision()
    {
        Star sun = new Star(150, 250, 50, this, 10000);
        Comet3 comet1 = new Comet3(100, 120, 5, 8, 20, Color.RED, this, 10000);
        System.out.println("The lifetime of " + sun + "is: " + sun.getLifeSpan());

        boolean finished =  false;
        while(!finished) {
            universe.wait(50);           // small delay
            if(!spaceArray.contains(comet1)){
                finished = true;
            }
            comet1.move();
            sun.move();
        }
        System.out.println(comet1 + " collided with" + sun);
    }

    /**
     * Add a one star and draw it. Used to demo it's lifetime
     */
    public void demoLifeTime()
    {
        Star sun = new Star(150, 250, 50, this, 100);
        System.out.println("The lifetime of " + sun + "is: " + sun.getLifeSpan());

        boolean finished =  false;
        while(!finished) {
            universe.wait(50);           // small delay
            if(sun.getLifeSpan() <= 0){
                finished = true;
            }
            sun.move();
        }
        System.out.println("The lifetime of " + sun + "is: " + sun.getLifeSpan());
    }

    /**
     * Add 3 stars, 4 planets, and 4 comets and make them move. Used to demo a dense universe
     */
    public void demoDenseUniverse()
    {
        Star sun1 = new Star(150, 250, 50, this, 10000);
        Star sun2 = new Star(600, 500, 70, this, 9000);
        Star sun3 = new Star(50, 700, 30, this, 100);
        Planet planet1 = new Planet(sun1, 10, 10, 60, Color.RED, this, 10000);
        Planet planet2 = new Planet(sun1, 1, 24, 100, Color.BLUE, this, 10000);
        Planet planet3 = new Planet(sun2, 10, 20, 60, Color.CYAN, this, 24890);
        Planet planet4 = new Planet(sun2, 4, 24, 100, Color.PINK, this, 8000);
        Comet3 comet1 = new Comet3(200, 200, 12, 10, 20, Color.RED, this, 10000);
        Comet3 comet2 = new Comet3(100, 400, 15, 9, 24, Color.GREEN, this, 10000);
        Comet7 comet3 = new Comet7(500, 200, 4, 9, 20, Color.CYAN, this, 10000);
        Comet7 comet4 = new Comet7(650, 450, 5, 6, 16, Color.PINK, this, 90030);

        boolean finished =  false;
        for(int i = 0; i < 200; i++) {
            universe.wait(50);           // small delay
            sun1.move();
            sun2.move();
            sun3.move();
            planet1.move();
            planet2.move();
            planet3.move();
            planet4.move();
            comet1.move();
            comet2.move();
            comet3.move();
            comet4.move();
        }
    }
}
