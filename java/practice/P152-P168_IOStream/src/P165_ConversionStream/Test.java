package P165_ConversionStream;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        //conversion stream: 转换流
        //deal with unreadable codes in InputStream (字节流): use "InputStreamReader" (extends Reader) to point out the FILES' char set
        //(convert from 字节流 InputStream --> 字符流 Reader)
        try (
                InputStream fis = new FileInputStream("P152-P168\\src\\P164_ConversionStream\\Test.txt");
                Reader isr = new InputStreamReader(fis, "GBK"); //Test.txt is coded in "GBK"
                BufferedReader br = new BufferedReader(isr);

                OutputStream fos = new FileOutputStream("P152-P168\\src\\P164_ConversionStream\\Test2.txt");
                Writer osw = new OutputStreamWriter(fos, "GBK");
                BufferedWriter bw = new BufferedWriter(osw);
                ) {
            String line = new String();
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                bw.write(line);
                bw.newLine();
            }



//            //or: another method for converting when outputting:
//            String str = "V我50";
//            byte[] buffer = str.getBytes("GBK");
//            fos.write(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
