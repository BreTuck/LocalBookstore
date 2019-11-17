import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddBookForm extends JPanel {
    private static int FRAME_WIDTH = 1000;
    private static int FRAME_HEIGHT = 800;

    private static int GAP_WIDTH = 200;
    private static int GAP_HEIGHT = 200;

    public AddBookForm() {
        super();
        SpringLayout formLayout = new SpringLayout();
        setLayout(formLayout);
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setOpaque(true);
        setBackground(new Color(255, 255, 255));
        JPanel form = new JPanel(new SpringLayout());

        JLabel formTitle = new JLabel("Add a Book to Inventory");
        formLayout.putConstraint(SpringLayout.SOUTH, this, 100, SpringLayout.NORTH, formTitle);
        formLayout.putConstraint(SpringLayout.SOUTH, form, 200, SpringLayout.NORTH, formTitle);
        add(formTitle);
        
        
        final int txtFieldSize = 15;
        String[] formLabels = {"Title: ", "Author: ", "Publisher: ", "Number of Pages: ", "Number of Copies to Add: "};
        int numPairs = formLabels.length;

        for(int labelIdx = 0; labelIdx < numPairs; labelIdx = labelIdx + 1) {
            JLabel formLabel = new JLabel(formLabels[labelIdx], JLabel.TRAILING);
            TextField formField = new TextField(txtFieldSize);
            formLabel.setLabelFor(formField);
            form.add(formLabel);
            form.add(formField);
        }
        SpringUtilities.makeCompactGrid(form, numPairs, 2, 6, 6, 6, 6);
        add(form);
        setVisible(true);
    }


}