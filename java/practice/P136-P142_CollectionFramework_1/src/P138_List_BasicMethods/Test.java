package P138_List_BasicMethods;

import java.util.ArrayList;
import java.util.List;


public class Test {

    public static void main(String[] args) {
        //List: an interface & sequential;indexed;repeatable
        //ArrayList implement List
        //LinkedList implement List

        List<String> l = new ArrayList<>();
        l.add("1");
        l.add("2");
        l.add("3");
        l.add("4");
        l.add("5");
        System.out.println(l); //[1, 2, 3, 4, 5]

        //Basic methods of List (related to indices)
        //1.add
        l.add(2, "2.5");
        System.out.println(l); //[1, 2, 2.5, 3, 4, 5]

        //2.remove
        l.remove(2);
        System.out.println(l); //[1, 2, 3, 4, 5]

        //3.set
        l.set(2, "2.5");
        System.out.println(l); //[1, 2, 2.5, 4, 5]

        //4.get
        System.out.println(l.get(2)); //2.5
    }
}
