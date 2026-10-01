package P162_S3_Case_ChangeLineOrder;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(new FileReader("P152-P168\\src\\P162_S3_Case_ChangeLineOrder\\1.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("P152-P168\\src\\P162_S3_Case_ChangeLineOrder\\2.txt"));
                ){
            //Read data into an ArrayList
            ArrayList<String> AL = new ArrayList<>();
            String line = new String();
            while ((line = br.readLine()) != null) {
                AL.add(line);
            }

            //sorting
            Collections.sort(AL);
            System.out.println(AL);

            //Write
            for (int i = 0; i < AL.size(); i++) {
                bw.write(AL.get(i));
                if (i != AL.size() - 1) {bw.newLine();}
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
