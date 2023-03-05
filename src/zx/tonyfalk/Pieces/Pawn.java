package zx.tonyfalk.Pieces;

import zx.tonyfalk.ChessPiece;
import zx.tonyfalk.Piece;

public class Pawn implements ChessPiece {

    @Override
    public int value(int value) {
        return 2;
    }

    @Override
    public boolean isAllowedMove(int X1, int Y1, int X2, int Y2, Piece[][] board) {
        Piece piece = board[X1][Y1];
        if (board[X2][Y2] != null && board[X2][Y2].isWhite() == piece.isWhite()) {
            return false;
        }
        int rankDiff = Math.abs(Y2 - Y1);
        int fileDiff = Math.abs(X2 - X1);
        if (piece.isWhite()) {
            if (Y2 < Y1) {
                return false;
            }
        } else {
            if (Y2 > Y1) {
                return false;
            }
        }
        if (X1 == 1 || X1 == 6) {
            if (fileDiff == 0 && rankDiff <= 2 && board[X2][Y2] == null) {
                if (piece.isWhite()) {
                    if (Y2 - Y1 == 1) {
                        return true;
                    } else if (Y2 - Y1 == 2 && board[X1 + 1][Y1] == null) {
                        return true;
                    }
                } else {
                    if (Y1 - Y2 == 1) {
                        return true;
                    } else if (Y1 - Y2 == 2 && board[X1 - 1][Y1] == null) {
                        return true;
                    }
                }
            }
        }
        if (fileDiff == 0 && rankDiff == 1 && board[X2][Y2] == null) {
            return true;
        }
        // Check if the pawn is capturing diagonally
        if (fileDiff == 1 && rankDiff == 1) {
            if (board[X2][Y2] != null && board[X2][Y2].isWhite() != piece.isWhite()) {
                return true;
            }
        }
        // All other moves are illegal
        return false;
    }
}
