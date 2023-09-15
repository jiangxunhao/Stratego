package stratego;

/**
 * This is a player class which represents the player.
 */
public class Player {
    // the name of this player
    private String name;
    // the player number of this player
    private int playerNumber;
    // the state of whether this player had lost
    private boolean isLost;
    // the game which this player entered
    private Game inGame;
    // the opponent who this player playing with
    private Player opponent;

    /**
     * It's a constructor for Player, which set the name and playerNumber of Player and set the variable--isLost false.
     * @param name the name of Player
     * @param playerNumber the player number of Player
     */
    public Player(String name, int playerNumber) {
        this.name = name;
        this.playerNumber = playerNumber;
        isLost = false;
    }

    /**
     * It's a function which gets the name of the Player.
     * @return the name of the Player
     */
    public String getName() {
        return name;
    }

    /**
     * It's a function which gets the playerNumber of the Player.
     * @return the player number
     */
    public int getPlayerNumber() {
        return playerNumber;
    }

    /**
     * It's a function which sets the game which the player joins and the opponent whom the player plays with.
     * @param inGame the game which player joined
     * @param opponent the opponent whom player plays with
     */
    public void setGame(Game inGame, Player opponent) {
        this.inGame = inGame;
        this.opponent = opponent;
    }

    /**
     * It's a function which sets the Player lost the game.
     */
    public void loseGame() {
        isLost = true;
        // If this player have joined a game, set opponent as winner
        if (inGame != null) {
            inGame.setWinner(opponent);
        }
    }

    /**
     * It's a function which gets whether the Player has lost.
     * @return the state of whether the Player has lost
     */
    public boolean hasLost() {
        return isLost;
    }
}
