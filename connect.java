import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class connect {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter Car Name: ");
        String carName = scanner.nextLine();

        System.out.print("Enter Car Model: ");
        String carModel = scanner.nextLine();

        System.out.print("Enter Car Year: ");
        int carYear = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter Additional Info: ");
        String additionalInfo = scanner.nextLine();

        // JDBC Connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "Jannat962@...";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // SQL query to insert data
            String insertQuery = "INSERT INTO Cars (name, model, year, additionalInfo) VALUES (?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                // Set values for parameters in the prepared statement
                preparedStatement.setString(1, carName);
                preparedStatement.setString(2, carModel);
                preparedStatement.setInt(3, carYear);
                preparedStatement.setString(4, additionalInfo);

                // Execute the insert query
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Data successfully inserted into the database!");
                } else {
                    System.out.println("Failed to insert data into the database.");
                }
            }

            // Close the connection
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
