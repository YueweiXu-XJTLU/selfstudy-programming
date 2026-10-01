package P93_Static_Case_UsersNumberCount;

public class User {
    //we need to count how many users have been created
    public static int count; //the count number is shared by the whole class and need only 1 copy, hence using static

    public User() {
        //when call the constructor, count++
        //only when calling class variables in the SAME class, "this" or "calssName" can be omitted
        //this.count++;
        //User.count++;
        count++;
    }
}
