package tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {
    public static String getValue(String key){
        String value="";
        String path = "src/main/resources/config.properties";
        Properties properties = new Properties();
        InputStream inputStream = null;

        try{
            inputStream = new FileInputStream(path);
            properties.load(inputStream);
            value = properties.getProperty(key);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return value;
    }
}
