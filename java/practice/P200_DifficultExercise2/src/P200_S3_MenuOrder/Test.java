package P200_S3_MenuOrder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        try (
                //1.create a tube for the file
                BufferedReader br = new BufferedReader(new FileReader("YOUR_INPUT_MENU_FILE"));

                //4.use PrintStream which is good for output line by line
                PrintStream ps = new PrintStream("YOUR_OUTPUT_MENU_FILE");
                ){

            //2.read the contents line by line
            List<String> menus = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                menus.add(line);
            }

            //3.sort the lines
            Collections.sort(menus); //for String, automatically sort by first letter, exactly satisfied the requirement

            //4.output
            for (String aLine : menus) {
                System.out.println((aLine.charAt(4) != '0') ? aLine : ("\t" + aLine));
                ps.println((aLine.charAt(4) != '0') ? aLine : ("\t" + aLine));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
