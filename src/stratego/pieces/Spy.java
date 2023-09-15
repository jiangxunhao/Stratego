package stratego.pieces;

import stratego.CombatResult;
import stratego.Player;
import stratego.Square;

/**
 * This is the Spy class which represents the Spy piece, and it inherits from StepMover.
 */
public class Spy extends StepMover {
    /**
     * It's the rank of marshal.
     */
    public static final int RANK_MARSHAL = 10;

    /**
     * It's the constructor which creates a Spy piece.
     * @param owner the owner of this Spy piece
     * @param square the square where this Spy piece placed
     */
    public Spy(Player owner, Square square) {
        super(owner, square, 0);
    }

    /**
     * It's an overridden function which represents that this spy attack other piece.
     * Spy can beat the marshal piece if spy attack marshal firstly.
     * @param targetPiece the Piece involved in this combat
     * @return the result of combat
     */
    @Override
    public CombatResult resultWhenAttacking(Piece targetPiece) {
        CombatResult combatResult;
        int rankOfTargetPiece = targetPiece.getRank();
        if (rankOfTargetPiece == RANK_MARSHAL) {
            // spy can beat the marshal if spy attack marshal firstly.
            combatResult = CombatResult.WIN;
        } else if (targetPiece instanceof Spy) {
            // a spy attacks other spy, the result is draw.
            combatResult = CombatResult.DRAW;
        } else {
            // spy cannot beat other piece.
            combatResult = CombatResult.LOSE;
        }
        return combatResult;
    }
}
