import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateProfilePanel extends JPanel {

    private MainJFrame mainJFrame;

    private JTextField[] textFields;
    private JButton updateButton;
    private JButton submitButton;
    private String[] labels = {
            "First Name", "Last Name", "Email", "Phone",
            "Social Security Number", "Home Address Line", "Home City", "Home State", "Home ZIP",
            "Work Address Line", "Work City", "Work State", "Work ZIP",
            "Age", "Is Married (true/false)"
    };


    private Person currentPerson;

    public CreateProfilePanel(MainJFrame mainJFrame) {
        this.mainJFrame = mainJFrame;

        setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane();


        JPanel formPanel = new JPanel(new GridLayout(labels.length, 2, 10, 10));
        updateButton = new JButton("Update");
        submitButton = new JButton("Create");

        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        formPanel.setBackground(Color.lightGray);
        formPanel.setOpaque(true);
        textFields = new JTextField[labels.length];

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i] + ": ");

            textFields[i] = new JTextField();

            formPanel.add(label);
            formPanel.add(textFields[i]);
        }

        scrollPane.setViewportView(formPanel);

        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        buttonPanel.add(updateButton);
        add(buttonPanel, BorderLayout.SOUTH);

        updateButton.setVisible(false);


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createProfile();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateProfile();
            }
        });
    }

    private void createProfile() {

        String firstName = textFields[0].getText().trim();
        String lastName = textFields[1].getText().trim();
        String email = textFields[2].getText().trim();
        String phoneStr = textFields[3].getText().trim();
        String socialSecurityNumber = textFields[4].getText().trim();
        String homeAddressLine = textFields[5].getText().trim();
        String homeCity = textFields[6].getText().trim();
        String homeState = textFields[7].getText().trim();
        String homeZipStr = textFields[8].getText().trim();
        String workAddressLine = textFields[9].getText().trim();
        String workCity = textFields[10].getText().trim();
        String workState = textFields[11].getText().trim();
        String workZipStr = textFields[12].getText().trim();
        String ageStr = textFields[13].getText().trim();
        String isMarriedStr = textFields[14].getText().trim();


        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phoneStr.isEmpty() ||
                socialSecurityNumber.isEmpty() || homeAddressLine.isEmpty() || homeCity.isEmpty() ||
                homeState.isEmpty() || homeZipStr.isEmpty() || workAddressLine.isEmpty() ||
                workCity.isEmpty() || workState.isEmpty() || workZipStr.isEmpty() || ageStr.isEmpty() || isMarriedStr.isEmpty()) {
            JOptionPane.showMessageDialog(mainJFrame, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            long phone = Long.parseLong(phoneStr);
            int homeZip = Integer.parseInt(homeZipStr);
            int workZip = Integer.parseInt(workZipStr);
            short age = Short.parseShort(ageStr);
            boolean isMarried = Boolean.parseBoolean(isMarriedStr);

            Address homeAddress = new Address(homeAddressLine, homeCity, homeState, homeZip);
            Address workAddress = new Address(workAddressLine, workCity, workState, workZip);

            Person person = new Person(firstName, lastName, email, phone, socialSecurityNumber, homeAddress, workAddress, age, isMarried);
            mainJFrame.addPerson(person);
            mainJFrame.refreshPersonListDisplay();

            JOptionPane.showMessageDialog(mainJFrame, "Profile created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearForm();
        }

        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(mainJFrame, "Invalid number format in Phone, ZIP, or Age.", "Error", JOptionPane.ERROR_MESSAGE);
            }


        }


    private void updateProfile() {
        if (currentPerson != null) {

            String firstName = textFields[0].getText().trim();
            String lastName = textFields[1].getText().trim();
            String email = textFields[2].getText().trim();
            String phoneStr = textFields[3].getText().trim();
            String socialSecurityNumber = textFields[4].getText().trim();
            String homeAddressLine = textFields[5].getText().trim();
            String homeCity = textFields[6].getText().trim();
            String homeState = textFields[7].getText().trim();
            String homeZipStr = textFields[8].getText().trim();
            String workAddressLine = textFields[9].getText().trim();
            String workCity = textFields[10].getText().trim();
            String workState = textFields[11].getText().trim();
            String workZipStr = textFields[12].getText().trim();
            String ageStr = textFields[13].getText().trim();
            String isMarriedStr = textFields[14].getText().trim();


            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phoneStr.isEmpty() ||
                    socialSecurityNumber.isEmpty() || homeAddressLine.isEmpty() || homeCity.isEmpty() ||
                    homeState.isEmpty() || homeZipStr.isEmpty() || workAddressLine.isEmpty() ||
                    workCity.isEmpty() || workState.isEmpty() || workZipStr.isEmpty() || ageStr.isEmpty() || isMarriedStr.isEmpty()) {
                JOptionPane.showMessageDialog(mainJFrame, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                long phone = Long.parseLong(phoneStr);
                int homeZip = Integer.parseInt(homeZipStr);
                int workZip = Integer.parseInt(workZipStr);
                short age = Short.parseShort(ageStr);
                boolean isMarried = Boolean.parseBoolean(isMarriedStr);


                currentPerson.setFirstName(firstName);
                currentPerson.setLastName(lastName);
                currentPerson.setEmail(email);
                currentPerson.setPhone(phone);
                currentPerson.setSocialSecurityNumber(socialSecurityNumber);
                currentPerson.getHomeAddress().setAddressLine(homeAddressLine);
                currentPerson.getHomeAddress().setCity(homeCity);
                currentPerson.getHomeAddress().setState(homeState);
                currentPerson.getHomeAddress().setZip(homeZip);
                currentPerson.getWorkAddress().setAddressLine(workAddressLine);
                currentPerson.getWorkAddress().setCity(workCity);
                currentPerson.getWorkAddress().setState(workState);
                currentPerson.getWorkAddress().setZip(workZip);
                currentPerson.setAge(age);
                currentPerson.setMarried(isMarried);


                mainJFrame.refreshPersonListDisplay();

                JOptionPane.showMessageDialog(mainJFrame, "Profile updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                clearForm();

                updateButton.setVisible(false);
                submitButton.setVisible(true);
                currentPerson = null;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(mainJFrame, "Invalid number format in Phone, ZIP, or Age.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void displayPerson(Person person) {
        this.currentPerson = person;

        textFields[0].setText(person.getFirstName());
        textFields[1].setText(person.getLastName());
        textFields[2].setText(person.getEmail());
        textFields[3].setText(String.valueOf(person.getPhone()));
        textFields[4].setText(person.getSocialSecurityNumber());
        textFields[5].setText(person.getHomeAddress().getAddressLine());
        textFields[6].setText(person.getHomeAddress().getCity());
        textFields[7].setText(person.getHomeAddress().getState());
        textFields[8].setText(String.valueOf(person.getHomeAddress().getZip()));
        textFields[9].setText(person.getWorkAddress().getAddressLine());
        textFields[10].setText(person.getWorkAddress().getCity());
        textFields[11].setText(person.getWorkAddress().getState());
        textFields[12].setText(String.valueOf(person.getWorkAddress().getZip()));
        textFields[13].setText(String.valueOf(person.getAge()));
        textFields[14].setText(String.valueOf(person.isMarried()));


        updateButton.setVisible(true);
        submitButton.setVisible(false);
    }

    public void clearForm() {
        for (JTextField tf : textFields) {
            tf.setText("");
        }

    }

}