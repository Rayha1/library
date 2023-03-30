import java.util.HashMap; // import hashmap
import ecs100.*;
/**
 * support class of book an id, name, author, qty, image
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Book
{
    // instance variables - replace the example below with your own
    // title, author, date(published), month (published), year(published),pages, genre, cover
    //private HashMap<String, String, Integer, Integer, Integer, Integer, String>;
    
    private String name;
    private String author;
    private int quantity;
    private String image;
    private static final String DEFAULT_IMAGE = "bookCover.jpg";

    /**
     * Constructor for objects of class StudentShows
     */
    public Book(String nm, String auth, int qty, String img)
    {
        // initialise instance variables
        this.name = nm;
        this.author = auth;
        this.quantity = qty;
        //if usr selects cancell instaed of giving an image
        if (img == null) {
            this.image = DEFAULT_IMAGE;
        } else {
            this.image = img;
        }
    }
    
    /**
     * Constructor for objects of class StudentShows
     */
    public Book(String nm, String auth, int qty)
    {
        // initialise instance variables
        this(nm, auth, qty, null);
    }
    
    /**
     * getter for name
     * @return name if found
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * display image on GUI
     */
    public void displayBook() {
        int locX = 100;
        int locY = 100;
        final double WIDTH = 100;
        final double HEIGHT = 100;
        
        UI.drawImage(this.image, locX, locY, WIDTH, HEIGHT);
    }
    
    public String getAuthor() {
        return this.author;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
}
