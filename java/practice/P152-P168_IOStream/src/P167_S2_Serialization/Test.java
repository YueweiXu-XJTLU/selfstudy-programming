package P167_S2_Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Test {
    //serialization (序列化): write java object into files
    //anti-serialization (反序列化): read java object from files

    //ObjectOutputStream (对象字节输出流)(序列化流): extends OutputStream
    public static void main(String[] args) {
        try (
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("P152-P168\\src\\P167_S2_Serialization\\Test.txt"));
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("P152-P168\\src\\P167_S2_Serialization\\Test.txt"));

                ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("P152-P168\\src\\P167_S2_Serialization\\Test2.txt"));
                ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("P152-P168\\src\\P167_S2_Serialization\\Test2.txt"));
                ) {
            User u = new User("San.Zhang", 20, "EXAMPLE_PASSWORD_A");
            System.out.println(u.toString());
            //the object to be serialized must "implements Serializable"
            oos.writeObject(u);

            //ois.readObject(); return an "Object" object, we then need to cast it into the object we want
            User u2 = (User) ois.readObject();
            System.out.println(u2.toString()); //with "transient", "password" is not serialized (output null)

            System.out.println("==========");

            //serialize multiple objects: use ArrayList which implements serializable
            User u3 = new User("Si.Li", 23, "EXAMPLE_PASSWORD_B");
            User u4 = new User("Wu.Wang", 54, "EXAMPLE_PASSWORD_C");
            ArrayList<User> AL = new ArrayList<>();
            AL.add(u3);
            AL.add(u4);
            System.out.println(AL);

            oos2.writeObject(AL);
            ArrayList<User> AL2 = (ArrayList)(ois2.readObject());
            System.out.println(AL2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
