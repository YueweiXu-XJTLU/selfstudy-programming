package P149_S2_GetStream;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        //to Get/Create Stream: stream()

        //1.for Collection: stream()
        Collection<String> collection = new ArrayList<>();
        Stream<String> stream1 = collection.stream();

        //2.for Map: casting to Collection, then stream()
        Map<String, Integer> map = new HashMap<>();
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Stream<Map.Entry<String, Integer>> stream2 = entries.stream();

        //3.for array
        String[] array = {"1", "2", "3"};
        //(1)method of Arrays: stream(T[] array)
        Stream<String> stream3 = Arrays.stream(array);
        //(2) method of Stream: of(T... values)
        Stream<String> stream4 = Stream.of(array);
    }
}
