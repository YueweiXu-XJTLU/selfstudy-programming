package P151_S4_MyArrayList;

import java.util.Objects;

public class MyArrayList<E> {
    private int len = 10;
    private int currentIndex;
    private Object[] arr;

    //Constructor1
    public MyArrayList(int len) {
        this.len = len;
        arr = new Object[len];
    }

    //Constructor2
    public MyArrayList() {
        arr = new Object[len];
    }

    public boolean add(E e) {
        //Not Empty Check
        if (e == null) return false;

        //Expansion
        if (currentIndex == len) {
            len *= 1.5;
            E[] newArr = (E[])(new Object[len]);
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = (E) arr[i];
            }
            arr = newArr;
        }

        //Add Elements
        arr[currentIndex] = e;
        currentIndex++;
        return true;
    }

    public E get(int index) {
        //Out of bound judging
        if (index < 0 || index >= currentIndex) {
          throw new ArrayIndexOutOfBoundsException(index + " out of bound: " + currentIndex);
        }

        //Get
        return (E)(arr[index]);
    }

    public boolean remove(E e) {
        //Not Empty Check
        if (e == null) return false;

        //Remove
        for (int i = 0; i < arr.length; i++) {
            if (((E)arr[i]).equals(e)) {
                //remove
                arr[i] = null;

                //Move locations
                E[] newArr = (E[])(new Object[len]);
                int k = 0;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] != null) {
                    newArr[k] = (E) arr[j];
                    k++;
                    }
                }
                currentIndex--;
                arr = newArr;

                //Return
                return true;
            }
        }

        //Else: not found
        return false;
    }

    public int size() {
        return currentIndex;
    }

    public void forEach(MyConsumer<E> action) {
        //Not Empty Check
        Objects.requireNonNull(action);

        //Iterate over
        for (int i = 0; i < currentIndex; i++) { //as arr is not necessarily full, we must use normal for-loop here with bound currentIndex instead of arr.length
            action.accept((E) arr[i]);
        }
    }

    @Override
    public String toString() {

        //Append
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < currentIndex - 1; i++) {
            sb.append(arr[i].toString() + ", ");
        }
        sb.append(arr[currentIndex - 1].toString() + "]");

        return sb.toString();
    }
}
