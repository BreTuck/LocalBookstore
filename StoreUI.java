import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StoreUI extends JFrame {
  private static int FRAME_WIDTH = 1000;
  private static int FRAME_HEIGHT = 800;
  private static int MENUBAR_HEIGHT = 35;
  private JPanel homeScreen;
  private Container frameCntPane;
  public Controller mainControl;

  public StoreUI(Controller control) {
    super("Local Bookstore");
    this.mainControl = control;
    this.frameCntPane = this.getContentPane();
    this.homeScreen = new JPanel(new BorderLayout());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

    getContentPane().add(this.homeScreen, BorderLayout.CENTER);
  
    JMenuBar menuBar = new JMenuBar();
    menuBar.setPreferredSize(new Dimension(FRAME_WIDTH, MENUBAR_HEIGHT));
    menuBar.setOpaque(true);
    menuBar.setBackground(new Color(30, 150, 200));

    AddBookForm addBookForm = new AddBookForm(this);
    AddCustomerForm addCustomerForm = new AddCustomerForm(this);
    SearchBookForm searchBookForm = new SearchBookForm(this);
    SearchCustomerForm searchCustomerForm = new SearchCustomerForm(this);
    DisplayPane<Book> fullInvDisplay = new DisplayPane<Book>(this, this.mainControl.updateBookData());
    // DisplayPane rentedInvDisplay = new DisplayPane<Book>(this, this.mainControl.updateBookData());
    DisplayPane<Customer> customerDisplay = new DisplayPane<Customer>(this, this.mainControl.updateCustomerData());

    JMenu mainMenu = new JMenu("Main Menu");
    
    JMenu addMenu = new JMenu("Add New...");
    JMenuItem addBook = new JMenuItem("Add New Book");
    JMenuItem addCustomer = new JMenuItem("Add New Customer");
    addBook.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        changeScreen(addBookForm);
      }
    });

    addCustomer.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        changeScreen(addCustomerForm);
      }
    });

    addMenu.add(addBook);
    addMenu.add(addCustomer);
    mainMenu.add(addMenu);
    mainMenu.addSeparator();

    JMenu searchMenu = new JMenu("Search...");
    JMenuItem searchInv = new JMenuItem("Search Inventory By Title");
    JMenuItem searchCustomer = new JMenuItem("Search Customer By Name");

    searchInv.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        changeScreen(searchBookForm);
      }
    });

    searchCustomer.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        changeScreen(searchCustomerForm);
      }
    });

    searchMenu.add(searchInv);
    searchMenu.add(searchCustomer);
    mainMenu.add(searchMenu);
    mainMenu.addSeparator();

    JMenu displayMenu = new JMenu("Display...");
    JMenu displayInvMenu = new JMenu("Display Inventory...");
    JMenuItem displayFullInv = new JMenuItem("Display Full Inventory");
    JMenuItem displayRentedInv = new JMenuItem("Display Rented Inventory");
    displayInvMenu.add(displayFullInv);
    displayInvMenu.add(displayRentedInv);
    JMenuItem displayCustomerMenuItem = new JMenuItem("Display Clientele");


    displayFullInv.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        changeScreen(fullInvDisplay);
      }
    });

    displayCustomerMenuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        changeScreen(customerDisplay);
      }
    });


    displayMenu.add(displayInvMenu);
    displayMenu.add(displayCustomerMenuItem);
    mainMenu.add(displayMenu);
    mainMenu.addSeparator();

    JMenuItem rentBookMenuItem = new JMenuItem("Rent A Book");
    mainMenu.add(rentBookMenuItem);


    menuBar.add(mainMenu);
    setJMenuBar(menuBar);

    pack();
    setVisible(true);
  }
  public void setHomeScreen() {
    this.changeScreen(this.homeScreen);
  }
  public void changeScreen(JPanel newScreen) {
    this.frameCntPane.removeAll();
    this.frameCntPane.add(newScreen, BorderLayout.CENTER);
    revalidate();
    repaint();
  }
}