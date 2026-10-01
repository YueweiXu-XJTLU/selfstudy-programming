package P112_S2_Case_AnonymousInnerClass;

public class Test {
    public static void main(String[] args) {
//        Runner runner1 = new Runner() {
//            @Override
//            public void run() {
//                System.out.println("Runner1 is running!");
//            }
//        };
//
//        Runner runner2 = new Runner() {
//            @Override
//            public void run() {
//                System.out.println("Runner2 is running!");
//            }
//        };
//
//        GameStart(runner1, runner2);

        //use Anonymous Inner Class to pass parameters:
        GameStart(new Runner() {
            @Override
            public void run() {
                System.out.println("Runner1 is running!");
            }
        }
        ,
                new Runner() {
            @Override
            public void run() {
                System.out.println("Runner2 is running!");
            }
        }
        );


    }
    public static void GameStart(Runner r1, Runner r2) {
        System.out.println("Game Start!");
        r1.run();
        r2.run();
    }
}
