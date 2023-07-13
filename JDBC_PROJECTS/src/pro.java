import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class pro {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("D:\\Programming1\\GitServer\\GitWork\\JDBC_PROJECTS\\src\\application.properties");
            Properties p = new Properties();
        try {
            p.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(p.getProperty("url"));
        System.out.println(p.getProperty("user"));
        System.out.println(p.getProperty("password"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }
}
