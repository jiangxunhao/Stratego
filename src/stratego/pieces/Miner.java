package stratego.pieces;

import stratego.CombatResult;
import stratego.Player;
import stratego.Square;

/**
 * This is Miner class which represents the Miner piece.
 */
public class Miner extends StepMover {
    /**
     * It's the rank of Miner.
     */
    public static final int RANK_MINER = 3;

    /**
     * It's the constructor which creates the Miner piece.
     * @param owner the owner of Miner piece
     * @param square the square where this Miner piece placed
     */
    public Miner(Player owner, Square square) {
        super(owner, square, RANK_MINER);
    }

    /**
     * It's an overridden function which represents the situation that a Miner attack other piece.
     * @param targetPiece the Piece involved in this combat
     * @return the result of combat
     */
    @Override
    public CombatResult resultWhenAttacking(Piece targetPiece) {
        CombatResult combatResult;
        int rankOfCurrentPiece = this.getRank();
        int rankOfTargetPiece = targetPiece.getRank();
        if (targetPiece instanceof Bomb || rankOfCurrentPiece > rankOfTargetPiece) {
            // if this Miner attack a Bomb, then it will beat the Bomb and will not be captured.
            combatResult = CombatResult.WIN;
        } else if (rankOfCurrentPiece == rankOfTargetPiece) {
            combatResult = CombatResult.DRAW;
        } else {
            combatResult = CombatResult.LOSE;
        }
        return combatResult;
    }
}
