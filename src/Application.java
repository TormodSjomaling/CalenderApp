import java.time.LocalDate;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Makes up the user interface (text based) of the application.
 * Responsible for all user interaction, like displaying the menu
 * and receiving input from the user.
 */
public class Application {

    /**
     * Constructor for objects of class ApplicationUI
     */
    public Application() {
    }

    private String[] menuItems = {
            "1. Add new calender entry",
            "2. Delete calender entry",
            "3. List all calender entries for a specific time period",
            "4. List all calender entries",
    };

    /**
     * Initializes the application.
     */
    private void init() {
        System.out.println("init() was called");
    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user.
     */
    public void start()
    {
        this.init();

        boolean quit = false;

        while (!quit)
        {
            try
            {
                int menuSelection = this.showMenu();
                switch (menuSelection)
                {
                    case 1:
                        addCalenderEntry();
                        break;

                    case 2:
                        deleteCalenderEntry();
                        break;

                    case 3:
                        break;

                    case 4:
                        //listAllCalenderEntries();
                        break;

                    case 5:
                        System.out.println("\nThank you for using my application!\n");
                        quit = true;
                        break;

                    default:
                        System.out.println("Oops, something went wrong, please try again.");
                }
            }
            catch (InputMismatchException ime)
            {
                System.out.println("\nERROR: Please enter a number between 1 and " + this.menuItems.length + "..\n");
            }

        }
    }

    /**
     * Displays the menu to the user, and waits for the users input. The user is
     * expected to input an integer between 1 and the max number of menu items.
     * If the user inputs anything else, an InputMismatchException is thrown.
     * The method returns the valid input from the user.
     *
     * @return the menu number (between 1 and max menu item number) provided by the user.
     * @throws InputMismatchException if user enters an invalid number/menu choice
     */
    private int showMenu() throws InputMismatchException {
        System.out.println("\n**** Application ****\n");
        // Display the menu
        for ( String menuItem : menuItems )
        {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = menuItems.length + 1;
        // Add the "Exit"-choice to the menu
        System.out.println(maxMenuItemNumber + ". Quit\n");
        System.out.println("Please make a choice between (1-" + maxMenuItemNumber + "): ");
        // Read input from user
        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber))
        {
            throw new InputMismatchException();
        }

        return menuSelection;
    }

    /**
     * //TODO update these comments
     * Adds new object of type Calender  to
     * the Application Register
     */
    private void addCalenderEntry() {
        Scanner reader = new Scanner(System.in);

        System.out.println("\nPlease enter the following information: ");
        while (true) {
            try {
                System.out.println("Date: (YYYY-MM-DD) ");
                String dateInput = reader.nextLine().trim();

                if (dateInput.equals("")) {
                    System.out.println("Please enter date on requested format.");
                }
                else {
                    System.out.println("What is happening at this date?: ");
                    String eventInput = reader.nextLine().trim().toLowerCase();
                    LocalDate date = LocalDate.parse(dateInput);
                    //Pass parameters in calender object
                    break;
                }
            } catch (Exception e) {
                System.out.println("Something went wrong, make sure you enter information on requested format.");
                System.out.println(e);
            }
        }
    }

    private void deleteCalenderEntry() {
        Scanner reader = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\nEnter date of calender entry to be removed: ");
                System.out.println("Date: (YYYY-MM-DD) ");
                String dateInput = reader.nextLine().trim();

                if (dateInput.equals("")) {
                    System.out.println("Please enter date on requested format.");
                }
                else {
                    LocalDate date = LocalDate.parse(dateInput);
                    //Pass parameters in calender object
                    break;
                }
            } catch (Exception e) {
                System.out.println("Something went wrong, make sure you enter information on requested format.");
                System.out.println(e);
            }
        }
    }

    /**
    private void listAllCalenderEntries() {
        //Iterator<Calendar> foundEntries = applicationRegister.getAllEntires();
        if (foundEntries.hasNext()) {
            while (foundEntries.hasNext()) {

            }
        }
    }**/
}