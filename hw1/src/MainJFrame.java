import javax.swing.*;
import java.awt.*;

public class MainJFrame extends JFrame{

    private LeftPanel leftPanel;
    private JPanel rightPanel;
    private CardLayout cardLayout;
    private CreateProfilePanel createProfilePanel;
    private ViewProfilePanel viewProfilePanel;
    private Person currentPerson;



        public MainJFrame() {

            setTitle("Homework 1 Person Profile Application");
            setSize(600, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());
            setLocationRelativeTo(null);

            JScrollPane scrollPane = new JScrollPane(rightPanel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

            leftPanel = new LeftPanel(this);
            cardLayout = new CardLayout();
            rightPanel = new JPanel(cardLayout);

            createProfilePanel = new CreateProfilePanel(this);
            viewProfilePanel = new ViewProfilePanel(this);

            rightPanel.add(createProfilePanel, "CREATE");
            rightPanel.add(viewProfilePanel, "VIEW");

            setLayout(new BorderLayout());

            add(leftPanel, BorderLayout.WEST);
            add(rightPanel, BorderLayout.CENTER);

            cardLayout.show(rightPanel, "CREATE");

        }

    public void setCurrentPerson(Person person) {
        this.currentPerson = person;
        viewProfilePanel.displayPerson(person);
    }
    public Person getCurrentPerson() {
        return currentPerson;
    }

    public void showPanel(String panelName) {
        if (panelName.equals("VIEW") && currentPerson == null) {
            JOptionPane.showMessageDialog(this, "No profile to view. Please create a profile first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        cardLayout.show(rightPanel, panelName);
    }
}


