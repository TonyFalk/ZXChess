package zx.tonyfalk.GUI;

import zx.tonyfalk.ChessBoard;
import zx.tonyfalk.Piece;
import zx.tonyfalk.PieceType;
import zx.tonyfalk.Pieces.Pawn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChessBoardGUI extends JFrame {

    private static final int BOARD_SIZE = 8;
    private static final int SQUARE_SIZE = 80;


    private final JLabel[][] squares = new JLabel[BOARD_SIZE][BOARD_SIZE];
    private ChessBoard chessBoard;

    public ChessBoardGUI(ChessBoard chessBoard) {
        setTitle("ZXChess");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                JLabel square = new JLabel();
                square.setPreferredSize(new Dimension(SQUARE_SIZE, SQUARE_SIZE));
                square.setOpaque(true);
                square.setBackground((row + col) % 2 == 0 ? Assets.whitebored : Assets.blackbored);
                squares[row][col] = square;
                add(square);
            }
        }
        squares[0][0].setText(Assets.Rook);
        squares[0][1].setText(Assets.Knight);
        squares[0][2].setText(Assets.Bishop);
        squares[0][3].setText(Assets.Queen);
        squares[0][4].setText(Assets.King);
        squares[0][5].setText(Assets.Bishop);
        squares[0][6].setText(Assets.Knight);
        squares[0][7].setText(Assets.Rook);
        squares[7][0].setText(Assets.Rook);
        squares[7][1].setText(Assets.Knight);
        squares[7][2].setText(Assets.Bishop);
        squares[7][3].setText(Assets.Queen);
        squares[7][4].setText(Assets.King);
        squares[7][5].setText(Assets.Bishop);
        squares[7][6].setText(Assets.Knight);
        squares[7][7].setText(Assets.Rook);
        for (int col = 0; col < BOARD_SIZE; col++) {
            squares[1][col].setText(Assets.Pawn);
            squares[1][col].setForeground(Assets.blackpieces);
            squares[1][col].setFont(new Font(null, Font.BOLD, 72));
            squares[0][col].setForeground(Assets.blackpieces);
            squares[0][col].setFont(new Font(null, Font.BOLD, 72));
            squares[6][col].setText(Assets.Pawn);
            squares[6][col].setForeground(Assets.whitepieces);
            squares[6][col].setFont(new Font(null, Font.BOLD, 72));
            squares[7][col].setForeground(Assets.whitepieces);
            squares[7][col].setFont(new Font(null, Font.BOLD, 72));
        }
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                JLabel square = squares[i][j];
                int finalI = i;
                int finalJ = j;
                int finalI1 = i;
                int finalJ1 = j;
                square.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int[] squarecoords = getSquarePos(square);
                        Piece piece = chessBoard.selectedpiece;
                        chessBoard.printBoard();
                        if (chessBoard.selectedpiece != null) {
                            if (chessBoard.moveisAllowed(chessBoard.selectedpiece, squarecoords[0],squarecoords[1])) {
                                chessBoard.movePiece(piece.getXpos(), piece.getYpos(), squarecoords[0], squarecoords[1]);
                                if (chessBoard.isOccupied(piece.getXpos(),piece.getYpos())){
                                    System.out.println(piece.getXpos() + " " + piece.getYpos() + " PieceType " + piece.getType());
                                }
                                if (chessBoard.isOccupied(squarecoords[0],squarecoords[1])){
                                    System.out.println("occupied");
                                }
                                JLabel from = squares[piece.getXpos()][piece.getYpos()];
                                JLabel too = squares[squarecoords[0]][squarecoords[1]];
                                System.out.println(chessBoard.getPiece(piece.getXpos(), piece.getYpos()) + "from");
                                System.out.println(chessBoard.getPiece(squarecoords[0],squarecoords[1]) + "too");
                                setAsset(too, chessBoard.selectedpiece.getType(), !chessBoard.selectedpiece.isWhite());
                                from.setText("");
                                chessBoard.selectedpiece = new Piece(PieceType.Rook,false,3,3);
                                if(chessBoard.selectedpiece == null) {
                                    System.out.println("the selected piece no longer selected!");
                                }
                                return;
                            } else {
                                System.out.println("ILLEGAL MOVE!");
                                chessBoard.selectedpiece = null;
                                if(chessBoard.selectedpiece == null) {
                                    System.out.println("the selected piece no longer selected!");
                                }
                                return;
                            }
                            } else {
                                onclick(square);
                                chessBoard.selectedpiece = chessBoard.getPiece(squarecoords[0], squarecoords[1]);
                                return;
                            }
                    }
                });
            }
        }
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void setAsset(JLabel square,PieceType pieceType,boolean isWhite){
        Color piececolor = Assets.blackpieces;
        if (isWhite){
            piececolor = Assets.whitepieces;
        }
        square.setText(Assets.pieceTypeToString(pieceType));
        square.setForeground(piececolor);
        square.setFont(new Font(null, Font.BOLD, 72));
    }
    public int[] getSquarePos(JLabel square) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (squares[i][j] == square) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }
    public void onclick(JLabel square){
        int[] squarecoords = getSquarePos(square);
        if(Piece(square) != null) {
            if(square.getForeground() == Assets.blackpieces) {
                System.out.println("ClickListener " + Piece(square) + " Black location X - " + squarecoords[0] + "   Y - " + squarecoords[1]);
            } else {
                System.out.println("ClickListener " + Piece(square) + " White location X - " + squarecoords[0] + "   Y - " + squarecoords[1]);
            }
        } else {
            System.out.println("ClickListener Empty square location X - " + squarecoords[0] + "   Y - " + squarecoords[1]);
        }
    }
    public PieceType Piece(JLabel square){
        switch (square.getText()){
            case "♟":
                return PieceType.Pawn;
            case "♜":
                return PieceType.Rook;
            case "♞":
                return PieceType.Knight;
            case "♝":
                return PieceType.Bishop;
            case "♛":
                return PieceType.Queen;
            case "♚":
                return PieceType.King;
        }
        return null;
    }
}

