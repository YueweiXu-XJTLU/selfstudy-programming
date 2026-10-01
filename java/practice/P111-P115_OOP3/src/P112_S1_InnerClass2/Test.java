package P112_S1_InnerClass2;

public class Test {
    public static void main(String[] args) {
        //4.Anonymous Inner Class 匿名内部类: a type of Local Inner Class:
        //no need to state name for the SubClass, directly override the class body when creating the object
        Animal cat = new Animal() {
          @Override
          public void cry() {
              System.out.println("miao~");
          }
      };

       cat.cry();
    }
}

abstract class Animal {
    public abstract void cry();
}

