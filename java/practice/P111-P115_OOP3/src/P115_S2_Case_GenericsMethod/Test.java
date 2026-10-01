package P115_S2_Case_GenericsMethod;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new BMW());
        cars.add(new BENZ());

        ArrayList<BMW> BMWs = new ArrayList<>();
        cars.add(new BMW());
        cars.add(new BMW());

        ArrayList<BENZ> BENZs = new ArrayList<>();
        cars.add(new BENZ());
        cars.add(new BENZ());
    }

    //BENZ & BWM extends, but ArrayList<BENZ>  & ArrayList<BWM> do not extend ArrayList<Car>
    //use Generic Method to solve
    //2 ways
    //1. manually state the <E> (use extends to avoiding unrelated object types)
    public static <E extends Car> void drive1(ArrayList<E> cars) {}

    //2. use WildCards (通配符) ("?" here) for existed genetic class ("ArrayList" here)
    //(use: "extends" for Upper Bounded Wildcards OR  "super" for Lower Bounded Wildcards to avoiding unrelated object types)
    public static void drive2(ArrayList<? extends Car> cars) {}
}

class Car{}
class BMW extends Car{}
class BENZ extends Car{}
