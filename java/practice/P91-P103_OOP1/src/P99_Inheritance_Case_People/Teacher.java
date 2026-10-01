package P99_Inheritance_Case_People;

public class Teacher extends People {
    private String skill;

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void printInfo() {
        System.out.println("Information of this teacher:");
        System.out.println("Name: " + getName()); //Use getter as the variable is private in SuperClass
        System.out.println("Skill: " + skill); //Use the variable name directly inside the same method
    }
}
