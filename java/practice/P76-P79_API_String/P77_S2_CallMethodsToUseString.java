package S7_String;

public class P77_S2_CallMethodsToUseString {
    public static void main(String[] args) {
        String test = "Hello1_Hello2_Hello3";
                     //01234567890123456789
        //1.length of String
        int length = test.length();
        System.out.println(length);



        System.out.println("--1--");



        //2.extract certain char at given index
        char charAtIndex = test.charAt(0);
        System.out.println(charAtIndex);


        System.out.println("--2--");



        //*** iterate over a String: "nameOfString.length.fori" + Enter
        for (int i = 0; i < test.length(); i++) {
            System.out.print(test.charAt(i));
        }



        System.out.println();
        System.out.println("--3--");



        //3.convert String to char[] (another method to iterate a String)
        char[] convertedFromString  = test.toCharArray();
        for (int i = 0; i < convertedFromString.length; i++) {
            System.out.print(convertedFromString[i]);
        }


        System.out.println();
        System.out.println("--4--");



        //4.compare content of Strings (only for content, not for addresses)
        String Str1 = new String("abcd");
        String Str2 = new String("abcd");
        System.out.println(Str1.equals(Str2)); //true (compare content)
        System.out.println(Str1 == Str2); //false (compare addresses)



        System.out.println("--5--");



        //5.compare Strings ignore cases
        String Str3 = "HELLO";
        String Str4 = "hello";
        System.out.println(Str3.equalsIgnoreCase(Str4)); //true


        System.out.println("--6--");



        //6.extract part of a String (from index1 to (index2)+1)
        System.out.println(test.substring(7, 13)); //String test = "Hello1_Hello2_Hello3";
                                                                  //012345678901234567890
         //!!!!!!!!!![original index, final index)!!!!!!!!!! NOT include final index!!!!!



        System.out.println("--7--");



        //7.extract part of a String (from index1 to end) (include the last char)
        System.out.println(test.substring(14));


        System.out.println("--8--");



        //8.replace part of the String with sth. and return the new String
        String nope = "You are a SB.";
        System.out.println(nope.replace("SB" , "**"));


        System.out.println("--9--");



        //9.adjust if the keywords are contained in the String
        System.out.println(test.contains("Hello")); //true
        System.out.println(test.contains("Bye")); //false


        System.out.println("--10--");



        //10.adjust the initial words  of a String
        String yourName = "张三";
        System.out.println(yourName.startsWith("张")); //true
        System.out.println(yourName.startsWith("李")); //false


        System.out.println("--11--");



        //11.split a String according to certain delimiter, store the split String into a String[] and return it
        String names = "ZhangSan, LiSi, WangWu";
        String[] namesInStringArray = names.split(", ");
        for (int i = 0; i < namesInStringArray.length; i++) {
            System.out.print(namesInStringArray[i] + " ");

        }
    }
}
