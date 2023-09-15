package stratego.pieces;

import stratego.Game;
import stratego.Player;
import stratego.Square;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the StepMover class which represents the piece can move one step once, and this inherits from Piece class.
 */
public class StepMover extends Piece {
    // the possible directions which this piece can move or attack
    private int[][] possibleDirections = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

    /**
     * It's the constructor which creates a piece can move one step once.
     * @param owner the owner of this piece
     * @param square the square where this piece placed
     * @param rank the rank of this piece
     */
    public StepMover(Player owner, Square square, int rank) {
        super(owner, square, rank);
    }

    /**
     * It's the StepMover's getLegalMoves function which get the legal moves in four possible moves.
     * @return the legal moves
     */
    @Override
    public List<Square> getLegalMoves() {
        ArrayList<Square> legalMoves = new ArrayList<Square>();
        // get the current square
        Square currentSquare = this.getSquare();
        // check if the current square is null
        if (currentSquare == null) {
            return legalMoves;
        }
        // get the row of this piece's current square
        int rowOfCurrentSquare = currentSquare.getRow();
        // get the col of this piece's current square
        int colOfCurrentSquare = currentSquare.getCol();
        // get the current game which this piece involved in
        Game currentGame = this.getSquare().getGame();

        //check every possible directions
        for (int i = 0; i < possibleDirections.length; i++) {
            int rowOfPossibleSquare = rowOfCurrentSquare + possibleDirections[i][0];
            int colOfPossibleSquare = colOfCurrentSquare + possibleDirections[i][1];
            if (rowOfPossibleSquare >= 0 && rowOfPossibleSquare < currentGame.WIDTH && colOfPossibleSquare >= 0 && colOfPossibleSquare < currentGame.HEIGHT) {
                Square possibleSquare = currentGame.getSquare(rowOfPossibleSquare, colOfPossibleSquare);
                if (possibleSquare.canBeEntered()) {
                    legalMoves.add(possibleSquare);
                }
            }
        }

        return legalMoves;
    }

    @Override
    public List<Square> getLegalAttacks() {
        ArrayList<Square> legalAttacks = new ArrayList<Square>();
        // get the current square
        Square currentSquare = this.getSquare();
        // check if the current square is null
        if (currentSquare == null) {
            return legalAttacks;
        }
        // get the row of this piece's current square
        int rowOfCurrentSquare = currentSquare.getRow();
        // get the col of this piece's current square
        int colOfCurrentSquare = currentSquare.getCol();
        // get the current game which this piece involved in
        Game currentGame = this.getSquare().getGame();

        //check every possible directions
        for (int i = 0; i < possibleDirections.length; i++) {
            int rowOfPossibleTargetSquare = rowOfCurrentSquare + possibleDirections[i][0];
            int colOfPossibleTargetSquare = colOfCurrentSquare + possibleDirections[i][1];
            if (rowOfPossibleTargetSquare >= 0 && rowOfPossibleTargetSquare < currentGame.WIDTH && colOfPossibleTargetSquare >= 0 && colOfPossibleTargetSquare < currentGame.HEIGHT) {
                Square possibleTargetSquare = currentGame.getSquare(rowOfPossibleTargetSquare, colOfPossibleTargetSquare);
                if (possibleTargetSquare.getPiece() != null) {
                    legalAttacks.add(possibleTargetSquare);
                }
            }
        }

        return legalAttacks;
    }


}
