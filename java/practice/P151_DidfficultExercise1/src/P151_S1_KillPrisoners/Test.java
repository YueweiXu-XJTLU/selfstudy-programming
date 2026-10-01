package P151_S1_KillPrisoners;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static List<Prisoner> prisoners = new ArrayList<>();

    public static void main(String[] args) {
        //1. set prisoners' positions & numbers
        int random;

        for (int i = 0; i <= 99 ; i++) {
            random = 1 + (int) (Math.random() * 200); //1 + [0, 200)
            if (notRepeated(random)) {
               prisoners.add(new Prisoner(i + 1, random));
            } else {
                i--;
            }
        }

        System.out.println(prisoners);


        //2. remove prisoners in odd position
        while (prisoners.size() != 1) {
            //we need to remove oddPosition, hence LEAVE EVEN everytime
            List<Prisoner> survivalPrisoners = new ArrayList<>();

            for (int i = 1; i < prisoners.size(); i += 2) {
                survivalPrisoners.add(prisoners.get(i));
            }
            prisoners = survivalPrisoners;
//            survivalPrisoners.clear(); //As "prisoners = survivalPrisoners;" assign the ADDRESS, we must use "prisoners = new ArrayList(survivalPrisoners));" before using .clear()
                                         //but if we create a new survivalPrisoner at each loop, we do not need to clear it everytime

            System.out.println(prisoners);
        }


        System.out.println("The Lucky Dog: position: " + prisoners.get(0).getPosition() + " ; number: " + prisoners.get(0).getNumber());
    }



    public static boolean notRepeated(int randomNumber) {
        boolean notRepeated = true;
        for (Prisoner prisoner : prisoners) {
            if (prisoner.getNumber() == randomNumber) {
                return false;
            }
        }
        return true;
    }
}
