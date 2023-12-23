package ConsoleChessGame;

public class Player {

    //White Pieces
    public static King whiteKing=new King(PieceColour.WHITE,false);
    public static Queen whiteQueen=new Queen(PieceColour.WHITE,false);
    public static Rook whiteRook=new Rook(PieceColour.WHITE,false);

    public static Rook whiteRook1=new Rook(PieceColour.WHITE,false);

    public static Knight whiteKnight=new Knight(PieceColour.WHITE,false);

    public static Knight whiteKnight1=new Knight(PieceColour.WHITE,false);
    public static Bishop whiteBishop=new Bishop(PieceColour.WHITE,false);
    public static Bishop whiteBishop1=new Bishop(PieceColour.WHITE,false);


    public static Pawn pawnWhite1=new Pawn(PieceColour.WHITE,false);
    public static Pawn pawnWhite2=new Pawn(PieceColour.WHITE,false);
    public static Pawn pawnWhite3=new Pawn(PieceColour.WHITE,false);
    public static Pawn pawnWhite4=new Pawn(PieceColour.WHITE,false);
    public static Pawn pawnWhite5=new Pawn(PieceColour.WHITE,false);
    public static Pawn pawnWhite6=new Pawn(PieceColour.WHITE,false);
    public static Pawn pawnWhite7=new Pawn(PieceColour.WHITE,false);
    public static Pawn pawnWhite8=new Pawn(PieceColour.WHITE,false);

    //Black Pieces
    public static King blackKing=new King(PieceColour.BLACK,false);
    public static Queen blackQueen=new Queen(PieceColour.BLACK,false);
    public static Rook blackRook=new Rook(PieceColour.BLACK,false);
    public static Knight blackKnight=new Knight(PieceColour.BLACK,false);
    public static Bishop blackBishop=new Bishop(PieceColour.BLACK,false);
    public static Rook blackRook1=new Rook(PieceColour.BLACK,false);
    public static Knight blackKnight1=new Knight(PieceColour.BLACK,false);
    public static Bishop blackBishop1=new Bishop(PieceColour.BLACK,false);

    public static Pawn pawnBlack1=new Pawn(PieceColour.BLACK,false);
    public static Pawn pawnBlack2=new Pawn(PieceColour.BLACK,false);
    public static Pawn pawnBlack3=new Pawn(PieceColour.BLACK,false);
    public static Pawn pawnBlack4=new Pawn(PieceColour.BLACK,false);
    public static Pawn PawnBlack5=new Pawn(PieceColour.BLACK,false);
    public static Pawn pawnBlack6=new Pawn(PieceColour.BLACK,false);
    public static Pawn PawnBlack7=new Pawn(PieceColour.BLACK,false);
    public static Pawn pawnBlack8=new Pawn(PieceColour.BLACK,false);

    public static void initialisePosition(){
        Board.piece[0][0]=whiteRook;
        Board.piece[0][1]=whiteKnight;
        Board.piece[0][2]=whiteBishop;
        Board.piece[0][3]=whiteKing;
        Board.piece[0][4]=whiteQueen;
        Board.piece[0][5]=whiteBishop1;
        Board.piece[0][6]=whiteKnight1;
        Board.piece[0][7]=whiteRook1;

        Board.piece[1][0]=pawnWhite1;
        Board.piece[1][1]=pawnWhite2;
        Board.piece[1][2]=pawnWhite3;
        Board.piece[1][3]=pawnWhite4;
        Board.piece[1][4]=pawnWhite5;
        Board.piece[1][5]=pawnWhite6;
        Board.piece[1][6]=pawnWhite7;
        Board.piece[1][7]=pawnWhite8;

        Board.piece[7][0]=blackRook;
        Board.piece[7][1]=blackKnight;
        Board.piece[7][2]=blackBishop;
        Board.piece[7][3]=blackKing;
        Board.piece[7][4]=blackQueen;
        Board.piece[7][5]=blackBishop1;
        Board.piece[7][6]=blackKnight1;
        Board.piece[7][7]=blackRook1;

        Board.piece[6][0]=pawnBlack1;
        Board.piece[6][1]=pawnBlack2;
        Board.piece[6][2]=pawnBlack3;
        Board.piece[6][3]=pawnBlack4;
        Board.piece[6][4]=PawnBlack5;
        Board.piece[6][5]=pawnBlack6;
        Board.piece[6][6]=PawnBlack7;
        Board.piece[6][7]=pawnBlack8;

    }
}
