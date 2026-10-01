package P137_Collection_IteratingOver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class Test {
    public static void main(String[] args) {
        //3 methods to iterating over Collection (for-loop is available only for "List" (implement Collection), which is INDEXED (such as ArrayList))


        Collection<String> c = new ArrayList<>();
        c.add("1");
        c.add("2");
        c.add("3");
        c.add("4");
        c.add("5");

        //1. Iterator Object (迭代器对象)
        Iterator<String> i = c.iterator(); //the Iterator Object automatically point to the 1st element in the collection
        while (i.hasNext()) {
            System.out.println(i.next()); //get current element & point to the next element in the collection
            //better to use only 1 .next() after 1 .hasNext()
        }



        System.out.println("----------");



        //2.Enhanced for-loop (simplified statements of Iterator in essence) (available for both Collection & array)
        for (String s: c) {
            System.out.println(s);
        }


        System.out.println("----------");



        //3.method of Collection: .forEach(), accept an Anonymous Inner Class of Consumer (an interface)
        c.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });




        System.out.println("-----");


        //simplify using Lambda Expressions

        c.forEach((s) -> System.out.println(s));


        System.out.println("-----");

        //here "out" is an object, ".println()" is an instance method

        c.forEach(System.out::println);
    }
}
