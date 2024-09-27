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

        scoreboard.printScoreboard(players);
    }
}