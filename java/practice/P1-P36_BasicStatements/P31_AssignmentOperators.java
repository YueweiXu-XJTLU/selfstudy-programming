package S1_BasicStatements;

public class P31_AssignmentOperators {
    public static void main(String[] args) {
        //Assignment Operator 赋值运算符
        //1. =
        //2. +=; -=, ...
        //+=等扩展赋值运算符：a += b 时隐含了将类型强制转换为a: a += b <=> a = (type of a) (a + b)
        int a = 1;
        a += 2.0; //a = (int) (a + 2.0)
        System.out.println("a=" + a); //a=3
        //该性质的运用：
        byte x = 1;
        byte y = 2;
        //x = x + y; //这里会报错，因为x + y时自动将类型提升为int，但x仍是byte类型
        x += y; //但是+=将结果强制转换为x的类型（byte）
        System.out.println("x=" + x); //x=3
    }


}
