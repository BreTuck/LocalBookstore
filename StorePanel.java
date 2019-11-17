import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StorePanel extends JPanel {
    public StorePanel() {
        super();
        setPreferredSize(new Dimension());
        setOpaque(true);
        setBackground(new Color(255, 255, 255));
        createMenu();
    }

    private JMenu createMenu() {
        JMenu mainMenu = new JMenu("Main Menu");

    JMenu addMenu = new JMenu("Add New...");
      JMenuItem addBookMenuItem = new JMenuItem("Add New Book");
      JMenuItem addCustomerMenuItem = new JMenuItem("Add New Customer");

      addBookMenuItem.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
        //   JList<Book> bookList = new JList<Book>(updateBookData());
        //   JScrollPane mainScrollPane = new JScrollPane(bookList);

        //   add(mainScrollPane, BorderLayout.CENTER);
        //   revalidate();
        //   repaint();


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
    
    return mainMenu;
    }

}