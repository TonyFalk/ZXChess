package zx.tonyfalk.Pieces;

import zx.tonyfalk.ChessPiece;
import zx.tonyfalk.Piece;

public class Knight implements ChessPiece {
    @Override
    public int value(int value) {
        return 4;
    }
    @Override
    public boolean isAllowedMove(int X1, int Y1, int X2, int Y2, Piece[][] board) {
        Piece piece = board[X1][Y1];
        if (board[X2][Y2] != null && board[X2][Y2].isWhite() == piece.isWhite()) {
            return false;
        }
        int rankDiff = Math.abs(Y2 - Y1);
        int fileDiff = Math.abs(X2 - X1);
        if ((fileDiff == 2 && rankDiff == 1) || (fileDiff == 1 && rankDiff == 2)) {
            return true;
        }
        return false;
    }
}
