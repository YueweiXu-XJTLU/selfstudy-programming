package P114_S2_GenericsInterface;

import java.util.ArrayList;

public class StudentOperator implements Operator<Student> { //Specify the object type here

    @Override
    public boolean add(Student student) {
        return false;
    }

    @Override
    public ArrayList<Student> getByName(String name) {
        return null;
    }
}
