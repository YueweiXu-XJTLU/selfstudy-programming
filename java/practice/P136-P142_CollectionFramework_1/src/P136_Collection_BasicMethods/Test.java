package P136_Collection_BasicMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Test {
    public static void main(String[] args) {
        //Collection is an interface with various implementation classes, such as ArrayList

        //Basic methods of Collection (Hence all its implementation classes)
        Collection<String> c1 = new ArrayList<>();

        //1: .add()
        c1.add("java1");
        c1.add("java1");
        c1.add("java2");
        c1.add("java3");
        System.out.println(c1); //[java1, java1, java2, java3]
        //ArrayList:

        //2: .addAll() (Copy data form another Collection to add to the original Collection) (GENERIC type must be the same)
        Collection<String> c2 = new ArrayList<>();
        c2.add("1");
        c2.add("2");

        c1.addAll(c2);
        System.out.println(c1); //[java1, java1, java2, java3, 1, 2]
        System.out.println(c2); //[1, 2]

        //3: .isEmpty()
        System.out.println(c1.isEmpty()); //false

        //4: .size()
        System.out.println(c1.size()); //6


        //5: .contains() (Case Sensitive)
        System.out.println(c1.contains("java1")); //true
        System.out.println(c1.contains("JAVA1")); //false

        //6: .remove()
        c1.remove("java1");
        System.out.println(c1); //[java1, java2, java3, 1, 2]

        //7: .toArray()
        Object[] o = c1.toArray(); //usually casting to Object[]
        System.out.println(Arrays.toString(o)); //[java1, java2, java3, 1, 2]
        String[] s = c1.toArray(new String[c1.size()]);
        System.out.println(Arrays.toString(s)); //[java1, java2, java3, 1, 2]

        //8: .clear()
        c1.clear();
        System.out.println(c1); //[]
        System.out.println(c1.size()); //0
        System.out.println(c1.isEmpty()); //true
    }
}