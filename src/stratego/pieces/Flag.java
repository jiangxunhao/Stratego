package stratego.pieces;

import stratego.Player;
import stratego.Square;

/**
 * This is the Flag class which represents the Flag piece, and it inherits from ImmobilePiece.
 */
public class Flag extends ImmobilePiece {

    /**
     * It's the constructor which creates the Flag piece, and set the rank of Bomb as impossible value(0).
     * @param owner the owner of the Flag
     * @param square the square where the Flag placed
     */
    public Flag(Player owner, Square square) {
        super(owner, square, 0);
    }

    /**
     * It's an overridden function which represents the flag be captured, and this will cause the owner of flag lose game.
     */
    @Override
    public void beCaptured() {
        super.beCaptured();
        this.getOwner().loseGame();
    }
}
