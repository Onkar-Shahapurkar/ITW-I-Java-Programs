import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Assi_18 extends JFrame {
    private JTextField nameField, ageField;
    private JButton saveButton, loadButton;
    private Connection connection;

    public Assi_18() {
        setTitle("Database Application");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        nameField = new JTextField(20);
        ageField = new JTextField(20);
        saveButton = new JButton("Save");
        loadButton = new JButton("Load");

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });

        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadData();
            }
        });

        setLayout(new FlowLayout());

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Age:"));
        add(ageField);
        add(saveButton);
        add(loadButton);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ITW", "root", "onkar2814");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveData() {
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO human (name, age) VALUES (?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            JOptionPane.showMessageDialog(this, "Data saved successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadData() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM human");
            ResultSet resultSet = preparedStatement.executeQuery();

            StringBuilder resultText = new StringBuilder();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                resultText.append("Name: ").append(name).append(", Age: ").append(age).append("\n");
            }

            resultSet.close();
            preparedStatement.close();

            JTextArea textArea = new JTextArea(resultText.toString(), 10, 30);
            JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Loaded Data", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Assi_18().setVisible(true);
        });
    }
}