package P114_S1_GenericsClass;

public class Test {
    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList();
        System.out.println(myArrayList.add("E = String"));
        System.out.println(myArrayList.get(0).toString());



        //Tips:
        //1.a generic class  can have multiple object type inside <>
        Animal<Cat, Dog, Fish, Fish> zoo = new Animal<>();

        //2.use <E extends SuperClass> can restrict the type of parameters
        Plant<Plant, Tree> garden = new Plant<>(); //fine
//        Plant<Cat, Dog> garden2 = new Plant<>(); //error occurs


    }
}



//Tips:
class Animal<E, T, K, V>{
    public boolean add (E e, T t, K k, V v) {
        return true;
    }
}

class Plant<E extends Plant, T extends Plant> {}

class Cat extends Animal {}
class Dog extends Animal {}
class Fish extends Animal {}
class Tree extends Plant {}
