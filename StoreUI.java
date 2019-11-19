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

    AddBookForm newAddForm = new AddBookForm(this);

    JMenu mainMenu = new JMenu("Main Menu");
    
    JMenu addMenu = new JMenu("Add New...");
    JMenuItem addBookMenuItem = new JMenuItem("Add New Book");
    JMenuItem addCustomerMenuItem = new JMenuItem("Add New Customer");
    addBookMenuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        changeScreen(newAddForm);
      }
    });


    addMenu.add(addBookMenuItem);
    addMenu.add(addCustomerMenuItem);
    mainMenu.add(addMenu);
    mainMenu.addSeparator();

    JMenu searchMenu = new JMenu("Search...");
    JMenuItem searchInvMenuItem = new JMenuItem("Search Inventory By Title");
    JMenuItem searchCustomerMenuItem = new JMenuItem("Search Customer By Name");
    searchMenu.add(searchInvMenuItem);
    searchMenu.add(searchCustomerMenuItem);
    mainMenu.add(searchMenu);
    mainMenu.addSeparator();

    JMenu displayMenu = new JMenu("Display...");
    JMenu displayInvMenu = new JMenu("Display Inventory...");
    JMenuItem displayFullInv = new JMenuItem("Display Full Inventory");
    JMenuItem displayRentedInv = new JMenuItem("Display Rented Inventory");
    displayInvMenu.add(displayFullInv);
    displayInvMenu.add(displayRentedInv);
    JMenuItem displayCustomerMenuItem = new JMenuItem("Display Clientele");
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
  // public Book[] updateBookData() {
  //   int inventoryCount = this.storeModel.getInventoryCount();
  //   Book[] bookData = new Book[inventoryCount];
  //   for(int invIdx = 0; invIdx < inventoryCount; invIdx = invIdx + 1) {
  //     bookData[invIdx] = this.storeModel.getBook(invIdx);
  //   }
  //   return bookData;
  // }
}