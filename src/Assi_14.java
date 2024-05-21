import java.sql.*;

public class Assi_14{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ITW";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "onkar2814";

    public static void main(String[] args) {
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            createCustomer(connection, "Onkar Shahapurkar", "Solapur", "omi@gmail.com");
            
            readCustomer(connection, 1);
            
            updateCustomer(connection, 1, "Omi");
            
            deleteCustomer(connection, 1);

            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }

    private static void createCustomer(Connection connection, String name, String address, String email) throws SQLException {
        String sql = "INSERT INTO customers (name, address, email) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, address);
            statement.setString(3, email);
            statement.executeUpdate();
            System.out.println("Customer created successfully.");
        }
    }

    private static void readCustomer(Connection connection, int customerId) throws SQLException {
        String sql = "SELECT * FROM customers WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, customerId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Customer ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Address: " + resultSet.getString("address"));
                System.out.println("Email: " + resultSet.getString("email"));
            }
        }
    }

    private static void updateCustomer(Connection connection, int customerId, String newName) throws SQLException {
        String sql = "UPDATE customers SET name = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newName);
            statement.setInt(2, customerId);
            statement.executeUpdate();
            System.out.println("Customer updated successfully.");
        }
    }

    private static void deleteCustomer(Connection connection, int customerId) throws SQLException {
        String sql = "DELETE FROM customers WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, customerId);
            statement.executeUpdate();
            System.out.println("Customer deleted successfully.");
        }
    }
}