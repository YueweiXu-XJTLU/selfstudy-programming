package P140_Set_BasicMethods;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        //Set: an interface & NOT-sequential;NOT-indexed;NOT-repeatable
        //LinkedHashSet implements HashSet implements Set
        //TreeSet implements Set

        Set<String> hs = new HashSet<>(); //HashSet implements Set: NOT-sequential;NOT-indexed;NOT-repeatable
        hs.add("6");
        hs.add("1");
        hs.add("3");
        hs.add("5");
        hs.add("3");
        hs.add("2");
        hs.add("3");
        hs.add("4");
        System.out.println(hs);

        Set<String> lhs = new LinkedHashSet<>(); //LinkedHashSet implements HashSet: sequential;NOT-indexed;NOT-repeatable
        lhs.add("6");
        lhs.add("1");
        lhs.add("3");
        lhs.add("5");
        lhs.add("3");
        lhs.add("2");
        lhs.add("3");
        lhs.add("4");
        System.out.println(lhs);

        Set<String> ts = new TreeSet<>(); //TreeSet implements Set: sequential-ABLE(ascending by default);NOT-indexed;NOT-repeatable
        ts.add("6");
        ts.add("1");
        ts.add("3");
        ts.add("5");
        ts.add("3");
        ts.add("2");
        ts.add("3");
        ts.add("4");
        System.out.println(ts);

    }
}
