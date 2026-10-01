package P167_S1_DataInput_OutputStream;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        //DataInputStream 数据输入流 (extends InputStream) : Input data WITH ITS DATATYPE

        try (
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("P152-P168\\src\\P167_S1_DataInput_OutputStream\\Test.txt"));
                DataInputStream dis = new DataInputStream(new FileInputStream("P152-P168\\src\\P167_S1_DataInput_OutputStream\\Test.txt"))
        ) {
            dos.writeInt(10);
            dos.writeDouble(23.3);
            dos.writeBoolean(true);
            dos.writeUTF("V我50");

            int i = dis.readInt();
            System.out.println(i);
            double d = dis.readDouble();
            System.out.println(d);
            boolean b = dis.readBoolean();
            System.out.println(b);
            String s = dis.readUTF();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
