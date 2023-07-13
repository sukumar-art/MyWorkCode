import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class JdbcUtil {
    private JdbcUtil () {
        
    }
    public static Connection getJdbcConnection () throws SQLException, IOException {
    
        FileInputStream fis = new FileInputStream("D:\\Programming1\\GitServer\\GitWork\\JDBC_PROJECTS\\src\\application.properties");
        Properties pt = new Properties();
        pt.load(fis);
        Connection connection = DriverManager.getConnection(
            pt.getProperty("url"), 
            pt.getProperty("user"), 
            pt.getProperty("password"));
            return connection;
    }
    public static void CloseUp (Connection con, Statement stmt, ResultSet rs) throws SQLException {
        if ( con != null ) {
            con.close();
        }
        if ( stmt != null ) {
            stmt.close();
        }
        if ( rs != null ) {
            rs.close();
        }
    }
}

// import java.io.FileInputStream;
// import java.io.IOException;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.Properties;

// public class JdbcUtil {
//     private JdbcUtil () {  //This Private Constructor is to avoid creating the class for this Object

//     }
//     public static Connection getJdbcConnection () throws SQLException, IOException {
//         //Establish the Connection
//         FileInputStream fis = new FileInputStream("D:\\Programming\\ProgrammingCodes\\JDBC\\src\\PropertiesClass\\application.properties");
//         Properties properties = new Properties();
//         properties.load(fis);
        
//         Connection connection = DriverManager.getConnection(properties.getProperty("url"), 
//         properties.getProperty("user"), 
//         properties.getProperty("password"));
//         return connection;
//     }
//     public static void CloseUp ( Connection con, Statement statement, ResultSet resultSet) throws SQLException {
//         if ( con != null ) {
//             con.close();
//         }
//         if ( statement != null ) {
//             statement.close();
//         }
//         if ( resultSet != null ) {
//             resultSet.close();
//         }
//     }
// }

