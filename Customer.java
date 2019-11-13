import java.util.ArrayList;

public class Customer {
  public Customer(String fname, String lname, String mail) {
    this.firstname = fname;
    this.lastname = lname;
    this.email = mail;
    this.currentRentals = new ArrayList<Book>();
  }
  public Customer(String fname, String lname, String mail, ArrayList<Book> rentals) {
    super();
    this.currentRentals = rentals;
  }
  public String getFirstName() {
    return this.firstname;
  }
  public String getLastName() {
    return this.lastname;
  }
  public String getEmail() {
    return this.email;
  }
  public void setFirstName(String newFName) {
    this.firstname = newFName;
  }
  public void setLastName(String newLName) {
    this.lastname = newLName;
  }
  public void setEmail(String newEmail) {
    this.email = newEmail;
  }
  public void addRental(Book newBook) {
    this.currentRentals.add(newBook);
  }
  public String toString() {
    return this.firstname + " " + this.lastname + "\n" + this.email + "\n\n";
  }
  private String firstname;
  private String lastname;
  private String email;
  private ArrayList<Book> currentRentals;
}