import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedDelete {
    public static void deleteRecord() {
        Connection connection = null;
        Scanner scan = new Scanner(System.in);
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtil.getJdbcConnection();
            if (connection != null) {
                String sqlUpdateQuery = "delete from Employee where id = ?";
                preparedStatement = connection.prepareStatement(sqlUpdateQuery);
            }
            if (preparedStatement != null) {
                System.out.println("Enter the record ID::");
                int id = scan.nextInt();

                preparedStatement.setInt(1, id);
                int rows = preparedStatement.executeUpdate();
                System.out.println("Row Updated::" + rows);

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
