import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedInsert {
    public static void insertTable() {
        Connection connection = null;
        Scanner scan = new Scanner(System.in);
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getJdbcConnection();
            System.out.println("Connection Established...");
            if (connection != null) {
                preparedStatement = connection
                        .prepareStatement("insert into Employee(`id`,`Name`,`city`)values(?,?,?)");
            }
            if (preparedStatement != null) {
                System.out.println("Enter ID::");
                int id = scan.nextInt();
                System.out.println("Enter Name::");
                String Name = scan.next();
                System.out.println("Enter City");
                String city = scan.next();

                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, Name);
                preparedStatement.setString(3, city);
                int record = preparedStatement.executeUpdate(); // This is Mandatory
                System.out.println("Records Inserted:: " + record);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtil.CloseUp(connection, preparedStatement, null);
                scan.close();
                System.out.println("Connection Closed...");
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }
}
