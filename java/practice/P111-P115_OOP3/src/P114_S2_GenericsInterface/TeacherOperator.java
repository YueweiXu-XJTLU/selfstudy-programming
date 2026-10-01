package P114_S2_GenericsInterface;

import java.util.ArrayList;

public class TeacherOperator implements Operator<Teacher> {

    @Override
    public boolean add(Teacher teacher) {
        return false;
    }

    @Override
    public ArrayList<Teacher> getByName(String name) {
        return null;
    }
}
