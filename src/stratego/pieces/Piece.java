package stratego.pieces;

import stratego.CombatResult;
import stratego.Player;
import stratego.Square;

import java.util.List;

/**
 * This is the abstract Piece class which represents the piece.
 */
public abstract class Piece {
    // the owner of this piece
    private Player owner;
    // the square where this piece placed
    private Square square;
    // the rank of this piece
    private int rank;

    /**
     * It's the constructor which creates the piece.
     * @param owner the owner of this piece
     * @param square the square where this piece placed
     * @param rank the rank of this piece
     */
    public Piece(Player owner, Square square, int rank) {
        this.owner = owner;
        this.square = square;
        this.rank = rank;
        square.placePiece(this);
    }

    /**
     * It's a function which gets the list of the square where this piece can move to.
     * @return the list of the square where this piece can move to
     */
    public abstract List<Square> getLegalMoves();

    /**
     * It's a function which gets the list of the square where this piece can attack.
     * @return the list of the square where this piece can attack
     */
    public abstract List<Square> getLegalAttacks();

    /**
     * It's a function which make this piece move to the given square.
     * @param toSquare the destination where this piece move to
     */
    public void move(Square toSquare) {
        // clear the piece on the current square
        this.getSquare().removePiece();
        // place this piece to the new square
        toSquare.placePiece(this);
        // set the square of this piece as new square
        this.square = toSquare;
    }

    /**
     * It's a function which represent the situation that this piece attack the target square.
     * @param targetSquare the target square which is attacked
     */
    public void attack(Square targetSquare) {
        // get the result of combat between this piece and the piece on the target square
        CombatResult combatResult = resultWhenAttacking(targetSquare.getPiece());
        if (combatResult == CombatResult.WIN) {
            // if this piece win, it captures the target piece and move to the target square
            targetSquare.getPiece().beCaptured();
            move(targetSquare);
        } else if (combatResult == CombatResult.LOSE) {
            // if this piece lose, it is captured
            this.beCaptured();
        } else if (combatResult == CombatResult.DRAW) {
            // if the result is draw, both of this piece and target piece are captured
            targetSquare.getPiece().beCaptured();
            this.beCaptured();
        }
    }

    /**
     * It's a function which gets the result of the combat between targetPiece and this Piece.
     * @param targetPiece the Piece involved in this combat
     * @return the result of the combat between targetPiece and this Piece
     */
    public CombatResult resultWhenAttacking(Piece targetPiece) {
        // get the rank of this piece
        int rankOfCurrentPiece = this.getRank();
        // get the rank of target piece
        int rankOfTargetPiece = targetPiece.getRank();
        CombatResult combatResult;

        if (targetPiece instanceof Bomb || rankOfCurrentPiece == rankOfTargetPiece) {
            // if target piece is a Bomb or the rank of two piece is the same, then the combat result is draw
            combatResult = CombatResult.DRAW;
        } else if (rankOfCurrentPiece > rankOfTargetPiece) {
            // if this piece's rank is higher than target piece's, then this piece win
            combatResult = CombatResult.WIN;
        } else {
            // if this piece's rank is lower than target piece's, then this piece lose
            combatResult = CombatResult.LOSE;
        }

        return combatResult;
    }

    /**
     * It's a function which is called when the Piece is destroyed.
     */
    public void beCaptured() {
        this.getSquare().removePiece();
        this.square = null;
    }

    /**
     * It's a function which gets the Square of this Piece.
     * @return the Square of this Piece
     */
    public Square getSquare() {
        return square;
    }

    /**
     * It's a function which gets the owner of this Piece.
     * @return the owner of this Piece
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * It's a function which gets the rank of this Piece.
     * @return the rank of this Piece
     */
    public int getRank() {
        return rank;
    }
}
