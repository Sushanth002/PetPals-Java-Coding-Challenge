package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBPropertyUtil {
	public static String PropertyFile = "database.properties";
    public static String getConnectionString() {
    	Properties properties = new Properties();
        try (InputStream input = DBPropertyUtil.class.getClassLoader().getResourceAsStream(PropertyFile)) {
            properties.load(input);
            return "jdbc:mysql://" +properties.getProperty("hostname") +":" + properties.getProperty("port") +"/" + properties.getProperty("dbname") +"?user=" + properties.getProperty("username") +"&password=root";
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
