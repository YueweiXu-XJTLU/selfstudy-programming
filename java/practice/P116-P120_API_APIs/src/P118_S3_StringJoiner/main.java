package P118_S3_StringJoiner;

import java.util.StringJoiner;

public class main {
    public static void main(String[] args) {
        //StringJoiner

        StringJoiner sj1 = new StringJoiner(", "); //set delimiter
        StringJoiner sj2 = new StringJoiner(", ", "[", "]"); //set delimiter & prefix & suffix

        //1. .add()
        sj1.add("java1").add("java2").add("java3"); //only String-type-data is available here //chain programming is available
        System.out.println(sj1);

        sj2.add("java1").add("java2").add("java3");
        System.out.println(sj2);

        //2. .length()
        System.out.println(sj1.length());
        String s = sj1.toString();

        //3. .toString(): change StringBuilder object into String object
        System.out.println(s);
    }
}
