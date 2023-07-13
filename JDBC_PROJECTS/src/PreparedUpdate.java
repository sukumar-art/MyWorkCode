import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedUpdate {
    public static void updateRecord () {
        Connection connection = null;
        Scanner scan = new Scanner(System.in);
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtil.getJdbcConnection();
            if(connection != null ) {
                String sqlUpdateQuery = "update Employee set Name = ? where id = ?";
                preparedStatement = connection.prepareStatement(sqlUpdateQuery);
            }
            if(preparedStatement != null) {
                System.out.println("Enter the record ID::");
                int id =scan.nextInt();
                System.out.println("Enter new Name::");
                String Name = scan.next();
                                
                
                preparedStatement.setString(1, Name);
                preparedStatement.setInt(2, id);
                int rows = preparedStatement.executeUpdate();
                System.out.println("Row Updated::"+rows);
                
            }
            
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } finally {
            try {
                JdbcUtil.CloseUp(connection, preparedStatement, resultSet);
                scan.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
