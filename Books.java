import java.util.HashMap;

/**
 * Write a description of class Books here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Books
{
    // instance variables - replace the example below with your own
    private HashMap<Integer, Book> booksMap; //declare books map
    private int currBookId; // store current id of book

    /**
     * Constructor for objects of class Books
     */
    public Books()
    {
        // initialise instance variables
        booksMap = new HashMap<Integer, Book>(); //intialise map
        //create some books
        Book b1 = new Book("Cellphone", "Stephen King", 86);
        Book b2 = new Book("Pet Semetary", "Stephen King", 68);
        Book b3 = new Book("1984", "George Orwell", 63);
        Book b4 = new Book("The Hound of Baskervilles", "Arthur Conan Doyle", 97);
        
        // add books
        booksMap.put(1, b1);
        booksMap.put(2, b2);
        booksMap.put(3, b3);
        booksMap.put(4, b4);
        
        this.currBookId = 4;
    }
    
    /**
     * add books to hashmap
     */
    public void addBook(String nm, String auth, int qty, String img) {
        currBookId++; // increment book id
        booksMap.put(currBookId, new Book(nm, auth, qty));
    }
    
    /**
     * looks for book in hashmap
     * @return boleean if found
     */
    public boolean findBook(String name)  {
        for (int bookId : booksMap.keySet()) {
            if (booksMap.get(bookId).getName().equals(name)) {
                return true;
            }
        }
        return false; // if not found
    }
}
