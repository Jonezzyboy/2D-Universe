import java.util.Scanner;
/**
 * A menu interface to be called within a Demo class
 * .
 * 
 * @auther   Alan Jones
 * @version 2016/03/13
 */
public class Menu
{

    private int selection;
    private Scanner read;

    /**
     * Constructor for objects of class Simplemenu
     */
    public Menu()
    {
        selection = -1;
        read = new Scanner(System.in);
    }

    /**
     * Displays the standard text menu options
     * 
     */
    public void displayMenu()
    {
        
        System.out.println("     Universe Demo");
        System.out.println("");
        System.out.println(" (1)  Demo Dense Universe ");
        System.out.println(" (2)  Demo Star Collision ");
        System.out.println(" (3)  Demo Comet Collision ");
        System.out.println(" (4)  Demo LifeTime "); 
        System.out.println(" (5)  Demo Comets "); 
        System.out.println(" (6)  CLEAR SCREEN AND ARRAY "); 
        System.out.println(" (7)  END DEMO "); 
    }
    
    /**
     * A method that recieves a user input
     * 
     * @return selection The choice from the user
     */
    public int select()
    {
        System.out.println(" Please enter your choice: ");
        selection = read.nextInt();
        return selection;
    }
}
