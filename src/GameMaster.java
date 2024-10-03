public class GameMaster {

    private Dice[] dice = new Dice[5];
    private Player[] players;
    private Scoreboard scoreboard;

    public GameMaster() {
        // create the dice
        for (int i = 0; i < 5; i++) {
            dice[i] = new Dice();
        }

        // create the players
        players = new Player[Glob.inputInt("Enter the number of players: ")];

        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(Glob.inputString("Enter the name of player " + (i + 1) + ": "));
        }

        // create the scoreboard
        scoreboard = new Scoreboard(players.length);

        // game loop
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < players.length; j++) {
                System.out.println();
                System.out.print(players[j].getName() + "'s turn. Press enter to roll the dice.");
                Glob.inputString("");
                System.out.println("-:-:-.-._.-:_._.-:-:_. =" + j);

                for (int l = 0; l < 5; l++) {
                    dice[l].roll();
                }

                manageDice();
                changeScoreboard(j);
            }
            scoreboard.printScoreboard(-1, players);
        }
        scoreboard.printWinner(players);
    }

    private void manageDice() {
        for (int k = 0; k < 2; k++) {

            System.out.println("Roll " + (k + 1) + ":");
            for (int l = 0; l < 5; l++) {
                System.out.print(dice[l].getValue() + " ");
            }
            System.out.println();

            while (true) {
                String input = Glob.inputString("");
                boolean valid = true;

                if (input.length() != 5) {
                    valid = false;
                }

                for (int l = 0; l < 5; l++) {
                    if (input.charAt(l) != 'k' && input.charAt(l) != 'r') {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    for (int l = 0; l < 5; l++) {
                        if (input.charAt(l) == 'r') {
                            dice[l].roll();
                        }
                    }
                    break;
                } else {
                    System.out.println("Invalid input. Write k/r (y: keep; r: reroll  e.g. krrkk).");
                }
            }
        }

        System.out.println("Final roll:");
        for (int l = 0; l < 5; l++) {
            System.out.print(dice[l].getValue() + " ");
        }
        System.out.println();
    }

    private void changeScoreboard(int playerIndex) {
        System.out.println("Scoreboard:" + playerIndex);
        scoreboard.printScoreboard(playerIndex, players);

        while (true) {
            int category = Glob.inputInt("Enter the index of the category you want to score: ") - 1;

            if (category < 0 || category > 12) {
                System.out.println("Invalid category. Please enter a number between 1 and 13.");
                continue;
            }

            if (scoreboard.getScore(category, playerIndex) == -1) {
                int[] diceWorth = new int[5];
                for (int i = 0; i < 5; i++) {
                    diceWorth[i] = this.dice[i].getValue();
                }
                int score = scoreboard.calculateScore(category, diceWorth);
                scoreboard.setScore(category, playerIndex, score);
                break;
            } else {
                System.out.println("You have already scored that category. Please choose another.");
            }
        }
    }
}