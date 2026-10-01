package P100_Inheritance_AccessModifier;

public class Test {
    public static void main(String[] args) {
        //Access Modifier 权限修饰符

        //public > protected > (null) > private

        //Access inside     thisClass     classInSamePackage     SubClassInAnyPackage     AnyClass
        //private              Yes;              No;                       No;                No;
        //protected            Yes;              Yes;                      No;                No;
        //(null)               Yes;              Yes;                      Yes;               No;
        //public               Yes;              Yes;                      Yes;               Yes;

        //Can access in SubClass != Can use object of SubClass to access
        Sub sub = new Sub();
        sub.methodInSub(); //.methodInSub() use the .methodInSuper() : available

        System.out.println("=====");

        sub.methodInSuper(); //without override : in-available
    }
}
