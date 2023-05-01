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
    private Books books;
    private Book book;
    private int quantity = 0;
    private int currBook = 1;

    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        books = new Books();
        UI.initialise();
        UI.addButton("ALL", this::allBooks);
        UI.addButton("Add", this::addBook);
        UI.addButton("Find", this::findBook);
        UI.addButton("Quit", UI::quit);
        
        UI.setMouseListener(this::doMouse);
    }

    /**
     * adds a book
     */
    public void addBook() {
        final int MAX_QUANTITY = 999;
        final int MAX_PAGES = 21450; // one piece volumes put together
        int pages;
        int quantity = 0;
        //ask user for details
        String name = UI.askString("Title: ");
        String author = UI.askString("Author: ");
        while (quantity == 0) {
            pages = UI.askInt("Quantity: "); // requires validation 
            if (pages < MAX_PAGES || pages > 0) {
                quantity = pages;
            }
        }
        String imgFileName = UIFileChooser.open("Choose Image File: ");
        books.addBook(name, author, quantity, imgFileName);
    }
    
    /**
     * finds a book based on name
     * prints out author, quantity, book cover
     */
    public void findBook() {
        UI.clearGraphics();
        String bookName = UI.askString("Name of book: ");
        if (books.findBook(bookName)) {
            UI.println("Found Book!");
            book = books.getBook();
            UI.println("Author: " + book.getAuthor());
            UI.println("Quantity: " + book.getQuantity());
            book.displayBook(currBook); // Show books cover
        } else {
            UI.println("Book not found");
        }
    }
    
    public void allBooks() {
        UI.clearGraphics();
        int size = books.hashLen() + 1;
        String name;
        while (size > currBook) {
            name = books.findTitle(currBook);
            if (books.findBook(name)) {
            book = books.getBook();
            UI.println("Title: " + name);
            UI.println("Author: " + book.getAuthor());
            UI.println("Quantity: " + book.getQuantity());
            book.displayBook(currBook); // Show books cover
            currBook++;
        }
    }
    currBook = 1; //resets current book back to 1
    } 

    /**
      * select object based on where the usr clicks
      */
    private void doMouse(String action, double x, double y) {
        if (action.equals("clicked")) {
            // loops throught hashmap from getter
            for (int bookId : books.returnList().keySet()) {
            Book book = books.returnList().get(bookId); // sets current book
            String title = books.findTitle(bookId);
            double left = book.getLeft();
            double right = book.getRight();
            double top = book.getTop();
            double bottom = book.getBottom();
            if ((x >= left) && (x <= right) && (y >= top) && (y <= bottom)) {
                UI.println(title + " Borrowed");
            }
            }
        }
    }
}
