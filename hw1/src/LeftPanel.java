import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftPanel extends JPanel {
    private JButton createButton;
    private JButton viewButton;
    private MainJFrame mainJFrame;

    public LeftPanel(MainJFrame mainJFrame) {
        this.mainJFrame = mainJFrame;

        setLayout(new GridLayout(2, 1, 10, 10));
        setPreferredSize(new Dimension(200, getHeight()));
        setBorder(BorderFactory.createEmptyBorder(20,10,20,10));

        createButton = new JButton("Create Profile");
        viewButton = new JButton("View Profile");

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainJFrame != null) {
                    mainJFrame.showPanel("CREATE");
                } else {
                    System.out.println("MainJFrame is null.");
                }
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainJFrame.showPanel("VIEW");
            }
        });

        add(createButton);
        add(viewButton);
    }
}
