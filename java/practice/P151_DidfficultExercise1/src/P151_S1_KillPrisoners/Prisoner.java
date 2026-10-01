package P151_S1_KillPrisoners;

public class Prisoner {
    private int position;
    private int number;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Prisoner() {
    }

    public Prisoner(int position, int number) {
        this.position = position;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Prisoner{" +
                "position=" + position +
                ", number=" + number +
                '}';
    }
}
