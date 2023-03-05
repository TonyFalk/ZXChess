package zx.tonyfalk;

import java.util.Set;

public class Piece {
    private final PieceType type;
    private final boolean isWhite;
    private boolean hasMoved;
    private int xpos;
    private int ypos;

    public Piece(PieceType type, boolean isWhite,int xpos,int ypos) {
        this.type = type;
        this.isWhite = isWhite;
        this.hasMoved = false;
        this.xpos = xpos;
        this.ypos = ypos;
    }

    public PieceType getType() {
        return type;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public boolean hasMoved() {
        return hasMoved;
    }

    public void setMoved(boolean moved) {
        hasMoved = moved;
    }

    public int getXpos() {
        return xpos;
    }

    public int getYpos() {
        return ypos;
    }
}
