package P146_S1_Map_IterateOver;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();
        map.put("San.Zhang", 180.2);
        map.put("Si.Li", 178.3);
        map.put("Wu.Wang", 160.8);
        System.out.println(map); //{Wu.Wang=160.8, Si.Li=178.3, San.Zhang=180.2}

        System.out.println("----------");

        //ways to iterate over Maps

        //1. 键找值: get all keys, then iterate keys to find values
        Set<String> keys = map.keySet();
        for (String key : keys) {
            double value = map.get(key);
            System.out.println(key + " ---> " + value);
        }

        System.out.println("----------");

        //2. 键值对: iterate key-value-pair as a whole
        //use a method of Map: "entrySet();", to encapsulate key-value-pairs into EntryObjects, then add into a Set for enhanced-for-loop input
        Set<Map.Entry<String, Double>> entries = map.entrySet();
        for (Map.Entry<String, Double> entry : entries) {
            String key = entry.getKey();
            double value = entry.getValue();
            System.out.println(key + " ---> " + value);
        }

        System.out.println("----------");

        //3. Lambda Expression: use forEach() method of Map
//        map.forEach(new BiConsumer<String, Double>() {
//            @Override
//            public void accept(String key, Double value) {
//                System.out.println(key + " ---> " + value);
//            }
//        });
        map.forEach((key, value) -> {System.out.println(key + " ---> " + value);});
    }
}
