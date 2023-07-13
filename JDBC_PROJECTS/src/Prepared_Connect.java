import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Prepared_Connect {
    public static void seeTable () {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        try {
        connection = JdbcUtil.getJdbcConnection();
        System.out.println("Connection Established");
        if ( connection != null ) {
            String sqlQuery = "select id,Name,city from Employee";
            stmt = connection.prepareStatement(sqlQuery);
        }
        if ( stmt != null ) {
            resultSet = stmt.executeQuery();
            System.out.printf("%s%15s%16s%n", "ID","NAME","CITY");
            System.out.print("");
            while ( resultSet.next() ) {
                System.out.printf("%d%16s%16s%n", 
                resultSet.getInt("id"),
                resultSet.getString("Name"),
                resultSet.getString("city")); 
            }
       }
        } catch ( SQLException se ) {
            se.printStackTrace();
        } catch ( IOException ie ) {
            ie.printStackTrace();
        } finally {
            try {
                JdbcUtil.CloseUp(connection, stmt, resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Connection Closed");
        }
    }
}
