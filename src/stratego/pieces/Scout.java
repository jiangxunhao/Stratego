package stratego.pieces;

import stratego.Game;
import stratego.Player;
import stratego.Square;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a Scout class which represents the Scout piece, and it inherits from Piece.
 */
public class Scout extends Piece {
    // the possible directions which Scout can move or attack
    private int[][] possibleDirections = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    private static final int RANK_SCOUT = 2;

    /**
     * It's the constructor which creates Scout piece.
     * @param owner the owner of this piece
     * @param square the square where this piece placed
     */
    public Scout(Player owner, Square square) {
        super(owner, square, RANK_SCOUT);
    }

    /**
     * It's an overridden function which gets the legal moves of Scout, because Scout can move more than one square once.
     * @return the legal moves of Scout
     */
    @Override
    public List<Square> getLegalMoves() {
        ArrayList<Square> legalMoves = new ArrayList<Square>();
        Square currentSquare = this.getSquare();
        if (currentSquare == null) {
            return legalMoves;
        }
        int rowOfCurrentSquare = currentSquare.getRow();
        int colOfCurrentSquare = currentSquare.getCol();
        Game currentGame = currentSquare.getGame();

        // check every possible direction until meet an occupied square or water square
        for (int i = 0; i < possibleDirections.length; i++) {
            int rowOfPossibleSquare = rowOfCurrentSquare + possibleDirections[i][0];
            int colOfPossibleSquare = colOfCurrentSquare + possibleDirections[i][1];
            while (rowOfPossibleSquare >= 0 && rowOfPossibleSquare < currentGame.WIDTH && colOfPossibleSquare >= 0 && colOfPossibleSquare < currentGame.HEIGHT) {
                Square possibleSquare = currentGame.getSquare(rowOfPossibleSquare, colOfPossibleSquare);
                if (possibleSquare.canBeEntered()) {
                    legalMoves.add(possibleSquare);
                } else {
                    break;
                }
                rowOfPossibleSquare += possibleDirections[i][0];
                colOfPossibleSquare += possibleDirections[i][1];
            }
        }

        return legalMoves;
    }

    @Override
    public List<Square> getLegalAttacks() {
        ArrayList<Square> legalAttacks = new ArrayList<Square>();
        Square currentSquare = this.getSquare();
        if (currentSquare == null) {
            return legalAttacks;
        }
        int rowOfCurrentSquare = currentSquare.getRow();
        int colOfCurrentSquare = currentSquare.getCol();
        Game currentGame = this.getSquare().getGame();
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
