/**
 * A class that represents a dice.
 */
public class Dice {

    private int value = 0;

    /**
     * Rolls the dice.
     * @return
     */
    public int roll() {
        value = (int) (Math.random() * 6) + 1;
        return value;
    }

    /**
     * Returns the value of the dice.
     * @return
     */
    public int getValue() {
        return value;
    }
}
