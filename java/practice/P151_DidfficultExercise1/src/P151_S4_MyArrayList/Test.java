package P151_S4_MyArrayList;

public class Test {
    public static void main(String[] args) {
        //TEST
        MyArrayList<String> mal = new MyArrayList<>();
        boolean a, b, c, d, e;

        //1.add()
        if (mal.add("abc") && mal.add("def") && mal.add("ghi") && mal.toString().equals("[abc, def, ghi]")) {
            System.out.println("TEST: add(): SUCCESS!");
            a = true;
        } else {
            System.out.println("TEST: add(): FAILED!");
            a = false;
        }

        //2.get()
        if (mal.get(2).equals("ghi")) {
            System.out.println("TEST: get(): SUCCESS!");
            b = true;
        } else {
            System.out.println("TEST: get(): FAILED!");
            b = false;
        }

        //3.size()
        if (mal.size() == 3) {
            System.out.println("TEST: size(): SUCCESS!");
            c = true;
        } else {
            System.out.println("TEST: size(): FAILED!");
            c = false;
        }

        //4.remove()
        if (mal.remove("abc") && mal.toString().equals("[def, ghi]")) {
            System.out.println("TEST: remove(): SUCCESS!");
            d = true;
        } else {
            System.out.println("TEST: remove(): FAILED!");
            d = false;
        }

        //5.forEach()
        StringBuilder sb = new StringBuilder();
        mal.forEach(sb::append);
        if (sb.toString().equals("defghi")) {
            System.out.println("TEST: forEach(): SUCCESS!");
            e = true;
        } else {
            System.out.println("TEST: forEach(): FAILED!");
            e = false;
        }

        //Final Result
        if (a && b && c && d && e) {
            System.out.println("666666:)666666");
        } else {
            System.out.println("NONONO:(NONONO");
        }



//        System.out.println(mal.add("abc")); //true
//        System.out.println(mal.add("def")); //true
//        System.out.println(mal.add("ghi")); //true
//        System.out.println(mal); //[abc, def, ghi]
//
//        System.out.println(mal.get(2)); //ghi
//
//        System.out.println(mal.size()); //3
//
//        System.out.println(mal.remove("abc")); //true
//        System.out.println(mal); //[def, ghi]
//
//        mal.forEach(System.out::print); //defghi
    }
}
