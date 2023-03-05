package zx.tonyfalk.Pieces;

import zx.tonyfalk.ChessPiece;
import zx.tonyfalk.Piece;

public class Bishop implements ChessPiece {
    @Override
    public int value(int value) {
        return 3;
    }

    @Override
    public boolean isAllowedMove(int X1, int Y1, int X2, int Y2, Piece[][] board) {
        Piece piece = board[X1][Y1];

        if (board[X2][Y2] != null && board[X2][Y2].isWhite() == piece.isWhite()) {
            return false;
        }

        int rankDiff = Math.abs(Y2 - Y1);
        int fileDiff = Math.abs(X2 - X1);
        if (fileDiff == rankDiff) {
            int xStep = X2 > X1 ? 1 : X2 < X1 ? -1 : 0;
            int yStep = Y2 > Y1 ? 1 : Y2 < Y1 ? -1 : 0;
            int x = X1 + xStep;
            int y = Y1 + yStep;
            while (x != X2 || y != Y2) {
                if (board[x][y] != null) {
                    return false; // Path is not clear
                }
                x += xStep;
                y += yStep;
            }

            return true;
        }

        // All other moves are illegal
        return false;
    }
}
