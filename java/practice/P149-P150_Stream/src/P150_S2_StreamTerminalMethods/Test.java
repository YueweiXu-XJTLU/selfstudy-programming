package P150_S2_StreamTerminalMethods;

import P150_S1_StreamIntermediateMethods.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        //Stream Terminal Methods: Stream流终结方法: used for stream termination, do NOT return stream anymore
        List<P150_S1_StreamIntermediateMethods.Student> students = new ArrayList<>();
        Student s1 = new Student("蜘蛛精", 26, 172.5);
        Student s2 = new Student("蜘蛛精", 26, 172.5);
        Student s3 = new Student("紫霞", 23, 167.0);
        Student s4 = new Student("白晶晶", 25, 169.0);
        Student s5 = new Student("牛魔王", 35, 183.3);
        Student s6 = new Student("牛夫人", 34, 168.5);
        Collections.addAll(students, s1, s2, s3, s4, s5, s6);
        System.out.println(students);



        //1. forEach(Consumer action)
        students.stream().filter(s -> s.getAge() < 30)
                .forEach(System.out::println);



        System.out.println("----------");



        //2. count()
        long count = students.stream().filter(s -> s.getAge() < 30)
                .count();
        System.out.println(count);



        System.out.println("----------");



        //3. Optional<T> max(Comparator<? super T> comparator): (then use .get() to receive the object)
        Student studentMax = students.stream()
                .max(((o1, o2) -> Double.compare(o1.getHeight(), o2.getHeight()))).get();
        System.out.println(studentMax);



        System.out.println("----------");



        //4. Optional<T> min(Comparator<? super T> comparator): (then use .get() to receive the object)
        Student studentMin = students.stream()
                .min(((o1, o2) -> Double.compare(o1.getHeight(), o2.getHeight()))).get();
        System.out.println(studentMin);



        System.out.println("----------");



        //5.1 collect(Collector collector): collect(Collectors.toList())//collect(Collectors.toSet()): collect a stream to a Collection
        List<Student> list = students.stream().filter(s -> s.getAge() < 30)
                .collect(Collectors.toList());
        System.out.println(list);

        Set<Student> set = students.stream().filter(s -> s.getAge() < 30)
                .collect(Collectors.toSet());
        System.out.println(set);

//        Stream<Student> Stream = students.stream().filter(s -> s.getAge() < 30);
//        Stream.collect(Collectors.toList());
//        Stream.collect(Collectors.toSet());
//        //NOT AVAILABLE!!!!! a stream can only be collect ONCE



        System.out.println("----------");



        //5.2 collect(Collector collector): collect(Collectors.toMap): collect a stream to a Map (need remove duplicates manually)
        Map<String, Integer> map = students.stream().filter(s -> s.getAge() < 30)
                .distinct()
                .collect(Collectors.toMap(s -> s.getName(), s -> s.getAge()));
        System.out.println(map);



        System.out.println("----------");



        //6. toArray(): collect a stream to an array
//        Object[] array = students.stream().filter(s -> s.getAge() < 30)
//                .toArray();

        //more specific(provide type of array):
//        Student[] array = students.stream().filter(s -> s.getAge() < 30)
//                .toArray(n -> new Student[n]);

        //simplify using Lambda

        Student[] array = students.stream().filter(s -> s.getAge() < 30)
                .toArray(Student[]::new);

        System.out.println(Arrays.toString(array));
    }
}
