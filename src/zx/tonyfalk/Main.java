package zx.tonyfalk;

import zx.tonyfalk.GUI.ChessBoardGUI;
import zx.tonyfalk.GUI.ConsoleGUI;
import zx.tonyfalk.Pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<ChessPiece> chessPieces = new ArrayList<>();
        Main main = new Main();
        chessPieces.add(new Pawn());
        chessPieces.add(new Knight());
        chessPieces.add(new Rook());
        chessPieces.add(new Queen());
        chessPieces.add(new Bishop());
        chessPieces.add(new King());
        ChessPieceCenter chessPieceCenter = new ChessPieceCenter(chessPieces);
        ChessBoard chessBoard = new ChessBoard(chessPieceCenter,main);
        ChessBoardGUI chessBoardGUI = new ChessBoardGUI(chessBoard);
        chessBoardGUI.setVisible(true);
        ConsoleGUI gui = new ConsoleGUI();
        gui.setVisible(true);
    }
}