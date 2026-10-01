package P114_S2_GenericsInterface;

import java.util.ArrayList;

//Generics Interface
public interface Operator<E> {
    boolean add (E e);
    ArrayList<E> getByName(String name);
}
