import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewProfilePanel extends JPanel {

    private MainJFrame mainJFrame;

    private JTable profileTable;
    private JScrollPane scrollPane;
    private JButton deleteButton;

    public ViewProfilePanel(MainJFrame mainJFrame) {
        this.mainJFrame = mainJFrame;

        setBackground(Color.yellow);
        setLayout(new BorderLayout());




        String[] columnNames = {"First Name", "Last Name", "Home City", "Home ZIP", "Work City", "Work ZIP"};
        Object[][] data = {};

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames)  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
        }
    };


        profileTable = new JTable(tableModel);
        scrollPane = new JScrollPane(profileTable);

        profileTable.setBackground(Color.green);
        scrollPane.getViewport().setBackground(Color.yellow);

        setOpaque(true);
        scrollPane.setOpaque(true);




        add(scrollPane, BorderLayout.CENTER);

        deleteButton = new JButton("Delete Selected");
        deleteButton.setPreferredSize(new Dimension(150, 40));
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedPerson();
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void displayPersonList(ArrayList<Person> personList) {

        String[] columnNames = {"First Name", "Last Name", "Home City", "Home ZIP", "Work City", "Work ZIP"};
        Object[][] data = new Object[personList.size()][6];


        for (int i = 0; i < personList.size(); i++) {
            Person person = personList.get(i);
            data[i][0] = person.getFirstName();
            data[i][1] = person.getLastName();
            data[i][2] = person.getHomeAddress().getCity();
            data[i][3] = person.getHomeAddress().getZip();
            data[i][4] = person.getWorkAddress().getCity();
            data[i][5] = person.getWorkAddress().getZip();
        }
        DefaultTableModel model = (DefaultTableModel) profileTable.getModel();
        model.setDataVector(data, columnNames);


    }
    private void deleteSelectedPerson() {
        int selectedRow = profileTable.getSelectedRow();
        if (selectedRow != -1) {
            Person selectedPerson = mainJFrame.getPersonList().get(selectedRow);

            mainJFrame.getPersonList().remove(selectedPerson);

            displayPersonList(mainJFrame.getPersonList());

        }

    }
}