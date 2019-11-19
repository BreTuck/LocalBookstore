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
}