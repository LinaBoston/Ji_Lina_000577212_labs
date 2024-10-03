import javax.swing.*;
import java.awt.*;

public class ViewProfilePanel extends JPanel {

    private MainJFrame mainJFrame;

    private JTextArea profileTextArea;

    public ViewProfilePanel(MainJFrame mainJFrame) {
        this.mainJFrame = mainJFrame;


        setLayout(new BorderLayout());


        profileTextArea = new JTextArea();

        profileTextArea.setEditable(false);

        profileTextArea.setFont(new Font("Arial", Font.PLAIN, 14));

        profileTextArea.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(profileTextArea);

        add(scrollPane, BorderLayout.CENTER);
    }

    public void displayPerson(Person person) {

        StringBuilder sb = new StringBuilder();


        sb.append("First Name: ").append(person.getFirstName()).append("\n");
        sb.append("Last Name: ").append(person.getLastName()).append("\n");
        sb.append("Email: ").append(person.getEmail()).append("\n");
        sb.append("Phone: ").append(person.getPhone()).append("\n");
        sb.append("Driver's License: ").append(person.getDriversLicense()).append("\n");
        sb.append("Social Security Number: ").append(person.getSocialSecurityNumber()).append("\n");
        sb.append("Address Line 1: ").append(person.getAddressLine1()).append("\n");
        sb.append("Address Line 2: ").append(person.getAddressLine2()).append("\n");
        sb.append("City: ").append(person.getCity()).append("\n");
        sb.append("State: ").append(person.getState()).append("\n");
        sb.append("ZIP: ").append(person.getZip()).append("\n");
        sb.append("Telephone Number: ").append(person.getTelephoneNumber()).append("\n");
        sb.append("Fax Number: ").append(person.getFaxNumber()).append("\n");
        sb.append("School Name: ").append(person.getSchoolName()).append("\n");
        sb.append("Major: ").append(person.getMajor()).append("\n");
        sb.append("Father's First Name: ").append(person.getFathersFirstName()).append("\n");
        sb.append("Father's Last Name: ").append(person.getFathersLastName()).append("\n");
        sb.append("Mother's First Name: ").append(person.getMothersFirstName()).append("\n");
        sb.append("Mother's Last Name: ").append(person.getMothersLastName()).append("\n");

        profileTextArea.setText(sb.toString());
    }
}

