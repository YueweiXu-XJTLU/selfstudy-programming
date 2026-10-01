package P141_Set_HashSetAndLinkedHashSetAndTreeSet;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        //0.Hash Code (哈希值)
        //EVERY OBJECT has its hashCode (an int value), USUALLY unique
        String str1 = "123";
        String str2 = "abc";
        System.out.println(str1.hashCode()); //48690
        System.out.println(str1.hashCode()); //48690
        System.out.println(str2.hashCode()); //96354



        //1.HashCode:
         //Based on Has-Table: Array + Chain-List + Red-Black-Tree(A Self-Balanced Binary-Search-Tree)
         //relatively good for both searching and adding&removing

        //is we want objects with same CONTAINS to be defined as equal objets, we need to override .equals() & .hashCode()
        Student s1 = new Student("San.Zhang", 20);
        Student s2 = new Student("San.Zhang", 20);
        Student s3 = new Student("Si.Li", 19);
        Student s4 = new Student("Wu.Wang", 19);

        Set<Student> hs = new HashSet<>();
        hs.add(s1);
        hs.add(s2);
        hs.add(s3);
        hs.add(s4);
        System.out.println(hs); //[Student{name='Si.Li', age=19}, Student{name='Wu.Wang', age=19}, Student{name='San.Zhang', age=20}]



        //2.LinkedHashCode:
         //Based on Has-Table + Doubly-Chain-List



        //3.TreeSet
         //sequencing based on another Red-Black-Tree, Objects usually need to create compare-rules

        //write compare-rules:
        //method1:
        //Student implements Comparable<Student> & @Override public int compareTo(Student o) {}
        Set<Student> ts1 = new TreeSet<>();
        ts1.add(s1);
        ts1.add(s2);
        ts1.add(s3);
        //!!! based on the extra Red-Black-Tree, if the variable we compare is identical, the one of the Objects will be omitted
        //if we do not desire the omitting, in the rule of "o2.getAge() - o1.getAge() = 0", we "return 1/-1"
        System.out.println(ts1); //[Student{name='Si.Li', age=19}, Student{name='San.Zhang', age=20}]

        //method2:
        Set<Student> ts2 = new TreeSet<>((o1, o2) -> o2.getAge() - o1.getAge());
        ts2.add(s1);
        ts2.add(s2);
        ts2.add(s3);
        //!!! based on the extra Red-Black-Tree, if the variable we compare is identical, the one of the Objects will be omitted
        //if we do not desire the omitting, in the rule of "o2.getAge() - o1.getAge() = 0", we "return 1/-1"
        System.out.println(ts2); //[Student{name='San.Zhang', age=20}, Student{name='Si.Li', age=19}]

        //if both "implement Comparable" & "Comparator" exist, TreeSet will use the NEARER rule (Comparator)
    }
}
