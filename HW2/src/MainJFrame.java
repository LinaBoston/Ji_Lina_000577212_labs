import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainJFrame extends JFrame {

    private LeftPanel leftPanel;
    private JPanel rightPanel;
    private CardLayout cardLayout;
    private CreateProfilePanel createProfilePanel;
    private ViewProfilePanel viewProfilePanel;
    private SearchPanel searchPanel;
    private ArrayList<Person> personList;

    public MainJFrame() {
        setTitle("Homework 2 Person Profile Application");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        cardLayout = new CardLayout();
        rightPanel = new JPanel(cardLayout);


        createProfilePanel = new CreateProfilePanel(this);
        viewProfilePanel = new ViewProfilePanel(this);
        searchPanel = new SearchPanel(this);


        rightPanel.add(createProfilePanel, "CREATE");
        rightPanel.add(viewProfilePanel, "VIEW");
        rightPanel.add(searchPanel, "SEARCH");
        rightPanel.setBackground(Color.yellow);
        rightPanel.setForeground(Color.yellow);
        rightPanel.setOpaque(true);

        setLayout(new BorderLayout());


        leftPanel = new LeftPanel(this);
        add(leftPanel, BorderLayout.WEST);
        add(new JScrollPane(rightPanel), BorderLayout.CENTER);


        cardLayout.show(rightPanel, "CREATE");

        personList = new ArrayList<>();
        initializePersonData();
    }

    public void clearCreateProfilePanelForm() {
        if (createProfilePanel != null) {
            createProfilePanel.clearForm();
        }
    }

    private void initializePersonData() {
        Address homeAddress1 = new Address("1 Main St", "San Jose", "CA", (int) 94000);
        Address workAddress1 = new Address("3 Work Rd", "Stanford", "CA", (int) 94100);
        Person person1 = new Person("David", "Du", "david.123@gmail.com", 1345347890,
                "123456789", homeAddress1, workAddress1, (short)30, true);

        Address homeAddress2 = new Address("7 Elm St", "New York", "NY", (int) 94001);
        Address workAddress2 = new Address("3 Office Rd", "MountainView", "CA", (int) 94101);
        Person person2 = new Person("Lisa", "Smith", "lisa.smith@gmail.com", 250654320,
                "556754321", homeAddress2, workAddress2, (short)34, false);

        Address homeAddress3 = new Address("445 new St", "Boston", "MA", (int) 02115);
        Address workAddress3 = new Address("235 Washington Rd", "Boston", "MA", (int) 02334);
        Person person3 = new Person("Brandon", "Ski", "brandski@gmail.com", 350654520,
                "234554321", homeAddress2, workAddress2, (short)30, true);

        Address homeAddress4 = new Address("7 Elm St", "Los Gatos", "CA", (int) 92111);
        Address workAddress4 = new Address("3 Office Rd", "MountainView", "CA", (int) 19222);
        Person person4 = new Person("Peter", "Smith", "peter.smith@gmail.com", 250654320,
                "423554321", homeAddress4, workAddress4, (short)50, false);

        Address homeAddress5 = new Address("47 Garden St", "San Gatos", "CA", (int) 94555);
        Address workAddress5 = new Address("876 Paradise Rd", "San Francisco", "CA", (int) 94555);
        Person person5 = new Person("Nancy", "Bird", "nancy.bird@gmail.com", 555654320,
                "555555555", homeAddress5, workAddress5, (short)28, false);

        addPerson(person1);
        addPerson(person2);
        addPerson(person3);
        addPerson(person4);
        addPerson(person5);
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void refreshPersonListDisplay() {
        viewProfilePanel.displayPersonList(personList);
    }

    public void addPerson(Person person) {
        personList.add(person);
        refreshPersonListDisplay();
    }



    public CreateProfilePanel getCreateProfilePanel() {
        return createProfilePanel;
    }

    public ViewProfilePanel getViewProfilePanel() {
        return viewProfilePanel;
    }


    public SearchPanel getSearchPanel() {
        return searchPanel;
    }

    public void showPanel(String panelName) {
        cardLayout.show(rightPanel, panelName);
    }


    public Person searchPerson(String searchTerm) {
        for (Person person : personList) {
            if (person.getFirstName().equalsIgnoreCase(searchTerm) ||
                    person.getLastName().equalsIgnoreCase(searchTerm) ||
                    person.getHomeAddress().getAddressLine().equalsIgnoreCase(searchTerm) ||
                    person.getWorkAddress().getAddressLine().equalsIgnoreCase(searchTerm)) {
                return person;
            }
        }
        return null;
    }


}