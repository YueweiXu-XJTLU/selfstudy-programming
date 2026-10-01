package P144_DouDiZhu;

public class Card {
    private String number;
    private String color;
    private int value;

    public Card(int value, String color, String number) {
        this.value = value;
        this.color = color;
        this.number = number;
    }

    public Card() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" + color + number + '}';
    }
}
