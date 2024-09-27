public class Scoreboard {

    public enum Category {
        ACES, TWOS, THREES, FOURS, FIVES, SIXES, THREE_OF_A_KIND, FOUR_OF_A_KIND, FULL_HOUSE, SMALL_STRAIGHT, LARGE_STRAIGHT, YAHTZEE, CHANCE
    }

    private int[][] scores = new int[13][];

    public Scoreboard(int numPlayers) {
        for (int i = 0; i < 13; i++) {
            scores[i] = new int[numPlayers];
        }

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < numPlayers; j++) {
                scores[i][j] = -1;
            }
        }
    }

    public void printScoreboard(Player[] players) {
        System.out.print("Category\t\t\t");
        for (int i = 0; i < players.length; i++) {
            System.out.print(players[i].getName() + "\t");
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.print(Category.values()[i] + "\t");
            for (int j = 0; j < players.length; j++) {
                if (scores[i][j] == -1) {
                    System.out.print("X\t");
                } else {
                    System.out.print(scores[i][j] + "\t");
                }
            }
            System.out.println();
        }

    }
}
