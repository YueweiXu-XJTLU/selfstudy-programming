package P144_DouDiZhu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Room {
    private List<Card> allCards = new ArrayList<>();
    private List<Card> diZhuPai = new ArrayList<>();

    //crete players
    private List<Card> player1 = new ArrayList<>();
    private List<Card> player2 = new ArrayList<>();
    private List<Card> player3 = new ArrayList<>();
    private List<Card> diZhu = new ArrayList<>();
    private List<Card> nongMin1 = new ArrayList<>();
    private List<Card> nongMin2 = new ArrayList<>();

    public Room() {
        //normal cards
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        String[] colors = {"♠", "♥", "♦", "♣"};
        int size = 3;
        for (String number : numbers) {
            for (String color : colors) {
                Card c = new Card(size, color, number);
                allCards.add(c);
            }
            size++;
        }

        //jokers
        Card smallJoker = new Card(size, "smallJoker", "");
        Card largeJoker = new Card(++size, "largeJoker", "");

        //add all cards together
        Collections.addAll(allCards, smallJoker, largeJoker);

        //show all cards
        System.out.println("一副新牌:" + allCards);
    }

    public void start() {
        //shuffle
        Collections.shuffle(allCards);



        //sending cards
        for (int i = 0; i < allCards.size() - 3; i++) {
            switch (i % 3) {
                case 0:
                    player1.add(allCards.get(i));
                    break;
                case 1:
                    player2.add(allCards.get(i));
                    break;
                case 2:
                    player3.add(allCards.get(i));
                    break;
            }
        }

        //sequence for players
        Collections.sort(player1, (o1, o2) -> o1.getValue() - o2.getValue());
        Collections.sort(player2, (o1, o2) -> o1.getValue() - o2.getValue());
        Collections.sort(player3, (o1, o2) -> o1.getValue() - o2.getValue());

        //watch cards
        System.out.println("player1:" + player1);
        System.out.println("player2:" + player2);
        System.out.println("player3:" + player3);
        diZhuPai.addAll(allCards.subList(allCards.size() - 3, allCards.size()));
        System.out.println("地主牌:" + diZhuPai);
        System.out.println("----------");
    }

    public void qiangDiZhu (int playerNum) {
        switch (playerNum) {
            case 1:
                player1.addAll(diZhuPai);
                diZhu = player1;
                nongMin1 = player2;
                nongMin2 = player3;
                break;
            case 2:
                player2.addAll(diZhuPai);
                diZhu = player2;
                nongMin1 = player1;
                nongMin2 = player3;
                break;
            case 3:
                player3.addAll(diZhuPai);
                diZhu = player3;
                nongMin1 = player1;
                nongMin2 = player2;
                break;
        }

        System.out.println("抢地主完毕:");
        Collections.sort(diZhu, (o1, o2) -> o1.getValue() - o2.getValue());
        Collections.sort(nongMin1, (o1, o2) -> o1.getValue() - o2.getValue());
        Collections.sort(nongMin2, (o1, o2) -> o1.getValue() - o2.getValue());
        System.out.println("地主:" + diZhu);
        System.out.println("农民1:" + nongMin1);
        System.out.println("农民2:" + nongMin2);
    }
}
