import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class EmployeeFetch {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/yourDatabaseName";
        String dbUser = "harshitkumaroxford@gmail.com";
        String dbPassword = "Khushi@55";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Load JDBC driver (optional for newer versions of Java)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
            System.out.println("Database connected successfully!");

            // Step 3: Create statement
            statement = connection.createStatement();

            // Step 4: Execute query
            String query = "SELECT emp_id, emp_name, emp_salary FROM employee";
            resultSet = statement.executeQuery(query);

            // Step 5: Process ResultSet
            System.out.println("Employee Records:");
            while (resultSet.next()) {
                int id = resultSet.getInt("emp_id");
                String name = resultSet.getString("emp_name");
                double salary = resultSet.getDouble("emp_salary");

                System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error!");
            e.printStackTrace();
        } finally {
            // Step 6: Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
