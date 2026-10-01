package P107_TemplateMethodDesignPattern;

public abstract class Template {
    //usage of abstract class:
    //Template Method Design Pattern (模板方法设计模式):

    //usage: deal with redundant coding repetition

    //procedures:
    //1. create an abstract class

    //2. define a template method (not abstract)
    public final void write() { //use "final" to prevent it from being overridden by subclasses
        System.out.println("-----");
        System.out.println("写一篇作文：");
        System.out.println("开头");
        System.out.println(abstractWrite());
        System.out.println("结尾");
        System.out.println("-----");
    }

    //3. define abstract methods
    public abstract String abstractWrite();
}
