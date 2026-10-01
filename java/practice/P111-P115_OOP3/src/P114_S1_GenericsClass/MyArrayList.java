package P114_S1_GenericsClass;

public class MyArrayList<E> {
    //Genetics 泛型: use <E> to ask for specific types of parameters
    //<E> is <Object> by default

    private Object[] arr = new Object[10];
    private int size;

    public boolean add (E e) {
        arr[size++] = e; //use "size++", which means first return than +1\
        return true;
    }

    public E get (int index) {
        return (E) arr[index];
    }
}
