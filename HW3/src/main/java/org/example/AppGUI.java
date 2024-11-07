package org.example;
import io.github.stefanbratanov.jvm.openai.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AppGUI extends JFrame {
    private static int RequestCount = 0;
    private JPanel messagePanel;
    private JTextField userInputField;
    private JButton sendButton;
    private List<String> previousMessages = new ArrayList<>();

    public AppGUI() {
        setTitle("OpenGPT Chat Interface");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Setup components
        messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(messagePanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        userInputField = new JTextField();
        sendButton = new JButton("Send");

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(userInputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // Button action
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userMessage = userInputField.getText().trim();
                if (!userMessage.isEmpty()) {
                    String response = AskOpenAIConcisely(previousMessages, userMessage);
                    addMessageToPanel(userMessage, true);
                    addMessageToPanel(response, false);
                    userInputField.setText("");
                    SwingUtilities.invokeLater(() -> scrollToBottom(scrollPane));
                }
            }
        });
    }

    private void addMessageToPanel(String message, boolean isUser) {
        JPanel messageContainer = new JPanel();
        messageContainer.setLayout(new BoxLayout(messageContainer, BoxLayout.X_AXIS));


        JTextArea messageArea = new JTextArea(message) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


                g2.setColor(isUser ? Color.LIGHT_GRAY : Color.WHITE);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
                g2.dispose();
                super.paintComponent(g);
            }
        };


        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);
        messageArea.setEditable(false);
        messageArea.setOpaque(false);
        messageArea.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        messageArea.setMaximumSize(new Dimension(450, Integer.MAX_VALUE));

        if (isUser) {
            messageContainer.add(Box.createHorizontalGlue());
            messageContainer.add(messageArea);
        } else {

            JLabel iconLabel = new JLabel();
            try {
                URL url = new URL("https://eu-images.contentstack.com/v3/assets/blt6b0f74e5591baa03/blt1999f39bbcf370d3/6568f0806778ef040a6a7315/News_Image_-_2023-11-30T142842.817.png?width=1280&auto=webp&quality=95&format=jpg&disable=upscale&#34");
                iconLabel.setIcon(new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
            } catch (Exception e) {
                e.printStackTrace();
            }
            messageContainer.add(iconLabel);
            messageContainer.add(messageArea);
            messageContainer.add(Box.createHorizontalGlue());
        }


        messagePanel.add(messageContainer);
        messagePanel.add(Box.createVerticalStrut(10));
        messagePanel.revalidate();
    }

    private void scrollToBottom(JScrollPane scrollPane) {
        JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
        verticalBar.setValue(verticalBar.getMaximum());
    }

    public static String MakeSomeComplexAdditionToTheMessage(String userMessage) {
        return userMessage;
    }

    public static String AskOpenAIConcisely(List<String> previousMessages, String userMessage) {
        userMessage = MakeSomeComplexAdditionToTheMessage(userMessage);
        System.out.println("-------------------------");
        System.out.println("REQUEST #: " + RequestCount);
        System.out.println("USER: " + userMessage);

        String response = OpenAI.CallOpenAI(previousMessages, userMessage); // Placeholder for real API call
        System.out.println("SYSTEM: " + response);
        RequestCount++;

        return response;
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppGUI app = new AppGUI();
            app.setVisible(true);
        });
    }
}


