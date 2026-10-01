package P149_S1_BasicCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("123java");
        list.add("123java");
        list.add("123java");
        list.add("java123");
        list.add("java123");
        list.add("java12");
        Collections.addAll(list, "666java1", "666java2", "java1", "java2", "java3", "java");
        System.out.println(list); //[123java, 123java, 123java, java123, java123, java12, 666java1, 666java2, java1, java2, java3, java]

        //to filter out all elements star with "java" && have length of 5

        //Previous way:
        List<String> list1 = new ArrayList<>();
        for (String s : list) {
            if (s.startsWith("java") && s.length() == 5) {
                list1.add(s);
            }
        }
        System.out.println(list1); //[java1, java2, java3]

        //Use Stream:
        List<String> list2 = list.stream().filter(s -> s.startsWith("java")).filter(s -> s.length() == 5).collect(Collectors.toList());
        System.out.println(list2); //[java1, java2, java3]
    }
}
