package P200_S2_VoteForPlace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
    private String name;
    private List<String> places = new ArrayList<>();

    public Student() {
    }

    public Student(String name, List<String> places) {
        this.name = name;
        this.places = places;
    }

    public Student(String name, String[] places) {
        this.name = name;
        for (String place : places) {
            this.places.add(place);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPlaces() {
        return places;
    }

    public void setPlaces(List<String> places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", places=" + places +
                '}';
    }
}
