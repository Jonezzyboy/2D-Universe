
/**
 * Class to demonstrate the universe.
 * 
 * @author Alan Jones 
 * @version 2016/13/03
 */
public class Demo
{
    private Menu menu;
    private Universe uni;

    /**
     * Constructor for objects of class demo
     */
    public Demo()
    {
        // initialise instance variables
        menu = new Menu();
        uni = new Universe();
    }

    /**
     * A method which will display the functioning menu
     */
    public void display()
    {
        int choice;
        menu.displayMenu();
        choice = menu.select();
        while(choice != 7)
        {
            switch(choice){
                case 1:
                uni.demoDenseUniverse();
                break;

                case 2:
                uni.demoStarCollision();
                break;

                case 3:
                uni.demoCometCollision();
                break;

                case 4:
                uni.demoLifeTime();
                break;

                case 5:
                uni.demoAllComets();
                break;

                case 6:
                uni.clearScreen();
                break;

            }
            choice = menu.select();
        }
        System.out.println("END OF DEMO");
    }
}
