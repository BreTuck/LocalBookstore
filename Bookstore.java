import java.util.ArrayList;

public class Bookstore {
  public Bookstore(ArrayList<Book> inv, ArrayList<Customer> clients) {
    this.inventory = inv;
    this.clientele = clients;
  }
  public ArrayList<Book> getInventory() {
    return this.inventory;
  }
  public ArrayList<Customer> getCustomers() {
    return this.clientele;
  }
  public boolean addBook(Book newBook) {
    return this.inventory.add(newBook);
  }
  public boolean addCustomer(Customer newCustomer) {
    return this.clientele.add(newCustomer);
  }
  public Customer searchCustomer(String fname, String lname) {
    for(Customer customerElem : this.clientele) {
      if(customerElem.getFirstName() == fname && customerElem.getLastName() == lname) {
        return customerElem;
      }
    }
    return null;
  }
  public boolean verifyCustomer(String actualEmail, String potentialEmail) {
    if(actualEmail == potentialEmail) {
      return true;
    } 
    return false;
  }
  public Book searchBook(String bookTitle) {
    for(Book bookObj : this.inventory) {
      if (bookObj.getTitle() == bookTitle) {
        return bookObj;
      } 
    }
    return null;
  }
  public boolean verifyBook(String actualAuthor, String potentialAuthor) {
    if (actualAuthor == potentialAuthor) {
      return true;
    }
    return false;
  }
  public boolean rentBook(Customer potentRenter, String potentTitle, String potentAuthor) {
    Book tempBook = searchBook(potentTitle);
    if(tempBook != null && verifyBook(tempBook.getAuthor(), potentAuthor)) {
      Customer tempCustomer = searchCustomer(potentRenter.getFirstName(), potentRenter.getLastName());
      if(tempCustomer != null) {
        if(tempBook.getNumInv() > 0) {
          tempBook.decreaseInv();
          tempCustomer.addRental(tempBook);
          return true;
        }
      }
    }
    return false;
  }
  public void displayInventory() {
   for(Book book : this.inventory) {
     System.out.print(book);
   }
  }
  public void displayClientele() {
    for(Customer customer : this.clientele) {
      System.out.print(customer);
    }
   }
  private ArrayList<Book> inventory;
  private ArrayList<Customer> clientele;
}