package P107_TemplateMethodDesignPattern;

public class Test {
    public static void main(String[] args) {
        Template studentA = new StudentA();
        studentA.write();

        System.out.println("----------");

        Template studentB = new StudentB();
        studentB.write();
    }
}
