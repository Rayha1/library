
import ecs100.*;
/**
 * class to handle GUI functionality.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GUI
{
    // instance variables - replace the example below with your own
    private Books Books;

    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        Books = new Books();
        UI.initialise();
        //UI.addButton("ALL", Books::printALL);
        UI.addButton("Add", this::addBook);
        UI.addButton("Find", this::findBook);
        UI.addButton("Quit", UI::quit);
    }

    /**
     * adds a book
     */
    public void addBook() {
        final int MAX_QUANTITY = 999;
        
        //ask user for details
        String name = UI.askString("Title: ");
        String author = UI.askString("Author: ");
        int quatity = UI.askInt("Quantity: "); // requires validation
        
        String imgFileName = UIFileChooser.open("Choose Image File: ");
        Books.addBook(name, author, quatity, imgFileName);
    }
    
    /**
     * finds a book based on name
     * prints out author, quantity, book cover
     */
    public void findBook() {
        String bookName = UI.askString("Name of book: ");
        if (Books.findBook(bookName)) {
            UI.println("Found Book!");
        } else {
            UI.println("Book not found");
        }
    }
}
