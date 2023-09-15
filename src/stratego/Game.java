package stratego;

/**
 * It's a Game class represents a stratego game which is a strategic board game.
 */
public class Game {
    /**
     * This is the height of this game board.
     */
    public static final int HEIGHT = 10;
    /**
     * This is the width of this game board.
     */
    public static final int WIDTH = 10;
    /**
     * This is the rows of water square.
     */
    public static final int[] WATER_ROWS = {4, 5};
    /**
     * This is the columns of water square.
     */
    public static final int[] WATER_COLS = {2, 3, 6, 7};

    // the two players in this game and the winner
    private Player p0, p1, winner;
    // the first player's number
    private static final int FIRSTPLAYERNUMBER = 0;
    // the first player's number
    private static final int SECONDPLAYERNUMBER = 1;
    // which represents this game board
    private Square[][] squares;

    /**
     * It's a constructor for Game, which initialise all squares and set two Player in this Game.
     * @param p0 the first Player
     * @param p1 the second Player
     */
    public Game(Player p0, Player p1) {
        // represent that two player enter this game
        this.p0 = p0;
        this.p1 = p1;
        p0.setGame(this, p1);
        p1.setGame(this, p0);

        // initial the board
        squares = new Square[WIDTH][HEIGHT];
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if (isWater(i, j)) {
                    squares[i][j] = new Square(this, i, j, true);
                } else {
                    squares[i][j] = new Square(this, i, j, false);
                }
            }
        }
    }

    /**
     * It's a function to check whether the specific square need to be set as the water.
     * @param row the square's index of row which need to be checked
     * @param col the square's index of column which need to be checked
     * @return whether the square need to be set as the water
     */
    public boolean isWater(int row, int col) {
        boolean isWater = false;

        // if a square is in both a water row and a water column
        for (int x : WATER_ROWS) {
            if (x == row) {
                for (int y : WATER_COLS) {
                    if (y == col) {
                        isWater = true;
                    }
                }
            }
        }

        return isWater;
    }

    /**
     * It's a function which gets the Player by the playerNumber.
     * @param playerNumber the player number for the player
     * @return an instance of Player which connects to the playNumber
     * @throws IllegalArgumentException thrown if playerNumber is not 0 or 1
     */
    public Player getPlayer(int playerNumber) throws IllegalArgumentException {
        Player player;

        if (playerNumber == FIRSTPLAYERNUMBER) {
            player = p0;
        } else if (playerNumber == SECONDPLAYERNUMBER) {
            player = p1;
        } else {
            throw new IllegalArgumentException("The player number is illegal, and the valid value is 0 or 1");
        }

        return player;
    }

    /**
     * It's a function which sets the winner in this game.
     * @param player the Player which need to be set as the winner
     */
    public void setWinner(Player player) {
        winner = player;
    }

    /**
     * It's a function which returns this game's winner.
     * @return a Player who won this game
     */
    public Player getWinner() {
        return winner;
    }

    /**
     * It's a function which gets a specific square from the board by the indexes of row and column.
     * @param row the index of row
     * @param col the index of column
     * @return a Square which the indexes of row and column equal to the given
     * @throws IndexOutOfBoundsException thrown if the given indexes of row and column is out of the squares
     */
    public Square getSquare(int row, int col)  {
        if (row < 0 || row >= WIDTH || col < 0 || col >= HEIGHT) {
            throw new IndexOutOfBoundsException("The index of row or col is out of the squares");
        }
        return squares[row][col];
    }
}
