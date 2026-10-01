package P150_S1_StreamIntermediateMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        //Stream Intermediate Methods: Stream流中间方法
        List<Student> students = new ArrayList<>();
        Student s1 = new Student("蜘蛛精", 26, 172.5);
        Student s2 = new Student("蜘蛛精", 26, 172.5);
        Student s3 = new Student("紫霞", 23, 167.0);
        Student s4 = new Student("白晶晶", 25, 169.0);
        Student s5 = new Student("牛魔王", 35, 183.3);
        Student s6 = new Student("牛夫人", 34, 168.5);
        Collections.addAll(students, s1, s2, s3, s4, s5, s6);
        System.out.println(students);



        //1. filter(Predicate<? super T> predicate)
        students.stream().filter(s -> s.getAge() < 30)
                .forEach(s -> System.out.print(s.getName() + " ---> " + s.getAge() + " ---> " + s.getHeight() + "///"));



        System.out.println();



        //2. sort(Comparator<? super T> comparator)
        students.stream().sorted((o1, o2) -> o1.getAge() - o2.getAge())
                .forEach(s -> System.out.print(s.getName() + " ---> " + s.getAge() + " ---> " + s.getHeight() + "///"));



        System.out.println();



        //3. limit(Long maxSize): output the "maxSize" number of objects (排序后输出maxSize = 2 个最矮的Student)
        students.stream().sorted((o1, o2) -> Double.compare(o1.getHeight(), o2.getHeight())).limit(2)
                .forEach(s -> System.out.print(s.getName() + " ---> " + s.getAge() + " ---> " + s.getHeight() + "///"));



        System.out.println();



        //4. skip(long n): (排序后输出2个最高的Student)
        students.stream().sorted((o1, o2) -> Double.compare(o1.getHeight(), o2.getHeight())).skip(students.size() - 2)
                .forEach(s -> System.out.print(s.getName() + " ---> " + s.getAge() + " ---> " + s.getHeight() + "///"));



        System.out.println();



        //5. distinct(): Remove duplicates(去重) (need override equals() & hashCode())
        students.stream().distinct()
                .forEach(s -> System.out.print(s.getName() + " ---> " + s.getAge() + " ---> " + s.getHeight() + "///"));



        System.out.println();



        //6. map(Function<? super T, ? extends R> mapper): map(映射) an object to a variable：.map(s -> s.getName()) ==> map(Student::getName) ==> map Student s to String s.getName (replace Student s by String s.getName)
        students.stream().map(Student::getName).distinct()
                .forEach(s -> System.out.print(s + "///"));



        System.out.println();



        //7. concat(Stream a, Stream b): Concat(合并) 2 streams together
        Stream<String> stream1 = Stream.of(new String[]{"张三", "李四"});
        Stream<String> stream2 = Stream.of(new String[]{"张四", "李三"});
        Stream<String> Concatedstream = Stream.concat(stream1, stream2);
        Concatedstream.forEach(System.out::println);
    }
}
