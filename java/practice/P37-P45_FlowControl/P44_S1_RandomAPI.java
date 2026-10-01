package S2_FlowControl;

import java.util.Random; //import the package

public class P44_S1_RandomAPI {
    public static void main(String[] args) {
        Random random = new Random();
        double randomNumber = random.nextDouble(10); //range of the number: [0,10)
        System.out.println(randomNumber);

        //Ctrl+Alt+T : Fill the selected contents to flows
        for (int i = 0; i < 3; i++) {
            int randomInteger = random.nextInt(1); //range of the number: [0,10)
            System.out.println(randomInteger);
        }

        int lowerBound = 20;
        int upperBound = 50;
        int boundRandom = 20 + random.nextInt(upperBound - lowerBound + 1);
        System.out.println(boundRandom);

        //most convenient way
        Random r = new Random();
        int rConvenient =  r.nextInt(10,  21); //[10,21)
        System.out.println(rConvenient);

    }
}
