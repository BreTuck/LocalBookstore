import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchBookForm extends JPanel {
    private static int FRAME_WIDTH = 1000;
    private static int FRAME_HEIGHT = 800;

    private static int SCROLL_PANE_WIDTH = 800;
    private static int SCROLL_PANE_HEIGHT = 400;

    private static int GAP_SIZE = 10;
    private StoreUI storeInstance;

    public SearchBookForm(StoreUI store) {
        super();
        this.storeInstance = store;
        SpringLayout formLayout = new SpringLayout();
        setLayout(formLayout);
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setOpaque(true);
        setBackground(new Color(255, 255, 255));

        JPanel form = new JPanel(new SpringLayout());

        JLabel formTitle = new JLabel("Add a Book to Inventory");
        formLayout.putConstraint(SpringLayout.NORTH, this, 100, SpringLayout.NORTH, formTitle);
        formLayout.putConstraint(SpringLayout.SOUTH, form, 300, SpringLayout.NORTH, formTitle);
        add(formTitle);

        final int txtFieldSize = 15;
        // Book Title 
        JLabel titleLabel = new JLabel("Book Title: ", JLabel.TRAILING);
        TextField titleField = new TextField(txtFieldSize);
        titleLabel.setLabelFor(titleField);
        form.add(titleLabel);
        form.add(titleField);

        // Book Author
        JLabel authorLabel = new JLabel("Book Author: ", JLabel.TRAILING);
        TextField authorField = new TextField(txtFieldSize);
        authorLabel.setLabelFor(authorField);
        form.add(authorLabel);
        form.add(authorField);

        SpringUtilities.makeCompactGrid(form, 2, 2, 6, 6, GAP_SIZE, GAP_SIZE);
        add(form);

        JButton submitForm = new JButton("Search Inventory");
        submitForm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Book[] bookResults = storeInstance.mainControl.search(titleField.getText());
                JScrollPane infoPane;
                if(bookResults.length >= 0) {
                    infoPane = new JScrollPane(new JTextArea("No Matches Found in Inventory", 1, 1));

                } else {
                    JList<Book> bookData = new JList<Book>(bookResults);
                    infoPane = new JScrollPane(bookData);
                }
 

                
                infoPane.setPreferredSize(new Dimension(SCROLL_PANE_WIDTH, SCROLL_PANE_HEIGHT));

                JButton backToHome = new JButton("Back to Home Page");
                backToHome.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        storeInstance.setHomeScreen();
                    }
                });

                removeAll();
                add(infoPane);
                formLayout.putConstraint(SpringLayout.NORTH, backToHome, 100, SpringLayout.SOUTH, infoPane);
                add(backToHome);

                revalidate();
                repaint();
            }
        });
        formLayout.putConstraint(SpringLayout.NORTH, submitForm, 100, SpringLayout.SOUTH, form);
        add(submitForm);
        setVisible(true);
    }
}