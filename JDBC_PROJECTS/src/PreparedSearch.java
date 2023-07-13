import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedSearch {
    public static void searchRecord () {
        Connection connection = null;
        Scanner scan = new Scanner(System.in);
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtil.getJdbcConnection();
            if(connection != null ) {
                preparedStatement = connection.prepareStatement("select id,Name,city from Employee where id=?");
            }
            if(preparedStatement != null) {
                System.out.println("Enter the record ID::");
                int id =scan.nextInt();
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();
            }
            if(resultSet != null){
                if (resultSet.next()) {                        //No need of WhileLoop, when we have many records then we go for WhileLoop
                System.out.printf("%d%15s%15s",
                resultSet.getInt("id"),
                resultSet.getString("Name"),
                resultSet.getString("city"));
                //preparedStatement.executeQuery();
                } else {
                    System.out.println("Record Not Available");
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtil.CloseUp(connection, preparedStatement, resultSet);
                scan.close();
                System.out.println("\n"+"Connection Closed...");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
