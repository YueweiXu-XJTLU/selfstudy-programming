package P170_PropertiesFiles;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;
import java.util.Set;

public class Test {
    public static void main(String[] args) throws Exception {
        //1.Input .properties files: use "Properties" Object (implements Map<K, V>)
        Properties input_properties = new Properties();

        //2.Manipulate .properties files
        //(1) public void load(InputStream is) OR public void  load(Reader reader)
        input_properties.load(new FileReader("YOUR_INPUT_PROPERTIES_FILE"));

        System.out.println(input_properties);

        //(2) public void getProperty(String key)
        System.out.println(input_properties.getProperty("user1"));

        //(3) public Set<String> stringPropertyNames()
        Set<String> keys = input_properties.stringPropertyNames();
        for (String key : keys) {
            System.out.println(key + " ---> " + input_properties.getProperty(key));
        }

        //3.Output .properties files: use "Properties" Object (implements Map<K, V>)
        Properties output_properties = new Properties();

        //(1) Set contents into the file: public Object setProperty(String key, String value)
        output_properties.setProperty("user1", "EXAMPLE_PASSWORD_1");
        output_properties.setProperty("user2", "EXAMPLE_PASSWORD_2");
        output_properties.setProperty("user3", "EXAMPLE_PASSWORD_3");

        //(2) Store into a certain file (these tubes will close AUTOMATICALLY):
        //public void store(OutputStream os, String comments) OR public void store(Writer w,String comments)
        output_properties.store(new FileWriter("YOUR_OUTPUT_PROPERTIES_FILE"), "userName=password");
    }
}
