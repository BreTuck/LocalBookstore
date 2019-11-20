import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DisplayPane extends JPanel {
    private static int FRAME_WIDTH = 1000;
    private static int FRAME_HEIGHT = 800;

    private static int GAP_SIZE = 10;
    private StoreUI storeInstance;
    private Object[] dataList;

    public DisplayPane(StoreUI UI, Object[] dataArr) {
        super();
        this.storeInstance = UI;
        this.dataList = dataArr;
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setOpaque(true);
        setBackground(new Color(255, 255, 255));

        JList bookList = new JList(this.dataList);
        JScrollPane mainPane = new JScrollPane();

        add(mainPane);
        JButton backToHome = new JButton("Back to Home Page");
        backToHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                storeInstance.setHomeScreen();
            }
        });

        add(backToHome);
        setVisible(true);
    }
}

