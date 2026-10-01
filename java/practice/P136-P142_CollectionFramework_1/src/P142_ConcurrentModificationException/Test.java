package P142_ConcurrentModificationException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //Concurrent Modification Exception (并发修改异常)

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("26");
        list.add("31");
        list.add("16");
        list.add("54");
        list.add("86");
        list.add("166");
        list.add("13");
        //we need to remove all element contain "6"



        //Example of ConcurrentModificationException:
        //1.
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String needRemove = iterator.next();
//            if (needRemove.contains("6")) {
//                list.remove(needRemove);
//            }
//        }
//        System.out.println(list);
//        //ConcurrentModificationException occurs

        //2.
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("6")) {
                list.remove(list.get(i));
            }
        }
        System.out.println(list); //[1, 31, 54, 166, 13]
        //incorrectly removing due to ConcurrentModificationException



        //Reason: upon removing, the index is still increasing, hence some elements are omitted for adjusting



        //Methods:
        //1. BEST
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String needRemove = iterator.next();
            if (needRemove.contains("6")) {
                iterator.remove(); //call method ".remove()" of the ITERATOR
            }
        }
        System.out.println(list); //[1, 31, 54, 13]

        //2.
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("6")) {
                list.remove(list.get(i));
                i--; //recover the indices
            }
        }
        System.out.println(list); //[1, 31, 54, 13]

        //3.
        for (int i = list.size() - 1; i <= 0; i--) { //iterate over REVERSELY
            if (list.get(i).contains("6")) {
                list.remove(list.get(i));
            }
        }
        System.out.println(list); //[1, 31, 54, 13]



        //!!! Enhanced-for-loop & .forEach CANNOT solve this problem
    }
}
