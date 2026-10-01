package P200_S2_VoteForPlace;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        //1.data preparation
        //need to override a constructor, to accept String[] and store into an ArrayList
        Student s1 = new Student("s1", new String[]{"pA", "pC"});
        Student s2 = new Student("s2", new String[]{"pB", "pC", "pD"});
        Student s3 = new Student("s3", new String[]{"pB", "pC"});
        Student s4 = new Student("s4", new String[]{"pB", "pD"});
        Student s5 = new Student("s5", new String[]{"pA"});

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        
        Map<String, Integer> result = new HashMap<>();



        //2.calculation and statistics
        for (Student student : students) {
            List<String> al = student.getPlaces();
            for (String s : al) {
                result.put(s, result.containsKey(s)? result.get(s) + 1 : 1);
            }
        }
        System.out.println(result);
        System.out.println("----------");



        //3.compare and get max <K, V>
        Set<Map.Entry<String, Integer>> entries = result.entrySet(); //Map ---> Collection ---> .stream()
        Optional<Map.Entry<String, Integer>> maxOptional = entries.stream()
                .max(((o1, o2) -> o1.getValue() - o2.getValue())); //.max(comparator) is a terminal method, return an Optional<T> Object
        Map.Entry<String, Integer> max = maxOptional.get(); //call .get() of Optional<> for type casting

        //when several places have same votes are all the max
        List<Map.Entry<String, Integer>> maxPlaces = entries.stream().filter(o -> o.getValue().equals(max.getValue())).collect(Collectors.toList());
        System.out.println(maxPlaces);
        System.out.println("----------");



        //4.output students do not choose the most popular place
        //delete those chose, remain those un-choose
        List<Student> temp = new ArrayList<>();
        temp.addAll(students);
        Iterator<Student> iterator = temp.iterator(); //use Iterator to avoid Concurrent Issues

        First:
        for (Map.Entry<String, Integer> maxPlace : maxPlaces) {
            System.out.println("For " + maxPlace.getKey() + ":");
            Second:
            while (iterator.hasNext()) {
                Student containMax = iterator.next();
                List<String> al = containMax.getPlaces();
                Third:
                for (String s : al) {
                    if (s.equals(maxPlace.getKey())) {
                        iterator.remove();
                        break Third;
                    }
                }
            }
            System.out.println(temp);
            System.out.println("-----");
            //reset temp (ArrayList) & iterator (Iterator) here
            temp.clear();
            temp.addAll(students);
            iterator = temp.iterator();
        }
        System.out.println("----------");
    }
}
