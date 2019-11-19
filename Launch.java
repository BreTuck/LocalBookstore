import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Launch {
  public static void main(String[] args) throws IOException {
    String tempTitle;
    String tempAuthor;
    String tempPublisher;
    int tempPages = 0;
    int tempBooks = 0;

    Customer tempCustomer;
    String tempName;
    String tempFirst;
    String tempLast;
    String tempEmail;
    String tempRental;

    Bookstore mainstore = new Bookstore(new ArrayList<Book>(), new ArrayList<Customer>());
    Controller storeController = new Controller(mainstore);

    File bookFile = new File("catalog.txt");
    File customerFile = new File("clientele.txt");
        
    try(Scanner scanBooks = new Scanner(bookFile)) {
      while(scanBooks.hasNextLine()) {
        tempTitle = scanBooks.nextLine();                
        tempAuthor = scanBooks.nextLine();
        tempPublisher = scanBooks.nextLine();                
        tempPages = Integer.parseInt(scanBooks.nextLine());                
        tempBooks = Integer.parseInt(scanBooks.nextLine());  

        mainstore.addBook(new Book(tempTitle, tempAuthor, tempPublisher, tempPages, tempBooks));
      }
    }
    
    try(Scanner scanCustomers = new Scanner(customerFile)) {
      while(scanCustomers.hasNextLine()) {
        tempName = scanCustomers.nextLine();
        tempEmail = scanCustomers.nextLine();
        tempRental = scanCustomers.nextLine();

        Scanner parseName = new Scanner(tempName);
        parseName.useDelimiter(", ");
        tempLast = parseName.next();
        tempFirst = parseName.next();

        parseName.close();
        tempCustomer = new Customer(tempFirst, tempLast, tempEmail);
        Scanner parseRental = new Scanner(tempRental);
        while(parseRental.hasNext()) {
          parseRental.useDelimiter(", ");
          tempAuthor = parseRental.next();
          tempTitle = parseRental.next();

          mainstore.rentBook(tempCustomer, tempTitle, tempAuthor);
        }
        mainstore.addCustomer(tempCustomer);
        parseRental.close();
      }
    }
    // mainstore.displayInventory();
    // mainstore.displayClientele();

    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        StoreUI storeView = new StoreUI(storeController);
      }
    });
  }
}