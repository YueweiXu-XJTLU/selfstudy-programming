package P148_Map_Case_NestedCollections;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        //Nested Collection 集合的嵌套
        Map<String, Map<String, Set<String>>> province = new HashMap();
        Map<String, Set<String>> city = new HashMap();
        Set<String> region = new HashSet<>();

        region.add("XingBei");
        region.add("TianNing");
        region.add("ZhongLou");

        city.put("SuZhou", null);
        city.put("WuXi", null);
        city.put("ChangZhou", region);

        province.put("JiangSu", city);

        System.out.println(province);

        province.forEach((p, c) -> {
            c.forEach((ci, r) -> {
                if (r == null) {
                    System.out.println(p + " ---> " + ci);
                } else {
                    for (String re : r) {
                        System.out.println(p + " ---> " + ci + " ---> " + re);
                    }
                }
            });
        });
    }
}
