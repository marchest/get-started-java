package fashion.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utility {

    public static Properties getProp(String fileName) throws FileNotFoundException {
        Properties properties=new Properties();
        InputStream is= new FileInputStream(fileName);
        try {
            if (is ==null){
                System.out.println("deneme");
            }
            properties.load(is);
        }catch (IOException e){
            e.printStackTrace();
        }
        return properties;
    }
}
