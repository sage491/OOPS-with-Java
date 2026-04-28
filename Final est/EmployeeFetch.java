import java sql.Connection;
import java sql.DriverManager;
import java sql.ResultSet;
import java sql.SQLException;
import java sql.Statement;

public class EmployeeFetch {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/yourDatabaseName";
        String dbUser = "yourUsername";
        String dbPassword = "yourPassword";

        connection conn = null;
        statement stmt = null;
        resultSet rs = null;

        try {
            class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)
            stmt = conn.createStatement();
            String sql = "SELECT id, name, position FROM employees";
            resultSet rs = stmt.executeQuery(sql);

            system.out.println("ID\tName\tPosition");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String position = rs.getString("position");
                system.out.println(id + "\t" + name + "\t" + position);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
