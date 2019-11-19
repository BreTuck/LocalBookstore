import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddBookForm extends JPanel {
    private static int FRAME_WIDTH = 1000;
    private static int FRAME_HEIGHT = 800;

    private static int GAP_WIDTH = 10;
    private static int GAP_HEIGHT = 10;
    private TextField[] formFields = new TextField[5];
    private StoreUI storeInstance;

    public AddBookForm(StoreUI store) {
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

        JButton submitForm = new JButton("Submit New Book");
        submitForm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Create Book object
                // mainControl.addBook(Book object);
                storeInstance.mainControl.add(new Book(formFields[0].getText(), formFields[1].getText(), formFields[2].getText(), Integer.parseInt(formFields[3].getText()), Integer.parseInt(formFields[4].getText())));
                storeInstance.setHomeScreen();
            }
        });
        formLayout.putConstraint(SpringLayout.NORTH, submitForm, 100, SpringLayout.SOUTH, form);
        add(submitForm);
        
        
        final int txtFieldSize = 15;
        String[] formLabels = {"Title: ", "Author: ", "Publisher: ", "Number of Pages: ", "Number of Copies to Add: "};
        int numPairs = formLabels.length;

        for(int idx = 0; idx < numPairs; idx = idx + 1) {
            JLabel formLabel = new JLabel(formLabels[idx], JLabel.TRAILING);
            TextField formField = new TextField(txtFieldSize);
            this.formFields[idx] = formField;
            formLabel.setLabelFor(formField);
            form.add(formLabel);
            form.add(formField);
        }
        SpringUtilities.makeCompactGrid(form, numPairs, 2, 6, 6, GAP_WIDTH, GAP_HEIGHT);
        add(form);
        setVisible(true);
    }


}