import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftPanel extends JPanel {
    private JButton createButton;
    private JButton viewButton;
    private JButton searchButton;
    private JTextField searchField;
    private MainJFrame mainJFrame;

    public LeftPanel(MainJFrame mainJFrame) {
        this.mainJFrame = mainJFrame;


        setBackground(Color.pink);



        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(200, 400));
        setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));


        createButton = new JButton("Create Profile");
        viewButton = new JButton("List Profile");
        searchField = new JTextField();
        searchField.setMaximumSize(new Dimension(170, 30));
        searchField.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchButton = new JButton("Search for Person");

        Dimension buttonSize = new Dimension(180, 40);
        createButton.setMaximumSize(buttonSize);
        viewButton.setMaximumSize(buttonSize);
        searchButton.setMaximumSize(buttonSize);


        createButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);



        add(Box.createVerticalGlue());
        add(createButton);
        add(Box.createVerticalStrut(10));
        add(viewButton);
        add(Box.createVerticalStrut(10));



        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.Y_AXIS));
        searchPanel.setOpaque(false);

        JLabel searchLabel = new JLabel("Type name or address:");
        searchLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.add(searchLabel);
        searchPanel.add(Box.createVerticalStrut(5));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(searchPanel);
        add(Box.createVerticalGlue());

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainJFrame != null) {
                    mainJFrame.showPanel("CREATE");
                    mainJFrame.clearCreateProfilePanelForm();
                } else {
                    System.out.println("MainJFrame is null.");
                }
            }

        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainJFrame.getViewProfilePanel().displayPersonList(mainJFrame.getPersonList());
                mainJFrame.showPanel("VIEW");
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchField.getText().trim();
                if (!searchTerm.isEmpty()) {
                    Person foundPerson = mainJFrame.searchPerson(searchTerm);
                    if (foundPerson != null) {
                        mainJFrame.getCreateProfilePanel().displayPerson(foundPerson);
                    }
                    mainJFrame.showPanel("CREATE");
                    mainJFrame.getCreateProfilePanel().revalidate();
                    mainJFrame.getCreateProfilePanel().repaint();
                } else {
                    JOptionPane.showMessageDialog(mainJFrame, "Please enter a search term.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}