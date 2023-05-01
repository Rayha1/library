import java.util.HashMap; // import hashmap
import java.awt.Color;
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
    // varibales for the GUI parameters in books
    int locX;
    int locY;
    final double WIDTH = 50;
    final double HEIGHT = 70;
    
    private double left;   // left
    private double top;    // top
    private double bottom; // bottom

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
    public void displayBook(int space) {
        //sadly its gonna be hard cooded in for now
        if (space > 8) {
            locX = 100 * (space - 8);
        } else if (space > 4) {
            locX = 100 * (space - 4);
        } else {
            locX = 100 * space;
        }
        if (space > 8) {
            locY = 300 + (space - 8);
        }else if (space > 4) {
            locY = 200 + (space - 4);
        }else {
            locY = 100;
        }
        
        UI.drawImage(this.image, locX, locY, WIDTH, HEIGHT);
        
        //set the top, left,bottom
        setTop();
        setLeft();
        setBottom();
    }
    
    /**
     * set left
     */
    public void setLeft() {
        this.left = this.locX;
    }
    
    /**
     * set top
     */
    public void setTop() {
        this.top = this.locY - this.HEIGHT;
    }
    
    /**
     * set bottom
     */
    public void setBottom() {
        this.bottom = locY + HEIGHT;
    }
    
    /**
     * getter left
     */
    public double getLeft() {
        return this.left;
    }
    
    /**
     * getter right
     */
    public double getRight() {
        return this.left + this.WIDTH;
    }
    
    /**
     * getter top
     */
    public double getTop() {
        return this.top;
    }
    
    /**
     * getter bottom
     */
    public double getBottom() {
        return this.bottom;
    }
    
    /**
     * getter author
     */
    public String getAuthor() {
        return this.author;
    }
    
    /**
     * getter quantity
     */
    public int getQuantity() {
        return this.quantity;
    }
    
    /**
     * book wiper
     */
    public void borrowed() {
        UI.setColor(Color.white);
        UI.fillRect(left, (bottom - HEIGHT), WIDTH, HEIGHT);
    }
}
