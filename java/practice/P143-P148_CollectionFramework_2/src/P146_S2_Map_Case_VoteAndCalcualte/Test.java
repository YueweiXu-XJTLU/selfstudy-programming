package P146_S2_Map_Case_VoteAndCalcualte;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<String> voteResult = new ArrayList<>();
        Map<String, Integer> finalResult = new HashMap<>();

        //vote
        int random;
        String[] options = {"A", "B", "C", "D"};
        for (int i = 1; i <= 800; i++) {
            random = (int)(Math.random() * 4);
            voteResult.add(options[random]);
        }
        System.out.println(voteResult);

        //calculate
        for (String selection : voteResult) {
            if (finalResult.containsKey(selection)) {
                finalResult.put(selection, finalResult.get(selection) + 1);
            } else {
                finalResult.put(selection, 1);
            }
        }

        //show
        System.out.println("Final Result:" + finalResult);
    }
}
