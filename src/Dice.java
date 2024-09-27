public class Dice {

    private int value = 0;


    public int roll() {
        value = (int) (Math.random() * 6) + 1;
        return value;
    }

    public int getValue() {
        return value;
    }
}
