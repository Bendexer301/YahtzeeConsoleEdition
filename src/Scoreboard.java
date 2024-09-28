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
        // header
        Glob.printWithWidth("Category", 17, false);
        for (int i = 0; i < players.length; i++) {
            Glob.printWithWidth(players[i].getName(), 8, false);
        }
        System.out.println();

        // scores
        for (int i = 0; i < 13; i++) {
            Glob.printWithWidth(String.valueOf(Category.values()[i]), 17, false);
            for (int j = 0; j < players.length; j++) {
                if (scores[i][j] == -1) {
                    Glob.printWithWidth("_", 8, false);
                } else {
                    Glob.printWithWidth(String.valueOf(scores[i][j]), 8, false);
                }
            }
            System.out.println();
        }

    }
}
