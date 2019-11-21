import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DisplayPane <T> extends JPanel {
    private static int FRAME_WIDTH = 1000;
    private static int FRAME_HEIGHT = 800;

    private static int SCROLL_PANE_WIDTH = 800;
    private static int SCROLL_PANE_HEIGHT = 400;

    private static int GAP_SIZE = 10;
    private StoreUI storeInstance;
    private T[] dataList;

    public DisplayPane(StoreUI UI, T[] dataArr) {
        super();
        this.storeInstance = UI;
        this.dataList = dataArr;
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setOpaque(true);
        setBackground(new Color(255, 255, 255));

        JList<T> list = new JList<T>(this.dataList);
        JScrollPane mainPane = new JScrollPane(list);
        mainPane.setPreferredSize(new Dimension(SCROLL_PANE_WIDTH, SCROLL_PANE_HEIGHT));
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

