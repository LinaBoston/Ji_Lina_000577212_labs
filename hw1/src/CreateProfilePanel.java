import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CreateProfilePanel extends JPanel {

    private MainJFrame mainJFrame;

    private JTextField[] textFields;

    private String[] labels = {
            "First Name", "Last Name", "Email", "Phone",
            "Driver's License", "Social Security Number", "Address Line 1",
            "Address Line 2", "City", "State", "ZIP", "Telephone Number",
            "Fax Number",  "School Name", "Major", "Father's First Name",
            "Father's Last Name", "Mother's First Name", "Mother's Last Name"
    };



    public CreateProfilePanel(MainJFrame mainJFrame) {
        this.mainJFrame = mainJFrame;


        setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane();
        JPanel formPanel = new JPanel(new GridLayout(labels.length, 2, 10, 10));

        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        textFields = new JTextField[labels.length];

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i] + ": ");

            textFields[i] = new JTextField();

            formPanel.add(label);
            formPanel.add(textFields[i]);
        }

        scrollPane.setViewportView(formPanel);

        add(scrollPane, BorderLayout.CENTER);


        JButton submitButton = new JButton("Create");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);

        add(buttonPanel, BorderLayout.SOUTH);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String firstName = textFields[0].getText().trim();
                String lastName = textFields[1].getText().trim();
                String email = textFields[2].getText().trim();
                String phone = textFields[3].getText().trim();
                String driversLicense = textFields[4].getText().trim();
                String socialSecurityNumber = textFields[5].getText().trim();
                String addressLine1 = textFields[6].getText().trim();
                String addressLine2 = textFields[7].getText().trim();
                String city = textFields[8].getText().trim();
                String state = textFields[9].getText().trim();
                String zip = textFields[10].getText().trim();
                String telephoneNumber = textFields[11].getText().trim();
                String faxNumber = textFields[12].getText().trim();
                String schoolName = textFields[13].getText().trim();
                String major = textFields[14].getText().trim();
                String fathersFirstName = textFields[15].getText().trim();
                String fathersLastName = textFields[16].getText().trim();
                String mothersFirstName = textFields[17].getText().trim();
                String mothersLastName = textFields[18].getText().trim();



                if (firstName.isEmpty() || lastName.isEmpty()) {
                    JOptionPane.showMessageDialog(mainJFrame, "First Name and Last Name are required.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Person person = new Person(
                        firstName, lastName, email, phone, driversLicense, socialSecurityNumber,
                        addressLine1, addressLine2, city, state, zip, telephoneNumber,
                        faxNumber,schoolName,major,fathersFirstName,fathersLastName, mothersFirstName,mothersLastName
                );

                mainJFrame.setCurrentPerson(person);


                JOptionPane.showMessageDialog(mainJFrame, "Profile created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                for (JTextField tf : textFields) {
                    tf.setText("");
                }
            }
        });
    }
}

