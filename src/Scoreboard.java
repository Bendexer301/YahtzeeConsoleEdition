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

    public void printScoreboard(int index, Player[] players) {
        // header
        Glob.printWithWidth("Index", 6, false);
        Glob.printWithWidth("Category", 17, false);
        for (int i = 0; i < players.length; i++) {
            if (index == i || index == -1)
                Glob.printWithWidth(players[i].getName(), 8, false);
        }
        System.out.println();

        // scores
        for (int i = 0; i < 13; i++) {
            Glob.printWithWidth(String.valueOf(i + 1), 6, false);
            Glob.printWithWidth(String.valueOf(Category.values()[i]), 17, false);
            for (int j = 0; j < players.length; j++) {
                if (index == j || index == -1) {
                    if (scores[i][j] == -1) {
                        Glob.printWithWidth("_", 8, false);
                    } else if (scores[i][j] == -2) {
                        Glob.printWithWidth("X", 8, false);
                    } else {
                        Glob.printWithWidth(String.valueOf(scores[i][j]), 8, false);
                    }
                }
            }
            System.out.println();
        }

    }

    public int calculateScore(int index, int[] dice) {
        int score = 0;
        int[] counts;
        int straight;

        switch (Category.values()[index]) {
            case ACES:
                for (int die : dice) {
                    if (die == 1) {
                        score += 1;
                    }
                }
                break;
            case TWOS:
                for (int die : dice) {
                    if (die == 2) {
                        score += 2;
                    }
                }
                break;
            case THREES:
                for (int die : dice) {
                    if (die == 3) {
                        score += 3;
                    }
                }
                break;
            case FOURS:
                for (int die : dice) {
                    if (die == 4) {
                        score += 4;
                    }
                }
                break;
            case FIVES:
                for (int die : dice) {
                    if (die == 5) {
                        score += 5;
                    }
                }
                break;
            case SIXES:
                for (int die : dice) {
                    if (die == 6) {
                        score += 6;
                    }
                }
                break;
            case THREE_OF_A_KIND:
                counts = new int[6];
                for (int die : dice) {
                    counts[die - 1]++;
                }
                for (int i = 0; i < 6; i++) {
                    if (counts[i] >= 3) {
                        for (int die : dice) {
                            score += die;
                        }
                        break;
                    }
                }
                break;
            case FOUR_OF_A_KIND:
                counts = new int[6];
                for (int die : dice) {
                    counts[die - 1]++;
                }
                for (int i = 0; i < 6; i++) {
                    if (counts[i] >= 4) {
                        for (int die : dice) {
                            score += die;
                        }
                        break;
                    }
                }
                break;
            case FULL_HOUSE:
                counts = new int[6];
                for (int die : dice) {
                    counts[die - 1]++;
                }
                boolean three = false;
                boolean two = false;
                for (int i = 0; i < 6; i++) {
                    if (counts[i] == 3) {
                        three = true;
                    } else if (counts[i] == 2) {
                        two = true;
                    }
                }
                if (three && two) {
                    score = 25;
                }
                break;
            case SMALL_STRAIGHT:
                counts = new int[6];
                for (int die : dice) {
                    counts[die - 1]++;
                }
                straight = 0;
                for (int i = 0; i < 6; i++) {
                    if (counts[i] > 0) {
                        straight++;
                    } else {
                        straight = 0;
                    }
                    if (straight == 4) {
                        score = 30;
                        break;
                    }
                }
                break;
            case LARGE_STRAIGHT:
                counts = new int[6];
                for (int die : dice) {
                    counts[die - 1]++;
                }
                straight = 0;
                for (int i = 0; i < 6; i++) {
                    if (counts[i] > 0) {
                        straight++;
                    } else {
                        straight = 0;
                    }
                    if (straight == 5) {
                        score = 40;
                        break;
                    }
                }
                break;
            case YAHTZEE:
                counts = new int[6];
                for (int die : dice) {
                    counts[die - 1]++;
                }
                for (int i = 0; i < 6; i++) {
                    if (counts[i] == 5) {
                        score = 50;
                        break;
                    }
                }
                break;
            case CHANCE:
                for (int die : dice) {
                    score += die;
                }
                break;
        }
        return score;
    }

    public void setScore(int index, int playerIndex, int score) {
        if (score == 0) {
            scores[index][playerIndex] = -2;
            return;
        }
        scores[index][playerIndex] = score;
    }

    public int getScore(int index, int playerIndex) {
        return scores[index][playerIndex];
    }
}
