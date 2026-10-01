package S4_Methods;

public class P60_S2_Case_MissileLauncher {
    public static void main(String[] args) {
        missileLauncher();
        missileLauncher(10);
        missileLauncher(100, 'B');
    }

/*
    public static void missileLauncher() {
        System.out.println("1 missile is launched to area A");
    }

    public static void missileLauncher(int missileNumber) {
        System.out.println(missileNumber + " missile(s) is launched to area A");
    }
*/

    //A more concise statement for the 2 methods above
    // methods are in equal relationship, hence:
    // 1. The order of methods appear do not matter;
    // 2. A method can not be nested into another (except method overloading)
    public static void missileLauncher() {
        missileLauncher(1, 'A'); //call the method below
    }

    public static void missileLauncher(int missileNumber) {
        missileLauncher(missileNumber, 'A'); //call the method below
    }

    public static void missileLauncher(int missileNumber, char launchArea) {
        System.out.println(missileNumber + " missile(s) is launched to area " + launchArea);
    }

}
