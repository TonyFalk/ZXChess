package zx.tonyfalk;

public interface ChessPiece {
    int value(int value);
    boolean isAllowedMove(int X1, int Y1, int X2, int Y2, Piece[][] board);
}
