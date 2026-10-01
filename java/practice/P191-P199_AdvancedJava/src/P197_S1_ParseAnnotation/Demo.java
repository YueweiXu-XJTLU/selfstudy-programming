package P197_S1_ParseAnnotation;

@MyTest(value = "value1", aaa = 1, bbb = {"bbb1.1", "bbb1.2"})
public class Demo {
    @MyTest(value = "value2", aaa = 2, bbb = {"bbb2.1", "bbb2.2"})
    public static void test1() {}
}
