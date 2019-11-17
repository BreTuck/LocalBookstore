import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StoreUI extends JFrame {
  private static int FRAME_WIDTH = 1000;
  private static int FRAME_HEIGHT = 800;
  private static int MENUBAR_HEIGHT = 35;
  private Bookstore storeModel;

  public StoreUI(Bookstore storeData) {
    super("Local Bookstore");
    this.storeModel = storeData;
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
    setJMenuBar(createMenuBar());

    getContentPane().add(new AddBookForm(), BorderLayout.CENTER);
    pack();
    setVisible(true);
  }
  private JMenuBar createMenuBar() {
    JMenuBar menuBar = new JMenuBar();
    menuBar.setPreferredSize(new Dimension(FRAME_WIDTH, MENUBAR_HEIGHT));
    menuBar.setOpaque(true);
    menuBar.setBackground(new Color(30, 150, 200));
    menuBar.add(new StoreMenu());
    return menuBar;
  }
  public Book[] updateBookData() {
    int inventoryCount = this.storeModel.getInventoryCount();
    Book[] bookData = new Book[inventoryCount];
    for(int invIdx = 0; invIdx < inventoryCount; invIdx = invIdx + 1) {
      bookData[invIdx] = this.storeModel.getBook(invIdx);
    }
    return bookData;
  }
}