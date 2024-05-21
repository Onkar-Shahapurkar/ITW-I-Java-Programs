import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Assi_16 extends JFrame implements ActionListener {
    private JTextField nameField, ageField;
    private JButton saveButton, loadButton;
    private Connection connection;
    private Statement statement;

    public Assi_16() {
        setTitle("Database Application");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        nameField = new JTextField(20);
        ageField = new JTextField(20);
        saveButton = new JButton("Save");
        loadButton = new JButton("Load");

        saveButton.addActionListener(this);
        loadButton.addActionListener(this);

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
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());

            try {
                statement.executeUpdate("INSERT INTO human (name, age) VALUES ('" + name + "', " + age + ")");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == loadButton) {
            try {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM human");
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    System.out.println("Name: " + name + ", Age: " + age);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Assi_16().setVisible(true);
        });
    }
}