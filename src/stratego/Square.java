package stratego;

import stratego.pieces.Piece;

/**
 * It's a Square class which represents a square in the board.
 */
public class Square {
    private Game game;
    private int row, col;
    // whether this square is water square
    private boolean isWater;
    // the piece which is placed on this square
    private Piece piece;

    /**
     * It's a constructor for Square, which set the game which the Square belong to, the indexes of row and column, and whether this square is water.
     * @param game the game which this Square belong to
     * @param row the index of this Square's row
     * @param col the index of this Square's column
     * @param isWater whether this Square is water
     */
    public Square(Game game, int row, int col, boolean isWater) {
        this.game = game;
        this.row = row;
        this.col = col;
        this.isWater = isWater;
        piece = null;
    }

    /**
     * It's a function which places a Piece to this Square.
     * @param piece the Piece needs to be placed
     * @throws IllegalArgumentException thrown if this Square cannot be entered a Piece
     */
    public void placePiece(Piece piece) throws IllegalArgumentException {
        if (!this.canBeEntered()) {
            throw new IllegalArgumentException("This Square had been occupied or is the water");
        }
        this.piece = piece;
    }

    /**
     * It's a function which removes the Piece of this Square.
     */
    public void removePiece() {
        piece = null;
    }

    /**
     * It's a function which returns the game which this Square belongs to.
     * @return the game which this Square belongs to
     */
    public Game getGame() {
        return game;
    }

    /**
     * It's a function which gets the Piece placed in this Square.
     * @return the Piece placed in this Square
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * It's a function which gets the index of this Square's row.
     * @return the index of this Square's row
     */
    public int getRow() {
        return row;
    }

    /**
     * It's a function which gets the index of this Square's column.
     * @return the index of this Square's column
     */
    public int getCol() {
        return col;
    }

    /**
     * It's a function to check if this Square can place a Piece.
     * @return whether the Piece can be placed to this Square
     */
    public boolean canBeEntered() {
        boolean canBeEntered = ((piece == null) && !isWater);
        return canBeEntered;
    }
}
