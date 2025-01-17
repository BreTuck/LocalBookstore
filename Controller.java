import java.util.ArrayList;

public class Controller {
    private Bookstore mainModel;
    
    public Controller(Bookstore model) {
        this.mainModel = model;
    }
    public Boolean add(Book bookToAdd) {
        return this.mainModel.addBook(bookToAdd);
    }
    public Boolean add(Customer customerToAdd) {
        return this.mainModel.addCustomer(customerToAdd);
    }
    public Book[] search(String proposedTitle) {
        Book[] potentialBook = new Book[1];
        potentialBook[0] = this.mainModel.searchBook(proposedTitle);
        return potentialBook;
    }
    public Customer[] search(String proposedFName, String proposedLName) {
        Customer[] potentialCustomer = new Customer[1];
        potentialCustomer[0] = this.mainModel.searchCustomer(proposedFName, proposedLName);
        return potentialCustomer;
    }
    public Book[] updateBookData() {
        ArrayList<Book> inv = this.mainModel.getInventory();
        int inventoryCount = inv.size();
        Book[] bookData = new Book[inventoryCount];
        for(int invIdx = 0; invIdx < inventoryCount; invIdx = invIdx + 1) {
        bookData[invIdx] = inv.get(invIdx);
        }
        return bookData;
    }
    public Customer[] updateCustomerData() {
        ArrayList<Customer> customers = this.mainModel.getCustomers();
        int customerCount = customers.size();
        Customer[] customerData = new Customer[customerCount];
        for(int invIdx = 0; invIdx < customerCount; invIdx = invIdx + 1) {
        customerData[invIdx] = customers.get(invIdx);
        }
        return customerData;
    }
}