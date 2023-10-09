package JdbcUtil;

public class JdbcUtil {
    // Avoiding Object Creation
    private JdbcUtil() {

    }

    public static java.sql.Connection getConnection() {
        java.sql.Connection connection = null;
        try {
            // Getting Properties File Credentials
            java.io.FileInputStream fis = new java.io.FileInputStream(
                    "D:\\Programming1\\GitServer\\GitWork\\JDBC_CURD_APP\\src\\JdbcUtil\\application.properties");

            // Getting properties file object
            java.util.Properties p = new java.util.Properties();
            p.load(fis);

            // Creating Jdbc Connection
            connection = java.sql.DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"),
                    p.getProperty("password"));

        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return connection;

    }

    public static void closeUp(java.sql.Connection c, java.sql.PreparedStatement p, java.sql.ResultSet r) {
        if (c != null) {
            try {
                c.close();
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        if (p != null) {
            try {
                p.close();
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        if (r != null) {
            try {
                r.close();
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
