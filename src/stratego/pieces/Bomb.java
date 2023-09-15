package stratego.pieces;

import stratego.Player;
import stratego.Square;

/**
 * This is the Bomb class which represents the Bomb piece, and it inherits from ImmobilePiece.
 */
public class Bomb extends ImmobilePiece {

    /**
     * It's the constructor which creates the Bomb piece, and set the rank of Bomb as impossible value(0).
     * @param owner the owner of Bomb
     * @param square the square where the Bomb placed
     */
    public Bomb(Player owner, Square square) {
        super(owner, square, 0);
    }
}
