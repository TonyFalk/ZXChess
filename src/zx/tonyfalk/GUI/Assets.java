package zx.tonyfalk.GUI;

import zx.tonyfalk.PieceType;

import java.awt.*;

public class Assets {
    static String Pawn = "♟";
    static String Rook = "♜";
    static String Knight = "♞";
    static String Bishop = "♝";
    static String Queen = "♛";
    static String King = "♚";
    static Color whitepieces = new Color(210,200,160);
    static Color blackpieces = new Color(30,30,30);
    static Color whitebored = new Color(170,170,170);
    static Color blackbored = new Color(64,64,64);
    static Color moveoptionsbored = new Color(210,60,60);
    public static String pieceTypeToString(PieceType pieceType){
        switch (pieceType){
            case Pawn:
                return Pawn;
            case Bishop:
                return Bishop;
            case Rook:
                return Rook;
            case Knight:
                return Knight;
            case King:
                return King;
            case Queen:
                return Queen;
        }
    return null;
    }
}
