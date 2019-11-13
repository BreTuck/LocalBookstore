public class Book {
  public Book(String initTitle, String initAuthor, String initPublisher, int initPages, int initStock) {
    this.title = initTitle;
    this.author = initAuthor;
    this.publisher = initPublisher;
    this.numPages = initPages;
    this.numStocked = initStock;              // Meant to rep the number of book currently avail.
  }

  public String getTitle() {
    return this.title;
  }
  public String getAuthor() {
    return this.author;
  }
  public String getPublisher() {
    return this.publisher;
  }
  public int getNumPages() {
    return this.numPages;
  }
  public int getNumInv() {
    return this.numStocked;
  }
  public void setTitle(String newTitle) {
    this.title = newTitle;
  }
  public void setAuthor(String newAuthor) {
    this.author = newAuthor;
  }
  public void setPublisher(String newPublisher) {
    this.publisher = newPublisher;
  }
  public void decreaseInv() {
    this.numStocked = this.numStocked - 1;
  }
  public void increaseInv() {
    this.numStocked = this.numStocked + 1;
  }
  public String toString() {
    return this.title + " by " + this.author + "\n" + this.publisher + "\nTotal Number of Pages: " + this.numPages + "\nCopies in Stock: " + this.numStocked + "\n\n";
  }
  private String title;
  private String author;
  private String publisher;
  private int numPages;
  private int numStocked;
}