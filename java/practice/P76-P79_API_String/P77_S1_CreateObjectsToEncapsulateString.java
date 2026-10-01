package S7_String;

public class P77_S1_CreateObjectsToEncapsulateString {
    public static void main(String[] args) {
        //methods to create objects to encapsulate(封装) Strings
        //1. use basic primitive directly
        String name_1 = "name_1";
        System.out.println(name_1);

        //2. call constructor and use "new String()"
         //2.1. create ""
        String blank = new String();
        System.out.println(blank);
         //2.2. create normal Strings
        String name_2 = new String("name_2");
        System.out.println(name_2);
         //2.3. create Strings use char[]
        char[] charArray_1 = {'n', 'a', 'm', 'e', '_', '3'};
        String name_3 = new String(charArray_1);
        System.out.println(name_3);
         //2.4. create String use ASCII inside char[] or byte[]
        char[] charArray_2 = {110, 97, 109, 101, 95, 52};
        String name_4 = new String(charArray_2);
        System.out.println(name_4);
        byte[] byteArray = {110, 97, 109, 101, 95, 53};
        String name_5 = new String(byteArray);
        System.out.println(name_5);

    }
}
