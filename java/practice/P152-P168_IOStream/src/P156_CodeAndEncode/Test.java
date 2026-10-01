package P156_CodeAndEncode;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //Use same character set (字符集) for coding and encoding

        //Code (编码)
        String str1 = "V我50";
        //call a method of String: .getBytes()
        byte[] code1= str1.getBytes();  //non-parameter: return a byte[] by default coding format (UTF-8)
        System.out.println(Arrays.toString(code1)); //1 + 3 + 1 + 1 = 6 bytes

        byte[] code2= str1.getBytes("GBK"); //with parameter: return a byte[] by specific coding format
        //we are forced to throw an Exception here
        System.out.println(Arrays.toString(code2)); //1 + 2 + 1 + 1 = 5 bytes

        //Encode (解码)
        String str2 = new String(code1); //a constructor receive a byte[], encoded by default coding format (UTF-8)
        System.out.println(str2);

        String str3 = new String(code2, "GBK"); //a constructor receive a byte[] and a coding format
        System.out.println(str3);

        String str4 = new String(code2);
        System.out.println(str4); //error occurs (except characters in ASCII format)
    }
}
