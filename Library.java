/* This is a stub for the Library class */
import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements{

  //Attributes
  private Hashtable<String, Boolean> collection;
  
  /**
   * Constructor
   * @param name the name of the library
   * @param address the location of the library
   * @param nFloors the number of floors in the library
   */
  public Library(String name, String address, int nFloors) {
    super(name,address,nFloors);
    System.out.println("You have built a library: 📖");
    this.collection = new Hashtable<>();
  }
  
  /**
   * add a book to the collection
   * @param title title of the book
   */
  public void addTitle(String title) {
    this.collection.put(title,true);
  }

  /**
   * remove a book from the collection
   * @param title title of the book
   * @return title of the book being removed
   */
  public String removeTitle(String title) {// return the title that we removed
    if (!collection.containsKey(title)) {
      throw new RuntimeException (title + "is not in the collection of" + this.name + "library.");
    } this.collection.remove(title,false);
    return title;
  }

  /**
   * check out a book if it is available
   * @param title title of the book needed to be checked out
   */
  public void checkOut(String title) {
    if (!this.collection.containsKey(title) || this.collection.get(title) == false) {
      throw new RuntimeException (title + "is not available in" + this.name + "library.");
    } removeTitle(title);
  }

  /**
   * return a book if it is not available
   * @param title title of the book needed to be returned
   */
  public void returnBook(String title) {
    if (!this.collection.containsKey(title) && this.collection.get(title) == true) {
      throw new RuntimeException (title + "is already returned into" + this.name + "library.");
    } addTitle(title);
  }

  /**
   * returns true if the title appears as a key in the Libary's collection, false otherwise
   * @param title title of the book
   * @return T/F
   */
  public boolean containsTitle(String title) {
    return this.collection.containsKey(title);
  }  
  
  /**
   * returns true if the title is currently available, false otherwise
   * @param title title of the book
   * @return T/F
   */
  public boolean isAvailable(String title) {
    return this.collection.get(title);
  }
  
  /**
   * prints out the entire collection in an easy-to-read way (including checkout status)
   */
  public void printCollection() {
    System.out.println(this.collection);
  }

  public static void main(String[] args) {
    new Library("Neilson", "7 Neilson Drive",5);
    }
  }
