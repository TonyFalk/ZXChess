package zx.tonyfalk;

import zx.tonyfalk.Pieces.Pawn;

import java.util.List;

public class ChessPieceCenter {
    private List<ChessPiece> chessPieces;

    public ChessPieceCenter(List<ChessPiece> chessPieces) {
        this.chessPieces = chessPieces;
    }
    public int getIndexByPieceType(PieceType pieceType) {
        int index = -1;
        for (int i = 0; i < this.chessPieces.size(); i++) {
            if (this.chessPieces.get(i).getClass().getSimpleName().equalsIgnoreCase(pieceType.name())) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int getValue(PieceType pieceType, int value) {
        int index = getIndexByPieceType(pieceType);
        return this.chessPieces.get(index).value(value);
    }

    public boolean isAllowedMove(int X1, int Y1, int X2, int Y2, Piece[][] board) {
        try {
            PieceType pieceType = board[X1][Y1].getType();
            if (pieceType == null) {
                return false;
            }
            int index = getIndexByPieceType(pieceType);
            return this.chessPieces.get(index).isAllowedMove(X1, Y1, X2, Y2, board);
        } catch (NullPointerException e) {
            System.out.println("Error Stacktrace: "+ e);
      return false;  }
    }
}
