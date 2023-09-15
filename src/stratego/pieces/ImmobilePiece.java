package stratego.pieces;

import stratego.Player;
import stratego.Square;

import java.util.ArrayList;
import java.util.List;

/**
 * This is an abstract ImmobilePiece class which represents the piece that cannot move and attack.
 */
public abstract class ImmobilePiece extends Piece {

    /**
     * It's the constructor which creates the immobile piece.
     * @param owner the owner of the immobile piece
     * @param square the square where the immobile piece placed
     * @param rank the rank of the immobile piece
     */
    public ImmobilePiece(Player owner, Square square, int rank) {
        super(owner, square, rank);
    }

    /**
     * Immobile piece cannot move, so it return an empty list of legal moves.
     * @return an empty list of legal moves
     */
    @Override
    public List<Square> getLegalMoves() {
        ArrayList<Square> legalMoves = new ArrayList<Square>();
        return legalMoves;
    }

    /**
     * Immobile piece cannot attack, so it return an empty list of legal attacks.
     * @return an empty list of legal attacks
     */
    @Override
    public List<Square> getLegalAttacks() {
        ArrayList<Square> legalAttacks = new ArrayList<Square>();
        return legalAttacks;
    }
}
