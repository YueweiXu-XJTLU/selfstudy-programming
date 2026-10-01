package P145_Map;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        //Map<K, V> (Interface): store Key-Value pairs
        //Key & Value corresponding to each other
        //Keys are not repeatable
        //Values are repeatable

        //methods of Map
        Map<String, Integer> map = new HashMap<>();

        //1. put()
        map.put("watch", 220); //be covered by next "map.put("watch", 100);"
        map.put("watch", 100);
        map.put("phone", 2);
        map.put("java", 2);
        System.out.println(map); //{java=2, watch=100, phone=2}

        //2. size()
        System.out.println(map.size()); //3

        //3. get(Object key) : get value using key
        int v1 = map.get("java");
        System.out.println(v1); //2
        System.out.println(map.get("666666")); //null

        //4. remove(Object key) : remove and return the value of the removed key
        System.out.println(map.remove("watch")); //100
        System.out.println(map); //{java=2, phone=2}

        //5. containsKey(Object key)
        System.out.println(map.containsKey("watch")); //false

        //6. containsValue(Object value)
        System.out.println(map.containsValue(2)); //true
        System.out.println(map.containsValue("2")); //false

        //7. keySet(): return a Set of all keys (NOT-sequential;NOT-indexed;NOT-repeatable)
        Set<String> keys = map.keySet();
        System.out.println(keys); //[java, phone]

        //8. values() : return a Collection of all values (repeatable)
        Collection<Integer> values = map.values();
        System.out.println(values); //[2, 2]

        //9. putAll(Map map)
        Map<String, Integer> map1 = new HashMap();
        map1.put("java1", 1);
        map1.put("java2", 2);
        map1.put("java3", 3);
        map.putAll(map1);
        System.out.println(map1); //{java3=3, java2=2, java1=1}
        System.out.println(map); //{java3=3, java=2, java2=2, phone=2, java1=1}

        //10. clear()
        map.clear();
        System.out.println(map); //{}

        //11. isEmpty()
        System.out.println(map.isEmpty()); //true



        System.out.println("----------");



        //1. HashMap<K, V> implements Map<K, V>: NOT-sequential;NOT-indexed;NOT-repeatable
        Map<String, Integer> hm = new HashMap<>();
        hm.put("San.Zhang", 18);
        hm.put("Si.Li", 20);
        hm.put("Wu.Wang", 19);
        hm.put(null, null);
        System.out.println(hm); //NOT-sequential

        //2.LinkedHashMap<K, V> implements HashMap<K, V>: sequential;NOT-indexed;NOT-repeatable
        Map<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("San.Zhang", 18);
        lhm.put("Si.Li", 20);
        lhm.put("Wu.Wang", 19);
        System.out.println(lhm); //sequential

        //3.TreeMap<K, V> implements Map<K, V>: sequential-ABLE(ascending by default);NOT-indexed;NOT-repeatable
        Map<Integer, String> tm = new TreeMap<>();
        tm.put(20, "San.Zhang");
        tm.put(23, "Si.Li");
        tm.put(17, "Wu.Wang");
        System.out.println(tm); //sequential-ABLE(ascending by default)
    }
}
