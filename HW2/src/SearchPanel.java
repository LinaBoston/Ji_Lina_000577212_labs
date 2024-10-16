import javax.swing.*;
import java.awt.*;


public class SearchPanel extends JPanel {

    private JTextArea resultArea;

    public SearchPanel(MainJFrame mainJFrame) {
        setLayout(new BorderLayout());

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);

        add(new JScrollPane(resultArea), BorderLayout.CENTER);
    }

    public void displayPerson(Person person) {
        resultArea.setText("Person found:\n" +
                "First Name: " + person.getFirstName() + "\n" +
                "Last Name: " + person.getLastName() + "\n" +
                "Email: " + person.getEmail() + "\n" +
                "Phone: " + person.getPhone() + "\n" +
                "Home Address: " + person.getHomeAddress().getAddressLine() + "\n" +
                "Work Address: " + person.getWorkAddress().getAddressLine() + "\n" +
                "Age: " + person.getAge() + "\n" +
                "Marital Status: " + (person.isMarried() ? "Married" : "Not Married"));
    }


}
