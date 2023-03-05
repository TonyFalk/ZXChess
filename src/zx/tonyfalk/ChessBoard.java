package zx.tonyfalk;


import zx.tonyfalk.GUI.Assets;

public class ChessBoard {
    private Piece[][] board;
    public Piece selectedpiece;
    private Main main;
    private ChessPieceCenter chessPieceCenter;

    public ChessBoard(ChessPieceCenter chessPieceCenter, Main main) {
        this.main = main;
        this.chessPieceCenter = chessPieceCenter;
        board = new Piece[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        board[0][0] = new Piece(PieceType.Rook, true, 0, 0);
        board[0][1] = new Piece(PieceType.Knight, true, 0, 1);
        board[0][2] = new Piece(PieceType.Bishop, true, 0, 2);
        board[0][3] = new Piece(PieceType.Queen, true, 0, 3);
        board[0][4] = new Piece(PieceType.King, true, 0, 4);
        board[0][5] = new Piece(PieceType.Bishop, true, 0, 5);
        board[0][6] = new Piece(PieceType.Knight, true, 0, 6);
        board[0][7] = new Piece(PieceType.Rook, true, 0, 7);
        board[7][0] = new Piece(PieceType.Rook, false, 7, 0);
        board[7][1] = new Piece(PieceType.Knight, false, 7, 1);
        board[7][2] = new Piece(PieceType.Bishop, false, 7, 2);
        board[7][3] = new Piece(PieceType.Queen, false, 7, 3);
        board[7][4] = new Piece(PieceType.King, false, 7, 4);
        board[7][5] = new Piece(PieceType.Bishop, false, 7, 5);
        board[7][6] = new Piece(PieceType.Knight, false, 7, 6);
        board[7][7] = new Piece(PieceType.Rook, false, 7, 7);
        for (int col = 0; col < 8; col++) {
            board[1][col] = new Piece(PieceType.Pawn, true, 1, col);
            board[6][col] = new Piece(PieceType.Pawn, false, 6, col);
        }
    }

    public boolean moveisAllowed(Piece piece, int X2, int Y2) {
       System.out.println("moveisAllowed pieceLocation X - " + piece.getXpos() + " Y - " + piece.getYpos() + " pieceType - " + piece.getType() + " returns " + chessPieceCenter.isAllowedMove(piece.getXpos(), piece.getYpos(), X2, Y2, board));
       return chessPieceCenter.isAllowedMove(piece.getXpos(), piece.getYpos(), X2, Y2, board);
    }
    public Piece getPiece(int x, int y) {
        if (board[x][y] == null) {
            return selectedpiece;
        }
        System.out.println("getPiece X - " + x +" Y - " + y + " returns - " + board[x][y].toString());
        return board[x][y];
    }
    public void setPiece(int x, int y, Piece piece) {
        board[x][y] = piece;
        System.out.println("setPiece X - " + x +"   Y - " + y + "   piece - " + piece + "   result - " + board[x][y].toString());
    }
    public void movePiece(int startX, int startY, int endX, int endY) {
        Piece piece = board[startX][startY];
        board[endX][endY] = piece;
        board[startX][startY] = null;
        System.out.println("movePiece startX - " + startX + "   startY - " + startY + "   endX - " + endX + "   endY - " + endY + "   startPiece - " + board[startX][startY] + "   endPiece - " + board[endX][endY]);
    }

    public boolean isOccupied(int x, int y) {
        System.out.println("isOccupied x - " + x + "   y - " + y + "   returns " + board[x][y] != null);
        return board[x][y] != null;
    }

    public void printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (board[x][y] == null) {
                    sb.append(" - ");
                } else {
                    sb.append((board[x][y].getType()).toString().charAt(0)).append(" ");
                }
            }
            sb.append("\n").append(" ");
        }
        System.out.println(sb.toString());
    }
}
