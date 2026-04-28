import java.sql.*;

//step 2 load driver
public class JDBCConnection{
    private final static String url=""; 1usage
    private final static String userName="root"; 1usage
    private final static String passwords="rooot12345": 1usage

    public static void main(String[] args) throws ClassNotFOundException{
        Class.forName(className: "com.mysql.cj.jdbc.Driver");

         // step 3 create connection
        Connection con= DriveManager.getConnection(url, userName, password);

        //step 4 Create Statement
        Statement stmt= con.createStatement();

        //step 5 
        String query="Select*from students";
        ResultSet rs=stmt.executeQuery(query);

        while(rs.next()){
            int uid=rs.getInt(column.abel: "uid");
            String name=rs.getString(column.abel: "Marks");

            System.out.println(uid+""+name+""+""+marks);
        }

        //Step 6 close connection
        con.close()
    }
}