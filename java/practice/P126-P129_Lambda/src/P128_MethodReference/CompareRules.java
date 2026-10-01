package P128_MethodReference;

public class CompareRules {
    public static int compareByAge_Static(Student o1, Student o2) {return o1.age - o2.age;}

    public int compareByAge_Instance(Student o1, Student o2) {return o1.age - o2.age;}
}
