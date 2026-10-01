package S8_ArrayList;

import java.util.ArrayList;

public class P80_ArrayListOutline {
    public static void main(String[] args) {
        System.out.println("--1--");
        //1.Construct & add
        ArrayList AL1 = new ArrayList(); //No parameters: an ArrayList with 10 empty elements by default
        AL1.add("ABC"); //add an element to enf of the arrayList
        AL1.add(1);
        System.out.println(AL1); //ArrayList is a reference data type, but can directly sout
        System.out.println("-----");
        ArrayList<String> AL2 = new ArrayList<String>(); //define with data type (Generics 泛型) to restrain the data type (primitive data types are not permitted)
        AL2.add("000");
        AL2.add("111");
        AL2.add("222");
        System.out.println(AL2);
        AL2.add(2,"111");
        System.out.println(AL2); //Elements before index keep the same; after index get the new index of originalIndex+1

        System.out.println("--2--");

        //2.Get the element at certain index
        System.out.println(AL2.get(3));

        System.out.println("--3--");

        //3.Return size of ArrayList (number of non-empty elements)
        System.out.println(AL1.size());
        System.out.println(AL2.size());

        System.out.println("--4--");

        //4.remove element at index and return the removed element
        System.out.println(AL2.remove(2));
        System.out.println(AL2);

        System.out.println("--5--");

        //5.remove the given element (first one found from left to right) and return true/false to represent if successfully remove
        AL2.add("111");
        System.out.println(AL2.remove("111"));
        System.out.println(AL2);
        System.out.println(AL2.remove("111"));
        System.out.println(AL2);
        System.out.println(AL2.remove("111"));
        System.out.println(AL2);

        System.out.println("--6--");

        //6.remove an element at index and return the replaced element
        System.out.println(AL2.set(0, "666"));
        System.out.println(AL2);

    }
}
