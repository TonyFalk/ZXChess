package zx.tonyfalk.Pieces;

import zx.tonyfalk.ChessPiece;
import zx.tonyfalk.Piece;
import zx.tonyfalk.PieceType;

public class King implements ChessPiece {
    @Override
    public int value(int value) {
        return 100;
    }
    @Override
    public boolean isAllowedMove(int X1, int Y1, int X2, int Y2, Piece[][] board) {
        Piece piece = board[X1][Y1];
        if (board[X2][Y2] != null && board[X2][Y2].isWhite() == piece.isWhite()) {
            return false;
        }
        int rankDiff = Math.abs(Y2 - Y1);
        int fileDiff = Math.abs(X2 - X1);

        if (rankDiff <= 1 && fileDiff <= 1) {
            return true;
        }

        if (rankDiff == 0 && fileDiff == 2 && !piece.hasMoved()) {
            int rookX = X2 > X1 ? 7 : 0;
            Piece rook = board[rookX][Y1];
            if (rook.getType() == PieceType.Rook && !rook.hasMoved()) {
                int xStep = X2 > X1 ? 1 : -1;
                int x = X1 + xStep;
                while (x != rookX) {
                    if (board[x][Y1] != null) {
                        return false; // Path is not clear
                    }
                    x += xStep;
                }
                return true;
            }
        }
        return false;
    }
}
