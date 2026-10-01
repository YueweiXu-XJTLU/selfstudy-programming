package P126_Arrays;

public class Students implements Comparable<Students> {
    @Override
    public int compareTo(Students o) {
        //if return any positive integer, this rank after o
        //if return any negative integer, o rank after this
        //if return 0, no change in order
//        return this.age - o.age; //ascending order
//        return Integer.compare(this.age, o.age); //ascending order
        return o.age - this.age; //descending order
    }

    public String name;
    public int age;

    public Students(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
